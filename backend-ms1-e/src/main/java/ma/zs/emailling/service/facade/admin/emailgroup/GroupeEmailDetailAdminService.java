package ma.zs.emailling.service.facade.admin.emailgroup;

import java.util.List;
import ma.zs.emailling.bean.core.emailgroup.GroupeEmailDetail;
import ma.zs.emailling.dao.criteria.core.emailgroup.GroupeEmailDetailCriteria;
import ma.zs.emailling.zynerator.service.IService;



public interface GroupeEmailDetailAdminService extends  IService<GroupeEmailDetail,GroupeEmailDetailCriteria>  {

    List<GroupeEmailDetail> findByPersonneId(Long id);
    int deleteByPersonneId(Long id);
    long countByPersonneUsername(String username);
    List<GroupeEmailDetail> findByGroupeEmailId(Long id);
    int deleteByGroupeEmailId(Long id);
    long countByGroupeEmailId(Long id);




}
