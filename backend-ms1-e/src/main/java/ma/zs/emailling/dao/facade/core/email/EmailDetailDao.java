package ma.zs.emailling.dao.facade.core.email;

import ma.zs.emailling.zynerator.repository.AbstractRepository;
import ma.zs.emailling.bean.core.email.EmailDetail;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface EmailDetailDao extends AbstractRepository<EmailDetail,Long>  {

    List<EmailDetail> findByEmailId(Long id);
    int deleteByEmailId(Long id);
    long countByEmailRef(String ref);
    List<EmailDetail> findByPersonneDestinataireId(Long id);
    int deleteByPersonneDestinataireId(Long id);
    long countByPersonneDestinataireUsername(String username);
    List<EmailDetail> findByEtatEmailId(Long id);
    int deleteByEtatEmailId(Long id);
    long countByEtatEmailCode(String code);

    List<EmailDetail> findByPersonneDestinataireUsername(String username);

}
