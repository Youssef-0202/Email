package ma.zs.emailling.service.facade.admin.commun;

import java.util.List;
import ma.zs.emailling.bean.core.commun.Utilisateur;
import ma.zs.emailling.dao.criteria.core.commun.UtilisateurCriteria;
import ma.zs.emailling.zynerator.service.IService;



public interface UtilisateurAdminService extends  IService<Utilisateur,UtilisateurCriteria>  {


    Utilisateur findByUsername(String username);

    Utilisateur findByEmail(String email);

    Utilisateur save(Utilisateur utilisateur);

}
