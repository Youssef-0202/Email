package ma.zs.emailling.service.facade.admin.commun;

import java.util.List;
import ma.zs.emailling.bean.core.commun.KeepNote;
import ma.zs.emailling.dao.criteria.core.commun.KeepNoteCriteria;
import ma.zs.emailling.zynerator.service.IService;



public interface KeepNoteAdminService extends  IService<KeepNote,KeepNoteCriteria>  {

    KeepNote keepNote(KeepNote note);

    KeepNote save(KeepNote note);

    List<KeepNote> findNotesByPersonneEmail(String email);

    List<KeepNote> findByPersonneId(Long id);
    int deleteByPersonneId(Long id);
    long countByPersonneUsername(String username);




}
