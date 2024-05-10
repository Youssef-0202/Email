package  ma.zs.emailling.dao.specification.core.commun;

import ma.zs.emailling.dao.criteria.core.commun.TypeContenuCriteria;
import ma.zs.emailling.bean.core.commun.TypeContenu;
import ma.zs.emailling.zynerator.specification.AbstractSpecification;


public class TypeContenuSpecification extends  AbstractSpecification<TypeContenuCriteria, TypeContenu>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
    }

    public TypeContenuSpecification(TypeContenuCriteria criteria) {
        super(criteria);
    }

    public TypeContenuSpecification(TypeContenuCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
