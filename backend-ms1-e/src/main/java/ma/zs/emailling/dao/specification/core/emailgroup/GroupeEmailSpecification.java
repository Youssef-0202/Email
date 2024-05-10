package  ma.zs.emailling.dao.specification.core.emailgroup;

import ma.zs.emailling.dao.criteria.core.emailgroup.GroupeEmailCriteria;
import ma.zs.emailling.bean.core.emailgroup.GroupeEmail;
import ma.zs.emailling.zynerator.specification.AbstractSpecification;


public class GroupeEmailSpecification extends  AbstractSpecification<GroupeEmailCriteria, GroupeEmail>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicateFk("adminGroupe","id", criteria.getAdminGroupe()==null?null:criteria.getAdminGroupe().getId());
        addPredicateFk("adminGroupe","id", criteria.getAdminGroupes());
        addPredicateFk("adminGroupe","username", criteria.getAdminGroupe()==null?null:criteria.getAdminGroupe().getUsername());
    }

    public GroupeEmailSpecification(GroupeEmailCriteria criteria) {
        super(criteria);
    }

    public GroupeEmailSpecification(GroupeEmailCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
