package ma.zs.emailling.service.facade.admin.commun;

import java.util.List;
import ma.zs.emailling.bean.core.commun.CategoryEmail;
import ma.zs.emailling.dao.criteria.core.commun.CategoryEmailCriteria;
import ma.zs.emailling.zynerator.service.IService;



public interface CategoryEmailAdminService extends  IService<CategoryEmail,CategoryEmailCriteria>  {


    CategoryEmail findByName(String name);
}
