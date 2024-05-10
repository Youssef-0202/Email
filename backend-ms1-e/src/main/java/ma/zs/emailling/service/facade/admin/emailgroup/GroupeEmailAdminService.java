package ma.zs.emailling.service.facade.admin.emailgroup;

import java.util.List;
import ma.zs.emailling.bean.core.emailgroup.GroupeEmail;
import ma.zs.emailling.dao.criteria.core.emailgroup.GroupeEmailCriteria;
import ma.zs.emailling.zynerator.service.IService;



public interface GroupeEmailAdminService extends  IService<GroupeEmail,GroupeEmailCriteria>  {

    List<GroupeEmail> findByAdminGroupeId(Long id);
    int deleteByAdminGroupeId(Long id);
    long countByAdminGroupeUsername(String username);




}
