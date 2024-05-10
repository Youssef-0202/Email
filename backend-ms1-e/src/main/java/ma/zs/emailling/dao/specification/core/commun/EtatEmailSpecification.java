package  ma.zs.emailling.dao.specification.core.commun;

import ma.zs.emailling.dao.criteria.core.commun.EtatEmailCriteria;
import ma.zs.emailling.bean.core.commun.EtatEmail;
import ma.zs.emailling.zynerator.specification.AbstractSpecification;


public class EtatEmailSpecification extends  AbstractSpecification<EtatEmailCriteria, EtatEmail>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
    }

    public EtatEmailSpecification(EtatEmailCriteria criteria) {
        super(criteria);
    }

    public EtatEmailSpecification(EtatEmailCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
