package ma.zs.emailling.dao.facade.core.email;

import ma.zs.emailling.zynerator.repository.AbstractRepository;
import ma.zs.emailling.bean.core.email.EmailpieceJoin;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface EmailpieceJoinDao extends AbstractRepository<EmailpieceJoin,Long>  {

    List<EmailpieceJoin> findByEmailId(Long id);
    int deleteByEmailId(Long id);
    long countByEmailRef(String ref);
    List<EmailpieceJoin> findByTypeContenuId(Long id);
    int deleteByTypeContenuId(Long id);
    long countByTypeContenuCode(String code);


}
