package  ma.zs.emailling.dao.criteria.core.commun;



import ma.zs.emailling.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class KeepNoteCriteria extends  BaseCriteria  {

    private String body;
    private String bodyLike;
    private String header;
    private String headerLike;
    private LocalDateTime dateKeepNote;
    private LocalDateTime dateKeepNoteFrom;
    private LocalDateTime dateKeepNoteTo;

    private UtilisateurCriteria personne ;
    private List<UtilisateurCriteria> personnes ;


    public KeepNoteCriteria(){}

    public String getBody(){
        return this.body;
    }
    public void setBody(String body){
        this.body = body;
    }
    public String getBodyLike(){
        return this.bodyLike;
    }
    public void setBodyLike(String bodyLike){
        this.bodyLike = bodyLike;
    }

    public String getHeader(){
        return this.header;
    }
    public void setHeader(String header){
        this.header = header;
    }
    public String getHeaderLike(){
        return this.headerLike;
    }
    public void setHeaderLike(String headerLike){
        this.headerLike = headerLike;
    }

    public LocalDateTime getDateKeepNote(){
        return this.dateKeepNote;
    }
    public void setDateKeepNote(LocalDateTime dateKeepNote){
        this.dateKeepNote = dateKeepNote;
    }
    public LocalDateTime getDateKeepNoteFrom(){
        return this.dateKeepNoteFrom;
    }
    public void setDateKeepNoteFrom(LocalDateTime dateKeepNoteFrom){
        this.dateKeepNoteFrom = dateKeepNoteFrom;
    }
    public LocalDateTime getDateKeepNoteTo(){
        return this.dateKeepNoteTo;
    }
    public void setDateKeepNoteTo(LocalDateTime dateKeepNoteTo){
        this.dateKeepNoteTo = dateKeepNoteTo;
    }

    public UtilisateurCriteria getPersonne(){
        return this.personne;
    }

    public void setPersonne(UtilisateurCriteria personne){
        this.personne = personne;
    }
    public List<UtilisateurCriteria> getPersonnes(){
        return this.personnes;
    }

    public void setPersonnes(List<UtilisateurCriteria> personnes){
        this.personnes = personnes;
    }
}
