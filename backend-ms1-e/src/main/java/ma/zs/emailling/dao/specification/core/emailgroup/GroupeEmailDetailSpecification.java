package  ma.zs.emailling.dao.specification.core.emailgroup;

import ma.zs.emailling.dao.criteria.core.emailgroup.GroupeEmailDetailCriteria;
import ma.zs.emailling.bean.core.emailgroup.GroupeEmailDetail;
import ma.zs.emailling.zynerator.specification.AbstractSpecification;


public class GroupeEmailDetailSpecification extends  AbstractSpecification<GroupeEmailDetailCriteria, GroupeEmailDetail>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("dateAjoute", criteria.getDateAjoute(), criteria.getDateAjouteFrom(), criteria.getDateAjouteTo());
        addPredicate("dateBlockage", criteria.getDateBlockage(), criteria.getDateBlockageFrom(), criteria.getDateBlockageTo());
        addPredicateFk("personne","id", criteria.getPersonne()==null?null:criteria.getPersonne().getId());
        addPredicateFk("personne","id", criteria.getPersonnes());
        addPredicateFk("personne","username", criteria.getPersonne()==null?null:criteria.getPersonne().getUsername());
        addPredicateFk("groupeEmail","id", criteria.getGroupeEmail()==null?null:criteria.getGroupeEmail().getId());
        addPredicateFk("groupeEmail","id", criteria.getGroupeEmails());
    }

    public GroupeEmailDetailSpecification(GroupeEmailDetailCriteria criteria) {
        super(criteria);
    }

    public GroupeEmailDetailSpecification(GroupeEmailDetailCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
