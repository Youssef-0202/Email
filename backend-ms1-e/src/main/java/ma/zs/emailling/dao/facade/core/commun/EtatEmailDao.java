package ma.zs.emailling.dao.facade.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zs.emailling.zynerator.repository.AbstractRepository;
import ma.zs.emailling.bean.core.commun.EtatEmail;
import org.springframework.stereotype.Repository;
import ma.zs.emailling.bean.core.commun.EtatEmail;
import java.util.List;


@Repository
public interface EtatEmailDao extends AbstractRepository<EtatEmail,Long>  {
    EtatEmail findByCode(String code);
    EtatEmail findByLibelle(String libelle);
    int deleteByCode(String code);


    @Query("SELECT NEW EtatEmail(item.id,item.libelle) FROM EtatEmail item")
    List<EtatEmail> findAllOptimized();

}
