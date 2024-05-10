package ma.zs.emailling.service.facade.admin.email;

import java.util.List;
import ma.zs.emailling.bean.core.email.EmailDetail;
import ma.zs.emailling.dao.criteria.core.email.EmailDetailCriteria;
import ma.zs.emailling.zynerator.service.IService;



public interface EmailDetailAdminService extends  IService<EmailDetail,EmailDetailCriteria>  {

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
