package  ma.zs.emailling.dao.criteria.core.commun;



import ma.zs.emailling.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class ContactCriteria extends  BaseCriteria  {

    private String name;
    private String nameLike;
    private LocalDateTime dateAjout;
    private LocalDateTime dateAjoutFrom;
    private LocalDateTime dateAjoutTo;

    private UtilisateurCriteria personneSource ;
    private List<UtilisateurCriteria> personneSources ;
    private UtilisateurCriteria personneDestination ;
    private List<UtilisateurCriteria> personneDestinations ;


    public ContactCriteria(){}

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getNameLike(){
        return this.nameLike;
    }
    public void setNameLike(String nameLike){
        this.nameLike = nameLike;
    }

    public LocalDateTime getDateAjout(){
        return this.dateAjout;
    }
    public void setDateAjout(LocalDateTime dateAjout){
        this.dateAjout = dateAjout;
    }
    public LocalDateTime getDateAjoutFrom(){
        return this.dateAjoutFrom;
    }
    public void setDateAjoutFrom(LocalDateTime dateAjoutFrom){
        this.dateAjoutFrom = dateAjoutFrom;
    }
    public LocalDateTime getDateAjoutTo(){
        return this.dateAjoutTo;
    }
    public void setDateAjoutTo(LocalDateTime dateAjoutTo){
        this.dateAjoutTo = dateAjoutTo;
    }

    public UtilisateurCriteria getPersonneSource(){
        return this.personneSource;
    }

    public void setPersonneSource(UtilisateurCriteria personneSource){
        this.personneSource = personneSource;
    }
    public List<UtilisateurCriteria> getPersonneSources(){
        return this.personneSources;
    }

    public void setPersonneSources(List<UtilisateurCriteria> personneSources){
        this.personneSources = personneSources;
    }
    public UtilisateurCriteria getPersonneDestination(){
        return this.personneDestination;
    }

    public void setPersonneDestination(UtilisateurCriteria personneDestination){
        this.personneDestination = personneDestination;
    }
    public List<UtilisateurCriteria> getPersonneDestinations(){
        return this.personneDestinations;
    }

    public void setPersonneDestinations(List<UtilisateurCriteria> personneDestinations){
        this.personneDestinations = personneDestinations;
    }
}
