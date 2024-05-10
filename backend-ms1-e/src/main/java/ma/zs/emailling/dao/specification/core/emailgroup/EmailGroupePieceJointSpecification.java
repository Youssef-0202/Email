package  ma.zs.emailling.dao.specification.core.emailgroup;

import ma.zs.emailling.dao.criteria.core.emailgroup.EmailGroupePieceJointCriteria;
import ma.zs.emailling.bean.core.emailgroup.EmailGroupePieceJoint;
import ma.zs.emailling.zynerator.specification.AbstractSpecification;


public class EmailGroupePieceJointSpecification extends  AbstractSpecification<EmailGroupePieceJointCriteria, EmailGroupePieceJoint>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("path", criteria.getPath(),criteria.getPathLike());
        addPredicateLong("taille", criteria.getTaille(), criteria.getTailleMin(), criteria.getTailleMax());
        addPredicateFk("typecontenu","id", criteria.getTypecontenu()==null?null:criteria.getTypecontenu().getId());
        addPredicateFk("typecontenu","id", criteria.getTypecontenus());
        addPredicateFk("typecontenu","code", criteria.getTypecontenu()==null?null:criteria.getTypecontenu().getCode());
        addPredicateFk("groupeEmail","id", criteria.getGroupeEmail()==null?null:criteria.getGroupeEmail().getId());
        addPredicateFk("groupeEmail","id", criteria.getGroupeEmails());
    }

    public EmailGroupePieceJointSpecification(EmailGroupePieceJointCriteria criteria) {
        super(criteria);
    }

    public EmailGroupePieceJointSpecification(EmailGroupePieceJointCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
