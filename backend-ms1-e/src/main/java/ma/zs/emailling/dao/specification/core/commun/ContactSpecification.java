package  ma.zs.emailling.dao.specification.core.commun;

import ma.zs.emailling.dao.criteria.core.commun.ContactCriteria;
import ma.zs.emailling.bean.core.commun.Contact;
import ma.zs.emailling.zynerator.specification.AbstractSpecification;


public class ContactSpecification extends  AbstractSpecification<ContactCriteria, Contact>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("name", criteria.getName(),criteria.getNameLike());
        addPredicate("dateAjout", criteria.getDateAjout(), criteria.getDateAjoutFrom(), criteria.getDateAjoutTo());
        addPredicateFk("personneSource","id", criteria.getPersonneSource()==null?null:criteria.getPersonneSource().getId());
        addPredicateFk("personneSource","id", criteria.getPersonneSources());
        addPredicateFk("personneSource","username", criteria.getPersonneSource()==null?null:criteria.getPersonneSource().getUsername());
        addPredicateFk("personneDestination","id", criteria.getPersonneDestination()==null?null:criteria.getPersonneDestination().getId());
        addPredicateFk("personneDestination","id", criteria.getPersonneDestinations());
        addPredicateFk("personneDestination","username", criteria.getPersonneDestination()==null?null:criteria.getPersonneDestination().getUsername());
    }

    public ContactSpecification(ContactCriteria criteria) {
        super(criteria);
    }

    public ContactSpecification(ContactCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
