package  ma.zs.emailling.ws.dto.commun;

import ma.zs.emailling.zynerator.audit.Log;
import ma.zs.emailling.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;




@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContactDto  extends AuditBaseDto {

    private String name  ;
    private String dateAjout ;

    private UtilisateurDto personneSource ;
    private UtilisateurDto personneDestination ;



    public ContactDto(){
        super();
    }



    @Log
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateAjout(){
        return this.dateAjout;
    }
    public void setDateAjout(String dateAjout){
        this.dateAjout = dateAjout;
    }


    public UtilisateurDto getPersonneSource(){
        return this.personneSource;
    }

    public void setPersonneSource(UtilisateurDto personneSource){
        this.personneSource = personneSource;
    }
    public UtilisateurDto getPersonneDestination(){
        return this.personneDestination;
    }

    public void setPersonneDestination(UtilisateurDto personneDestination){
        this.personneDestination = personneDestination;
    }






}
