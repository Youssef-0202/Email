package ma.zs.emailling.service.impl.admin.emailgroup;


import ma.zs.emailling.bean.core.emailgroup.GroupeEmail;
import ma.zs.emailling.dao.criteria.core.emailgroup.GroupeEmailCriteria;
import ma.zs.emailling.dao.facade.core.emailgroup.GroupeEmailDao;
import ma.zs.emailling.dao.specification.core.emailgroup.GroupeEmailSpecification;
import ma.zs.emailling.service.facade.admin.emailgroup.GroupeEmailAdminService;
import ma.zs.emailling.zynerator.service.AbstractServiceImpl;
import ma.zs.emailling.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.zs.emailling.service.facade.admin.emailgroup.GroupeEmailDetailAdminService ;
import ma.zs.emailling.bean.core.emailgroup.GroupeEmailDetail ;
import ma.zs.emailling.service.facade.admin.commun.UtilisateurAdminService ;
import ma.zs.emailling.bean.core.commun.Utilisateur ;

import java.util.List;
@Service
public class GroupeEmailAdminServiceImpl extends AbstractServiceImpl<GroupeEmail, GroupeEmailCriteria, GroupeEmailDao> implements GroupeEmailAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public GroupeEmail create(GroupeEmail t) {
        GroupeEmail saved= super.create(t);
        if (saved != null && t.getGroupeEmailDetails() != null) {
                t.getGroupeEmailDetails().forEach(element-> {
                element.setGroupeEmail(saved);
                groupeEmailDetailService.create(element);
            });
        }
        return saved;

    }

    public GroupeEmail findWithAssociatedLists(Long id){
        GroupeEmail result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setGroupeEmailDetails(groupeEmailDetailService.findByGroupeEmailId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        groupeEmailDetailService.deleteByGroupeEmailId(id);
    }


    public void updateWithAssociatedLists(GroupeEmail groupeEmail){
    if(groupeEmail !=null && groupeEmail.getId() != null){
            List<List<GroupeEmailDetail>> resultGroupeEmailDetails= groupeEmailDetailService.getToBeSavedAndToBeDeleted(groupeEmailDetailService.findByGroupeEmailId(groupeEmail.getId()),groupeEmail.getGroupeEmailDetails());
            groupeEmailDetailService.delete(resultGroupeEmailDetails.get(1));
            ListUtil.emptyIfNull(resultGroupeEmailDetails.get(0)).forEach(e -> e.setGroupeEmail(groupeEmail));
            groupeEmailDetailService.update(resultGroupeEmailDetails.get(0),true);
        }
    }




    public void findOrSaveAssociatedObject(GroupeEmail t){
        if( t != null) {
            t.setAdminGroupe(utilisateurService.findOrSave(t.getAdminGroupe()));
        }
    }

    public List<GroupeEmail> findByAdminGroupeId(Long id){
        return dao.findByAdminGroupeId(id);
    }
    public int deleteByAdminGroupeId(Long id){
        return dao.deleteByAdminGroupeId(id);
    }
    public long countByAdminGroupeUsername(String username){
        return dao.countByAdminGroupeUsername(username);
    }






    public void configure() {
        super.configure(GroupeEmail.class, GroupeEmailSpecification.class);
    }


    @Autowired
    private GroupeEmailDetailAdminService groupeEmailDetailService ;
    @Autowired
    private UtilisateurAdminService utilisateurService ;

    public GroupeEmailAdminServiceImpl(GroupeEmailDao dao) {
        super(dao);
    }

}
