package ma.zs.emailling.service.facade.admin.emailgroup;

import java.util.List;
import ma.zs.emailling.bean.core.emailgroup.EmailDetailGroup;
import ma.zs.emailling.dao.criteria.core.emailgroup.EmailDetailGroupCriteria;
import ma.zs.emailling.zynerator.service.IService;



public interface EmailDetailGroupAdminService extends  IService<EmailDetailGroup,EmailDetailGroupCriteria>  {

    List<EmailDetailGroup> findByEmailId(Long id);
    int deleteByEmailId(Long id);
    long countByEmailRef(String ref);
    List<EmailDetailGroup> findByDestinationId(Long id);
    int deleteByDestinationId(Long id);
    long countByDestinationId(Long id);




}
