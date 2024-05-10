package ma.zs.emailling.service.facade.admin.emailgroup;

import java.util.List;
import ma.zs.emailling.bean.core.emailgroup.EmailGroupePieceJoint;
import ma.zs.emailling.dao.criteria.core.emailgroup.EmailGroupePieceJointCriteria;
import ma.zs.emailling.zynerator.service.IService;



public interface EmailGroupePieceJointAdminService extends  IService<EmailGroupePieceJoint,EmailGroupePieceJointCriteria>  {

    List<EmailGroupePieceJoint> findByTypecontenuId(Long id);
    int deleteByTypecontenuId(Long id);
    long countByTypecontenuCode(String code);
    List<EmailGroupePieceJoint> findByGroupeEmailId(Long id);
    int deleteByGroupeEmailId(Long id);
    long countByGroupeEmailId(Long id);




}
