package ma.zs.emailling.service.impl.admin.emailgroup;


import ma.zs.emailling.bean.core.emailgroup.GroupeEmailDetail;
import ma.zs.emailling.dao.criteria.core.emailgroup.GroupeEmailDetailCriteria;
import ma.zs.emailling.dao.facade.core.emailgroup.GroupeEmailDetailDao;
import ma.zs.emailling.dao.specification.core.emailgroup.GroupeEmailDetailSpecification;
import ma.zs.emailling.service.facade.admin.emailgroup.GroupeEmailDetailAdminService;
import ma.zs.emailling.zynerator.service.AbstractServiceImpl;
import ma.zs.emailling.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.emailling.service.facade.admin.commun.UtilisateurAdminService ;
import ma.zs.emailling.bean.core.commun.Utilisateur ;
import ma.zs.emailling.service.facade.admin.emailgroup.GroupeEmailAdminService ;
import ma.zs.emailling.bean.core.emailgroup.GroupeEmail ;

import java.util.List;
@Service
public class GroupeEmailDetailAdminServiceImpl extends AbstractServiceImpl<GroupeEmailDetail, GroupeEmailDetailCriteria, GroupeEmailDetailDao> implements GroupeEmailDetailAdminService {



    @Autowired
    private   GroupeEmailDetailDao groupeEmailDetailDao;
    @Override
    public GroupeEmailDetail create(GroupeEmailDetail groupeEmailDetail) {
        groupeEmailDetail.setDateAjoute(LocalDateTime.now());


        return super.create(groupeEmailDetail);}







    public void findOrSaveAssociatedObject(GroupeEmailDetail t){
        if( t != null) {
            t.setPersonne(utilisateurService.findOrSave(t.getPersonne()));
            t.setGroupeEmail(groupeEmailService.findOrSave(t.getGroupeEmail()));
        }
    }

    public List<GroupeEmailDetail> findByPersonneId(Long id){
        return dao.findByPersonneId(id);
    }
    public int deleteByPersonneId(Long id){
        return dao.deleteByPersonneId(id);
    }
    public long countByPersonneUsername(String username){
        return dao.countByPersonneUsername(username);
    }
    public List<GroupeEmailDetail> findByGroupeEmailId(Long id){
        return dao.findByGroupeEmailId(id);
    }
    public int deleteByGroupeEmailId(Long id){
        return dao.deleteByGroupeEmailId(id);
    }
    public long countByGroupeEmailId(Long id){
        return dao.countByGroupeEmailId(id);
    }






    public void configure() {
        super.configure(GroupeEmailDetail.class, GroupeEmailDetailSpecification.class);
    }


    @Autowired
    private UtilisateurAdminService utilisateurService ;
    @Autowired
    private GroupeEmailAdminService groupeEmailService ;

    public GroupeEmailDetailAdminServiceImpl(GroupeEmailDetailDao dao) {
        super(dao);
    }

}
