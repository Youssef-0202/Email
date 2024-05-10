package ma.zs.emailling.service.facade.admin.commun;

import java.util.List;
import ma.zs.emailling.bean.core.commun.Contact;
import ma.zs.emailling.bean.core.commun.Utilisateur;
import ma.zs.emailling.dao.criteria.core.commun.ContactCriteria;
import ma.zs.emailling.zynerator.service.IService;



public interface ContactAdminService extends  IService<Contact,ContactCriteria>  {

    boolean existsDestinationForSource(Utilisateur personneSource, Utilisateur personneDestination);

    Contact save(Contact contact);

    List<Contact> findByPersonneSourceId(Long id);
    int deleteByPersonneSourceId(Long id);
    long countByPersonneSourceUsername(String username);
    List<Contact> findByPersonneDestinationId(Long id);
    int deleteByPersonneDestinationId(Long id);
    long countByPersonneDestinationUsername(String username);




}
