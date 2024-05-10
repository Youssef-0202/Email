package ma.zs.emailling.dao.facade.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zs.emailling.zynerator.repository.AbstractRepository;
import ma.zs.emailling.bean.core.commun.Utilisateur;
import org.springframework.stereotype.Repository;
import ma.zs.emailling.bean.core.commun.Utilisateur;
import java.util.List;


@Repository
public interface UtilisateurDao extends AbstractRepository<Utilisateur,Long>  {

    Utilisateur findByUsername(String username);
    Utilisateur findByEmail(String email);
    int deleteByUsername(String username);


    @Query("SELECT NEW Utilisateur(item.id,item.email) FROM Utilisateur item")
    List<Utilisateur> findAllOptimized();




}
