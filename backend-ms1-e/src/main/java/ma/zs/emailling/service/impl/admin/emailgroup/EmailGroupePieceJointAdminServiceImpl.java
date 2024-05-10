package ma.zs.emailling.service.impl.admin.emailgroup;


import ma.zs.emailling.bean.core.emailgroup.EmailGroupePieceJoint;
import ma.zs.emailling.dao.criteria.core.emailgroup.EmailGroupePieceJointCriteria;
import ma.zs.emailling.dao.facade.core.emailgroup.EmailGroupePieceJointDao;
import ma.zs.emailling.dao.specification.core.emailgroup.EmailGroupePieceJointSpecification;
import ma.zs.emailling.service.facade.admin.emailgroup.EmailGroupePieceJointAdminService;
import ma.zs.emailling.zynerator.service.AbstractServiceImpl;
import ma.zs.emailling.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.emailling.service.facade.admin.commun.TypeContenuAdminService ;
import ma.zs.emailling.bean.core.commun.TypeContenu ;
import ma.zs.emailling.service.facade.admin.emailgroup.GroupeEmailAdminService ;
import ma.zs.emailling.bean.core.emailgroup.GroupeEmail ;

import java.util.List;
@Service
public class EmailGroupePieceJointAdminServiceImpl extends AbstractServiceImpl<EmailGroupePieceJoint, EmailGroupePieceJointCriteria, EmailGroupePieceJointDao> implements EmailGroupePieceJointAdminService {






    public void findOrSaveAssociatedObject(EmailGroupePieceJoint t){
        if( t != null) {
            t.setTypecontenu(typeContenuService.findOrSave(t.getTypecontenu()));
            t.setGroupeEmail(groupeEmailService.findOrSave(t.getGroupeEmail()));
        }
    }

    public List<EmailGroupePieceJoint> findByTypecontenuId(Long id){
        return dao.findByTypecontenuId(id);
    }
    public int deleteByTypecontenuId(Long id){
        return dao.deleteByTypecontenuId(id);
    }
    public long countByTypecontenuCode(String code){
        return dao.countByTypecontenuCode(code);
    }
    public List<EmailGroupePieceJoint> findByGroupeEmailId(Long id){
        return dao.findByGroupeEmailId(id);
    }
    public int deleteByGroupeEmailId(Long id){
        return dao.deleteByGroupeEmailId(id);
    }
    public long countByGroupeEmailId(Long id){
        return dao.countByGroupeEmailId(id);
    }






    public void configure() {
        super.configure(EmailGroupePieceJoint.class, EmailGroupePieceJointSpecification.class);
    }


    @Autowired
    private TypeContenuAdminService typeContenuService ;
    @Autowired
    private GroupeEmailAdminService groupeEmailService ;

    public EmailGroupePieceJointAdminServiceImpl(EmailGroupePieceJointDao dao) {
        super(dao);
    }

}
