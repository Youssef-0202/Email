package ma.zs.emailling.dao.facade.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zs.emailling.zynerator.repository.AbstractRepository;
import ma.zs.emailling.bean.core.commun.CategoryEmail;
import org.springframework.stereotype.Repository;
import ma.zs.emailling.bean.core.commun.CategoryEmail;
import java.util.List;


@Repository
public interface CategoryEmailDao extends AbstractRepository<CategoryEmail,Long>  {
    CategoryEmail findByCode(String code);
    CategoryEmail findByName(String name);
    int deleteByName(String name);
    int deleteByCode(String code);


    @Query("SELECT NEW CategoryEmail(item.id,item.name) FROM CategoryEmail item")
    List<CategoryEmail> findAllOptimized();

}
