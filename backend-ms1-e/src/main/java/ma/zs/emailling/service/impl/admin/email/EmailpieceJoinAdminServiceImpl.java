package ma.zs.emailling.service.impl.admin.email;


import ma.zs.emailling.bean.core.email.EmailpieceJoin;
import ma.zs.emailling.dao.criteria.core.email.EmailpieceJoinCriteria;
import ma.zs.emailling.dao.facade.core.email.EmailpieceJoinDao;
import ma.zs.emailling.dao.specification.core.email.EmailpieceJoinSpecification;
import ma.zs.emailling.service.facade.admin.email.EmailpieceJoinAdminService;
import ma.zs.emailling.zynerator.service.AbstractServiceImpl;
import ma.zs.emailling.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.emailling.service.facade.admin.email.EmailAdminService ;
import ma.zs.emailling.bean.core.email.Email ;
import ma.zs.emailling.service.facade.admin.commun.TypeContenuAdminService ;
import ma.zs.emailling.bean.core.commun.TypeContenu ;

import java.util.List;
@Service
public class EmailpieceJoinAdminServiceImpl extends AbstractServiceImpl<EmailpieceJoin, EmailpieceJoinCriteria, EmailpieceJoinDao> implements EmailpieceJoinAdminService {






    public void findOrSaveAssociatedObject(EmailpieceJoin t){
        if( t != null) {
            t.setEmail(emailService.findOrSave(t.getEmail()));
            t.setTypeContenu(typeContenuService.findOrSave(t.getTypeContenu()));
        }
    }

    public List<EmailpieceJoin> findByEmailId(Long id){
        return dao.findByEmailId(id);
    }
    public int deleteByEmailId(Long id){
        return dao.deleteByEmailId(id);
    }
    public long countByEmailRef(String ref){
        return dao.countByEmailRef(ref);
    }
    public List<EmailpieceJoin> findByTypeContenuId(Long id){
        return dao.findByTypeContenuId(id);
    }
    public int deleteByTypeContenuId(Long id){
        return dao.deleteByTypeContenuId(id);
    }
    public long countByTypeContenuCode(String code){
        return dao.countByTypeContenuCode(code);
    }






    public void configure() {
        super.configure(EmailpieceJoin.class, EmailpieceJoinSpecification.class);
    }


    @Autowired
    private EmailAdminService emailService ;
    @Autowired
    private TypeContenuAdminService typeContenuService ;

    public EmailpieceJoinAdminServiceImpl(EmailpieceJoinDao dao) {
        super(dao);
    }

}
