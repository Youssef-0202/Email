package ma.zs.emailling.dao.facade.core.email;

import org.springframework.data.jpa.repository.Query;
import ma.zs.emailling.zynerator.repository.AbstractRepository;
import ma.zs.emailling.bean.core.email.Email;
import org.springframework.stereotype.Repository;
import ma.zs.emailling.bean.core.email.Email;
import java.util.List;


@Repository
public interface EmailDao extends AbstractRepository<Email,Long>  {
    Email findByRef(String ref);
    int deleteByRef(String ref);

    List<Email> findByPersonneSourceId(Long id);
    int deleteByPersonneSourceId(Long id);
    long countByPersonneSourceUsername(String username);
    List<Email> findByCategoryEmailId(Long id);
    int deleteByCategoryEmailId(Long id);
    long countByCategoryEmailCode(String code);
    List<Email> findByEtatEmailId(Long id);
    int deleteByEtatEmailId(Long id);
    long countByEtatEmailCode(String code);

    @Query("SELECT NEW Email(item.id,item.ref) FROM Email item")
    List<Email> findAllOptimized();

}
