package  ma.zs.emailling.dao.specification.core.emailgroup;

import ma.zs.emailling.dao.criteria.core.emailgroup.EmailDetailGroupCriteria;
import ma.zs.emailling.bean.core.emailgroup.EmailDetailGroup;
import ma.zs.emailling.zynerator.specification.AbstractSpecification;


public class EmailDetailGroupSpecification extends  AbstractSpecification<EmailDetailGroupCriteria, EmailDetailGroup>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("dateReception", criteria.getDateReception(), criteria.getDateReceptionFrom(), criteria.getDateReceptionTo());
        addPredicate("dateLecture", criteria.getDateLecture(), criteria.getDateLectureFrom(), criteria.getDateLectureTo());
        addPredicateFk("email","id", criteria.getEmail()==null?null:criteria.getEmail().getId());
        addPredicateFk("email","id", criteria.getEmails());
        addPredicateFk("email","ref", criteria.getEmail()==null?null:criteria.getEmail().getRef());
        addPredicateFk("destination","id", criteria.getDestination()==null?null:criteria.getDestination().getId());
        addPredicateFk("destination","id", criteria.getDestinations());
    }

    public EmailDetailGroupSpecification(EmailDetailGroupCriteria criteria) {
        super(criteria);
    }

    public EmailDetailGroupSpecification(EmailDetailGroupCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
