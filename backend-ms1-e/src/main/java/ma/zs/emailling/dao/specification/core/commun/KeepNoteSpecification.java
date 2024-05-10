package  ma.zs.emailling.dao.specification.core.commun;

import ma.zs.emailling.dao.criteria.core.commun.KeepNoteCriteria;
import ma.zs.emailling.bean.core.commun.KeepNote;
import ma.zs.emailling.zynerator.specification.AbstractSpecification;


public class KeepNoteSpecification extends  AbstractSpecification<KeepNoteCriteria, KeepNote>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("header", criteria.getHeader(),criteria.getHeaderLike());
        addPredicate("dateKeepNote", criteria.getDateKeepNote(), criteria.getDateKeepNoteFrom(), criteria.getDateKeepNoteTo());
        addPredicateFk("personne","id", criteria.getPersonne()==null?null:criteria.getPersonne().getId());
        addPredicateFk("personne","id", criteria.getPersonnes());
        addPredicateFk("personne","username", criteria.getPersonne()==null?null:criteria.getPersonne().getUsername());
    }

    public KeepNoteSpecification(KeepNoteCriteria criteria) {
        super(criteria);
    }

    public KeepNoteSpecification(KeepNoteCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
