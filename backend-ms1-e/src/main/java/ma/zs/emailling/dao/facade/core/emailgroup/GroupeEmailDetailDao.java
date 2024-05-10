package ma.zs.emailling.dao.facade.core.emailgroup;

import ma.zs.emailling.zynerator.repository.AbstractRepository;
import ma.zs.emailling.bean.core.emailgroup.GroupeEmailDetail;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface GroupeEmailDetailDao extends AbstractRepository<GroupeEmailDetail,Long>  {

    List<GroupeEmailDetail> findByPersonneId(Long id);
    int deleteByPersonneId(Long id);
    long countByPersonneUsername(String username);
    List<GroupeEmailDetail> findByGroupeEmailId(Long id);
    int deleteByGroupeEmailId(Long id);
    long countByGroupeEmailId(Long id);


}
