package ma.zs.emailling.zynerator.security.service.facade;

import ma.zs.emailling.zynerator.security.bean.Role;
import ma.zs.emailling.zynerator.security.dao.criteria.core.RoleCriteria;
import ma.zs.emailling.zynerator.service.IService;



public interface RoleService extends  IService<Role,RoleCriteria>  {
    Role findByAuthority(String authority);
    int deleteByAuthority(String authority);


    



}
