package ma.zs.emailling.dao.facade.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zs.emailling.zynerator.repository.AbstractRepository;
import ma.zs.emailling.bean.core.commun.TypeContenu;
import org.springframework.stereotype.Repository;
import ma.zs.emailling.bean.core.commun.TypeContenu;
import java.util.List;


@Repository
public interface TypeContenuDao extends AbstractRepository<TypeContenu,Long>  {
    TypeContenu findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW TypeContenu(item.id,item.libelle) FROM TypeContenu item")
    List<TypeContenu> findAllOptimized();

}
