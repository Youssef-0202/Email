package ma.zs.emailling.service.facade.admin.email;

import java.util.List;
import ma.zs.emailling.bean.core.email.Email;
import ma.zs.emailling.dao.criteria.core.email.EmailCriteria;
import ma.zs.emailling.zynerator.service.IService;



public interface EmailAdminService extends  IService<Email,EmailCriteria>  {

    Email sendEmail(Email email);

    List<Email> findByPersonneSourceId(Long id);
    int deleteByPersonneSourceId(Long id);
    long countByPersonneSourceUsername(String username);
    List<Email> findByCategoryEmailId(Long id);
    int deleteByCategoryEmailId(Long id);
    long countByCategoryEmailCode(String code);
    List<Email> findByEtatEmailId(Long id);
    int deleteByEtatEmailId(Long id);
    long countByEtatEmailCode(String code);




}
