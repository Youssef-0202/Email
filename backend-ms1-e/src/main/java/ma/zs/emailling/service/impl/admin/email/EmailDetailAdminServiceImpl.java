package ma.zs.emailling.service.impl.admin.email;


import ma.zs.emailling.bean.core.email.EmailDetail;
import ma.zs.emailling.dao.criteria.core.email.EmailDetailCriteria;
import ma.zs.emailling.dao.facade.core.email.EmailDetailDao;
import ma.zs.emailling.dao.specification.core.email.EmailDetailSpecification;
import ma.zs.emailling.service.facade.admin.email.EmailDetailAdminService;
import ma.zs.emailling.zynerator.service.AbstractServiceImpl;
import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.emailling.service.facade.admin.commun.EtatEmailAdminService ;
import ma.zs.emailling.service.facade.admin.email.EmailAdminService ;
import ma.zs.emailling.service.facade.admin.commun.UtilisateurAdminService ;

@Service
public class EmailDetailAdminServiceImpl extends AbstractServiceImpl<EmailDetail, EmailDetailCriteria, EmailDetailDao> implements EmailDetailAdminService {






    public void findOrSaveAssociatedObject(EmailDetail t){
        if( t != null) {
            t.setEmail(emailService.findOrSave(t.getEmail()));
            t.setPersonneDestinataire(utilisateurService.findOrSave(t.getPersonneDestinataire()));
            t.setEtatEmail(etatEmailService.findOrSave(t.getEtatEmail()));
        }
    }

    public List<EmailDetail> findByEmailId(Long id){
        return dao.findByEmailId(id);
    }
    public int deleteByEmailId(Long id){
        return dao.deleteByEmailId(id);
    }
    public long countByEmailRef(String ref){
        return dao.countByEmailRef(ref);
    }
    public List<EmailDetail> findByPersonneDestinataireId(Long id){
        return dao.findByPersonneDestinataireId(id);
    }
    public int deleteByPersonneDestinataireId(Long id){
        return dao.deleteByPersonneDestinataireId(id);
    }
    public long countByPersonneDestinataireUsername(String username){
        return dao.countByPersonneDestinataireUsername(username);
    }
    public List<EmailDetail> findByEtatEmailId(Long id){
        return dao.findByEtatEmailId(id);
    }
    public int deleteByEtatEmailId(Long id){
        return dao.deleteByEtatEmailId(id);
    }
    public long countByEtatEmailCode(String code){
        return dao.countByEtatEmailCode(code);
    }

    @Override
    public List<EmailDetail> findByPersonneDestinataireUsername(String username) {
        return dao.findByPersonneDestinataireUsername(username);
    }

    public void configure() {
        super.configure(EmailDetail.class, EmailDetailSpecification.class);
    }


    @Autowired
    private EtatEmailAdminService etatEmailService ;
    @Autowired
    private EmailAdminService emailService ;
    @Autowired
    private UtilisateurAdminService utilisateurService ;

    public EmailDetailAdminServiceImpl(EmailDetailDao dao) {
        super(dao);
    }

}
