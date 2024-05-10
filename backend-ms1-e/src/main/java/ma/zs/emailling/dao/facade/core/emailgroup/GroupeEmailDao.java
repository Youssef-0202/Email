package ma.zs.emailling.dao.facade.core.emailgroup;

import ma.zs.emailling.zynerator.repository.AbstractRepository;
import ma.zs.emailling.bean.core.emailgroup.GroupeEmail;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface GroupeEmailDao extends AbstractRepository<GroupeEmail,Long>  {

    List<GroupeEmail> findByAdminGroupeId(Long id);
    int deleteByAdminGroupeId(Long id);
    long countByAdminGroupeUsername(String username);


}
