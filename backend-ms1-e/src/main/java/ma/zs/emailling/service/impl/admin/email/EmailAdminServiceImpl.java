package ma.zs.emailling.service.impl.admin.email;


import ma.zs.emailling.bean.core.commun.CategoryEmail;
import ma.zs.emailling.bean.core.commun.EtatEmail;
import ma.zs.emailling.bean.core.commun.Utilisateur;
import ma.zs.emailling.bean.core.email.Email;
import ma.zs.emailling.bean.core.email.EmailDetail;
import ma.zs.emailling.bean.core.email.EmailpieceJoin;
import ma.zs.emailling.bean.core.emailgroup.EmailDetailGroup;
import ma.zs.emailling.dao.criteria.core.email.EmailCriteria;
import ma.zs.emailling.dao.facade.core.email.EmailDao;
import ma.zs.emailling.dao.specification.core.email.EmailSpecification;
import ma.zs.emailling.service.facade.admin.commun.CategoryEmailAdminService;
import ma.zs.emailling.service.facade.admin.commun.EtatEmailAdminService;
import ma.zs.emailling.service.facade.admin.commun.UtilisateurAdminService;
import ma.zs.emailling.service.facade.admin.email.EmailAdminService;
import ma.zs.emailling.service.facade.admin.email.EmailDetailAdminService;
import ma.zs.emailling.service.facade.admin.email.EmailpieceJoinAdminService;
import ma.zs.emailling.service.facade.admin.emailgroup.EmailDetailGroupAdminService;
import ma.zs.emailling.zynerator.service.AbstractServiceImpl;
import ma.zs.emailling.zynerator.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class EmailAdminServiceImpl extends AbstractServiceImpl<Email, EmailCriteria, EmailDao> implements EmailAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Email create(Email t) {
        LocalDateTime dateEnvoi = LocalDateTime.now();
        t.setDateEnvoi(dateEnvoi);

        Email saved= super.create(t);
        if (saved != null && t.getEmailDetails() != null) {
                t.getEmailDetails().forEach(element-> {
                element.setEmail(saved);
                emailDetailService.create(element);
            });
        }
        if (saved != null && t.getEmailpieceJoints() != null) {
                t.getEmailpieceJoints().forEach(element-> {
                element.setEmail(saved);
                emailpieceJoinService.create(element);
            });
        }
        if (saved != null && t.getEmailDetailGroups() != null) {
                t.getEmailDetailGroups().forEach(element-> {
                element.setEmail(saved);
                emailDetailGroupService.create(element);
            });
        }
        return saved;

    }

    public Email findByRef(String ref) {
        return dao.findByRef(ref);
    }

    public Email createEmail(Email email) {
        Email loadedEmail = findByRef(email.getRef());
        if (loadedEmail == null) {
            Email savedEmail = dao.save(email);
            return savedEmail;
        } else {
            return loadedEmail;
        }
    }


    @Override
    public Email sendEmail(Email email) {

        LocalDateTime dateEnvoi = LocalDateTime.now();
        email.setDateEnvoi(dateEnvoi);
        CategoryEmail categoryEmail = categoryEmailService.findByName(email.getCategoryEmail().getName());
        Utilisateur personneSource = utilisateurService.findByUsername(email.getPersonneSource().getUsername());
        EtatEmail etatEmail = etatEmailService.findByLibelle(email.getEtatEmail().getLibelle());
        email.setCategoryEmail(categoryEmail);
        email.setPersonneSource(personneSource);
        email.setEtatEmail(etatEmail);



        Email savedEmail= createEmail(email);


        if (savedEmail != null) {
            if (email.getEmailDetails() != null) {
                email.getEmailDetails().forEach(detail -> {
                    detail.setEmail(savedEmail);
                    emailDetailService.create(detail);
                });
            }


            if (email.getEmailpieceJoints() != null) {
                email.getEmailpieceJoints().forEach(piece -> {
                    piece.setEmail(savedEmail);
                    emailpieceJoinService.create(piece);
                });
            }


            if (email.getEmailDetailGroups() != null) {
                email.getEmailDetailGroups().forEach(group -> {
                    group.setEmail(savedEmail);
                    emailDetailGroupService.create(group);
                });
            }
        }



        return savedEmail;

    }


    public Email findWithAssociatedLists(Long id){
        Email result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setEmailDetails(emailDetailService.findByEmailId(id));
            result.setEmailpieceJoints(emailpieceJoinService.findByEmailId(id));
            result.setEmailDetailGroups(emailDetailGroupService.findByEmailId(id));
        }
        return result;
    }

    @Transactional
    public void deleteAssociatedLists(Long id) {
        emailDetailService.deleteByEmailId(id);
        emailpieceJoinService.deleteByEmailId(id);
        emailDetailGroupService.deleteByEmailId(id);
    }


    public void updateWithAssociatedLists(Email email){
    if(email !=null && email.getId() != null){
            List<List<EmailDetail>> resultEmailDetails= emailDetailService.getToBeSavedAndToBeDeleted(emailDetailService.findByEmailId(email.getId()),email.getEmailDetails());
            emailDetailService.delete(resultEmailDetails.get(1));
            ListUtil.emptyIfNull(resultEmailDetails.get(0)).forEach(e -> e.setEmail(email));
            emailDetailService.update(resultEmailDetails.get(0),true);
            List<List<EmailpieceJoin>> resultEmailpieceJoints= emailpieceJoinService.getToBeSavedAndToBeDeleted(emailpieceJoinService.findByEmailId(email.getId()),email.getEmailpieceJoints());
            emailpieceJoinService.delete(resultEmailpieceJoints.get(1));
            ListUtil.emptyIfNull(resultEmailpieceJoints.get(0)).forEach(e -> e.setEmail(email));
            emailpieceJoinService.update(resultEmailpieceJoints.get(0),true);
            List<List<EmailDetailGroup>> resultEmailDetailGroups= emailDetailGroupService.getToBeSavedAndToBeDeleted(emailDetailGroupService.findByEmailId(email.getId()),email.getEmailDetailGroups());
            emailDetailGroupService.delete(resultEmailDetailGroups.get(1));
            ListUtil.emptyIfNull(resultEmailDetailGroups.get(0)).forEach(e -> e.setEmail(email));
            emailDetailGroupService.update(resultEmailDetailGroups.get(0),true);
        }
    }




    public Email findByReferenceEntity(Email t){
        return t==null? null : dao.findByRef(t.getRef());
    }
    public void findOrSaveAssociatedObject(Email t){
        if( t != null) {
            t.setPersonneSource(utilisateurService.findOrSave(t.getPersonneSource()));
            t.setCategoryEmail(categoryEmailService.findOrSave(t.getCategoryEmail()));
            t.setEtatEmail(etatEmailService.findOrSave(t.getEtatEmail()));
        }
    }

    public List<Email> findByPersonneSourceId(Long id){
        return dao.findByPersonneSourceId(id);
    }
    public int deleteByPersonneSourceId(Long id){
        return dao.deleteByPersonneSourceId(id);
    }
    public long countByPersonneSourceUsername(String username){
        return dao.countByPersonneSourceUsername(username);
    }
    public List<Email> findByCategoryEmailId(Long id){
        return dao.findByCategoryEmailId(id);
    }
    public int deleteByCategoryEmailId(Long id){
        return dao.deleteByCategoryEmailId(id);
    }
    public long countByCategoryEmailCode(String code){
        return dao.countByCategoryEmailCode(code);
    }
    public List<Email> findByEtatEmailId(Long id){
        return dao.findByEtatEmailId(id);
    }
    public int deleteByEtatEmailId(Long id){
        return dao.deleteByEtatEmailId(id);
    }
    public long countByEtatEmailCode(String code){
        return dao.countByEtatEmailCode(code);
    }

    public List<Email> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Email.class, EmailSpecification.class);
    }


    @Autowired
    private EtatEmailAdminService etatEmailService ;
    @Autowired
    private EmailpieceJoinAdminService emailpieceJoinService ;
    @Autowired
    private EmailDetailGroupAdminService emailDetailGroupService ;
    @Autowired
    private UtilisateurAdminService utilisateurService ;
    @Autowired
    private CategoryEmailAdminService categoryEmailService ;
    @Autowired
    private EmailDetailAdminService emailDetailService ;

    public EmailAdminServiceImpl(EmailDao dao) {
        super(dao);
    }

}
