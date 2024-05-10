package  ma.zs.emailling.dao.specification.core.email;

import ma.zs.emailling.dao.criteria.core.email.EmailDetailCriteria;
import ma.zs.emailling.bean.core.email.EmailDetail;
import ma.zs.emailling.zynerator.specification.AbstractSpecification;


public class EmailDetailSpecification extends  AbstractSpecification<EmailDetailCriteria, EmailDetail>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("dateLecture", criteria.getDateLecture(), criteria.getDateLectureFrom(), criteria.getDateLectureTo());
        addPredicate("dateReception", criteria.getDateReception(), criteria.getDateReceptionFrom(), criteria.getDateReceptionTo());
        addPredicateFk("email","id", criteria.getEmail()==null?null:criteria.getEmail().getId());
        addPredicateFk("email","id", criteria.getEmails());
        addPredicateFk("email","ref", criteria.getEmail()==null?null:criteria.getEmail().getRef());
        addPredicateFk("personneDestinataire","id", criteria.getPersonneDestinataire()==null?null:criteria.getPersonneDestinataire().getId());
        addPredicateFk("personneDestinataire","id", criteria.getPersonneDestinataires());
        addPredicateFk("personneDestinataire","username", criteria.getPersonneDestinataire()==null?null:criteria.getPersonneDestinataire().getUsername());
        addPredicateFk("etatEmail","id", criteria.getEtatEmail()==null?null:criteria.getEtatEmail().getId());
        addPredicateFk("etatEmail","id", criteria.getEtatEmails());
        addPredicateFk("etatEmail","code", criteria.getEtatEmail()==null?null:criteria.getEtatEmail().getCode());
    }

    public EmailDetailSpecification(EmailDetailCriteria criteria) {
        super(criteria);
    }

    public EmailDetailSpecification(EmailDetailCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
