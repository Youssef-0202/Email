package ma.zs.emailling.dao.facade.core.emailgroup;

import ma.zs.emailling.zynerator.repository.AbstractRepository;
import ma.zs.emailling.bean.core.emailgroup.EmailDetailGroup;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface EmailDetailGroupDao extends AbstractRepository<EmailDetailGroup,Long>  {

    List<EmailDetailGroup> findByEmailId(Long id);
    int deleteByEmailId(Long id);
    long countByEmailRef(String ref);
    List<EmailDetailGroup> findByDestinationId(Long id);
    int deleteByDestinationId(Long id);
    long countByDestinationId(Long id);


}
