package  ma.zs.emailling.dao.specification.core.email;

import ma.zs.emailling.dao.criteria.core.email.EmailCriteria;
import ma.zs.emailling.bean.core.email.Email;
import ma.zs.emailling.zynerator.specification.AbstractSpecification;


public class EmailSpecification extends  AbstractSpecification<EmailCriteria, Email>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("ref", criteria.getRef(),criteria.getRefLike());
        addPredicate("dateEnvoi", criteria.getDateEnvoi(), criteria.getDateEnvoiFrom(), criteria.getDateEnvoiTo());
        addPredicate("header", criteria.getHeader(),criteria.getHeaderLike());
        addPredicateFk("personneSource","id", criteria.getPersonneSource()==null?null:criteria.getPersonneSource().getId());
        addPredicateFk("personneSource","id", criteria.getPersonneSources());
        addPredicateFk("personneSource","username", criteria.getPersonneSource()==null?null:criteria.getPersonneSource().getUsername());
        addPredicateFk("categoryEmail","id", criteria.getCategoryEmail()==null?null:criteria.getCategoryEmail().getId());
        addPredicateFk("categoryEmail","id", criteria.getCategoryEmails());
        addPredicateFk("categoryEmail","code", criteria.getCategoryEmail()==null?null:criteria.getCategoryEmail().getCode());
        addPredicateFk("etatEmail","id", criteria.getEtatEmail()==null?null:criteria.getEtatEmail().getId());
        addPredicateFk("etatEmail","id", criteria.getEtatEmails());
        addPredicateFk("etatEmail","code", criteria.getEtatEmail()==null?null:criteria.getEtatEmail().getCode());
    }

    public EmailSpecification(EmailCriteria criteria) {
        super(criteria);
    }

    public EmailSpecification(EmailCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
