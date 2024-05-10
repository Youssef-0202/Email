package ma.zs.emailling.service.facade.admin.email;

import java.util.List;
import ma.zs.emailling.bean.core.email.EmailpieceJoin;
import ma.zs.emailling.dao.criteria.core.email.EmailpieceJoinCriteria;
import ma.zs.emailling.zynerator.service.IService;



public interface EmailpieceJoinAdminService extends  IService<EmailpieceJoin,EmailpieceJoinCriteria>  {

    List<EmailpieceJoin> findByEmailId(Long id);
    int deleteByEmailId(Long id);
    long countByEmailRef(String ref);
    List<EmailpieceJoin> findByTypeContenuId(Long id);
    int deleteByTypeContenuId(Long id);
    long countByTypeContenuCode(String code);




}
