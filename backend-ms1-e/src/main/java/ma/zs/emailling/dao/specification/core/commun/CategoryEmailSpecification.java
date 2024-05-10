package  ma.zs.emailling.dao.specification.core.commun;

import ma.zs.emailling.dao.criteria.core.commun.CategoryEmailCriteria;
import ma.zs.emailling.bean.core.commun.CategoryEmail;
import ma.zs.emailling.zynerator.specification.AbstractSpecification;


public class CategoryEmailSpecification extends  AbstractSpecification<CategoryEmailCriteria, CategoryEmail>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("name", criteria.getName(),criteria.getNameLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
    }

    public CategoryEmailSpecification(CategoryEmailCriteria criteria) {
        super(criteria);
    }

    public CategoryEmailSpecification(CategoryEmailCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
