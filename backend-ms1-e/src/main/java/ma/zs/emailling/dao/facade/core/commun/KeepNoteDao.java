package ma.zs.emailling.dao.facade.core.commun;

import ma.zs.emailling.zynerator.repository.AbstractRepository;
import ma.zs.emailling.bean.core.commun.KeepNote;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface KeepNoteDao extends AbstractRepository<KeepNote,Long>  {

    List<KeepNote> findByPersonneId(Long id);
    int deleteByPersonneId(Long id);
    long countByPersonneUsername(String username);


    /////////

    List<KeepNote> findByPersonneEmail(String email);

    /////////

}
