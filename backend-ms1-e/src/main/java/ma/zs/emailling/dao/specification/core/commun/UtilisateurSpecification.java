package  ma.zs.emailling.dao.specification.core.commun;

import ma.zs.emailling.dao.criteria.core.commun.UtilisateurCriteria;
import ma.zs.emailling.bean.core.commun.Utilisateur;
import ma.zs.emailling.zynerator.specification.AbstractSpecification;


public class UtilisateurSpecification extends  AbstractSpecification<UtilisateurCriteria, Utilisateur>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("username", criteria.getUsername(),criteria.getUsernameLike());
        addPredicate("password", criteria.getPassword(),criteria.getPasswordLike());
        addPredicate("email", criteria.getEmail(),criteria.getEmailLike());
        addPredicate("signature", criteria.getSignature(),criteria.getSignatureLike());
    }

    public UtilisateurSpecification(UtilisateurCriteria criteria) {
        super(criteria);
    }

    public UtilisateurSpecification(UtilisateurCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
