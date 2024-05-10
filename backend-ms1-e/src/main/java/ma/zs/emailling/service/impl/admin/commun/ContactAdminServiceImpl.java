package ma.zs.emailling.service.impl.admin.commun;


import ma.zs.emailling.bean.core.commun.Contact;
import ma.zs.emailling.dao.criteria.core.commun.ContactCriteria;
import ma.zs.emailling.dao.facade.core.commun.ContactDao;
import ma.zs.emailling.dao.specification.core.commun.ContactSpecification;
import ma.zs.emailling.service.facade.admin.commun.ContactAdminService;
import ma.zs.emailling.zynerator.service.AbstractServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.emailling.service.facade.admin.commun.UtilisateurAdminService ;
import ma.zs.emailling.bean.core.commun.Utilisateur ;

@Service
public class ContactAdminServiceImpl extends AbstractServiceImpl<Contact, ContactCriteria, ContactDao> implements ContactAdminService {

   /* @Override
    public Contact save(Contact contact){



        Utilisateur personneSource=utilisateurService.findByEmail(contact.getPersonneSource().getEmail());
        Utilisateur personneDestination=utilisateurService.findByEmail(contact.getPersonneDestination().getEmail());
        contact.setPersonneSource(personneSource);
        contact.setPersonneDestination(personneDestination);

        LocalDateTime dateAjout = LocalDateTime.now();
        contact.setDateAjout(dateAjout);
        return dao.save(contact);

    }*/




    @Override
    public boolean existsDestinationForSource(Utilisateur personneSource, Utilisateur personneDestination) {
        return dao.existsByPersonneSourceAndPersonneDestination(personneSource, personneDestination);
    }







        @Override
        public Contact save(Contact contact) {
            Utilisateur personneSource = utilisateurService.findByEmail(contact.getPersonneSource().getEmail());
            Utilisateur personneDestination = utilisateurService.findByEmail(contact.getPersonneDestination().getEmail());

            contact.setPersonneSource(personneSource);
            contact.setPersonneDestination(personneDestination);

            LocalDateTime dateAjout = LocalDateTime.now();
            contact.setDateAjout(dateAjout);

            // Vérifier si l'utilisateur destination existe déjà pour l'utilisateur source

            if (existsDestinationForSource(personneSource, personneDestination)) {

                throw new IllegalStateException("L'utilisateur destination est déjà associé à l'utilisateur source.");

            }

            // Sauvegarder le contact si l'utilisateur destination n'existe pas encore pour l'utilisateur source
            return dao.save(contact);
        }











    public void findOrSaveAssociatedObject(Contact t){
        if( t != null) {
            t.setPersonneSource(utilisateurService.findOrSave(t.getPersonneSource()));
            t.setPersonneDestination(utilisateurService.findOrSave(t.getPersonneDestination()));
        }
    }

    public List<Contact> findByPersonneSourceId(Long id){
        return dao.findByPersonneSourceId(id);
    }
    public int deleteByPersonneSourceId(Long id){
        return dao.deleteByPersonneSourceId(id);
    }
    public long countByPersonneSourceUsername(String username){
        return dao.countByPersonneSourceUsername(username);
    }
    public List<Contact> findByPersonneDestinationId(Long id){
        return dao.findByPersonneDestinationId(id);
    }
    public int deleteByPersonneDestinationId(Long id){
        return dao.deleteByPersonneDestinationId(id);
    }
    public long countByPersonneDestinationUsername(String username){
        return dao.countByPersonneDestinationUsername(username);
    }






    public void configure() {
        super.configure(Contact.class, ContactSpecification.class);
    }


    @Autowired
    private UtilisateurAdminService utilisateurService ;

    public ContactAdminServiceImpl(ContactDao dao) {
        super(dao);
    }

}
