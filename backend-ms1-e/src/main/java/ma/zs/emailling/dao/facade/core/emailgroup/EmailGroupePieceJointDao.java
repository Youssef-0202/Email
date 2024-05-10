package ma.zs.emailling.dao.facade.core.emailgroup;

import ma.zs.emailling.zynerator.repository.AbstractRepository;
import ma.zs.emailling.bean.core.emailgroup.EmailGroupePieceJoint;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface EmailGroupePieceJointDao extends AbstractRepository<EmailGroupePieceJoint,Long>  {

    List<EmailGroupePieceJoint> findByTypecontenuId(Long id);
    int deleteByTypecontenuId(Long id);
    long countByTypecontenuCode(String code);
    List<EmailGroupePieceJoint> findByGroupeEmailId(Long id);
    int deleteByGroupeEmailId(Long id);
    long countByGroupeEmailId(Long id);


}
