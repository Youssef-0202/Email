package ma.zs.emailling.zynerator.security.dao.facade.core;

import ma.zs.emailling.zynerator.repository.AbstractRepository;
import ma.zs.emailling.zynerator.security.bean.ActionPermission;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ActionPermissionDao extends AbstractRepository<ActionPermission,Long>  {
    ActionPermission findByReference(String reference);
    int deleteByReference(String reference);


    @Query("SELECT NEW ActionPermission(item.id,item.reference) FROM ActionPermission item")
    List<ActionPermission> findAllOptimized();

}
