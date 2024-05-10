package ma.zs.emailling.service.impl.admin.commun;


import ma.zs.emailling.bean.core.commun.KeepNote;
import ma.zs.emailling.dao.criteria.core.commun.KeepNoteCriteria;
import ma.zs.emailling.dao.facade.core.commun.KeepNoteDao;
import ma.zs.emailling.dao.specification.core.commun.KeepNoteSpecification;
import ma.zs.emailling.service.facade.admin.commun.KeepNoteAdminService;
import ma.zs.emailling.zynerator.service.AbstractServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.emailling.service.facade.admin.commun.UtilisateurAdminService ;
import ma.zs.emailling.bean.core.commun.Utilisateur ;

@Service
public class KeepNoteAdminServiceImpl extends AbstractServiceImpl<KeepNote, KeepNoteCriteria, KeepNoteDao> implements KeepNoteAdminService {


    @Override
    public KeepNote keepNote(KeepNote note){

        Utilisateur personne = utilisateurService.findByEmail(note.getPersonne().getEmail());
        note.setPersonne(personne);

        LocalDateTime dateKeepNote = LocalDateTime.now();
        note.setDateKeepNote(dateKeepNote);
        return keepNoteDao.save(note);
    }

    @Override

    public KeepNote save(KeepNote note){

        Utilisateur personne = utilisateurService.findByEmail(note.getPersonne().getEmail());
        note.setPersonne(personne);

        LocalDateTime dateKeepNote = LocalDateTime.now();
        note.setDateKeepNote(dateKeepNote);
        return keepNoteDao.save(note);

    }

    @Override
    public List<KeepNote> findNotesByPersonneEmail(String email) {
        return dao.findByPersonneEmail(email);
    }

    public void findOrSaveAssociatedObject(KeepNote t){
        if( t != null) {
            t.setPersonne(utilisateurService.findOrSave(t.getPersonne()));
        }
    }

    public List<KeepNote> findByPersonneId(Long id){
        return dao.findByPersonneId(id);
    }
    public int deleteByPersonneId(Long id){
        return dao.deleteByPersonneId(id);
    }
    public long countByPersonneUsername(String username){
        return dao.countByPersonneUsername(username);
    }






    public void configure() {
        super.configure(KeepNote.class, KeepNoteSpecification.class);
    }


    @Autowired
    private UtilisateurAdminService utilisateurService ;
    @Autowired
    private KeepNoteDao keepNoteDao;

    public KeepNoteAdminServiceImpl(KeepNoteDao dao) {
        super(dao);
    }

}
