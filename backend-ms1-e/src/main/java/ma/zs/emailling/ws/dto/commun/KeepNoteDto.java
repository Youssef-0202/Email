package  ma.zs.emailling.ws.dto.commun;

import ma.zs.emailling.zynerator.audit.Log;
import ma.zs.emailling.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;




@JsonInclude(JsonInclude.Include.NON_NULL)
public class KeepNoteDto  extends AuditBaseDto {

    private String body  ;
    private String header  ;
    private String dateKeepNote ;

    private UtilisateurDto personne ;



    public KeepNoteDto(){
        super();
    }



    @Log
    public String getBody(){
        return this.body;
    }
    public void setBody(String body){
        this.body = body;
    }

    @Log
    public String getHeader(){
        return this.header;
    }
    public void setHeader(String header){
        this.header = header;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateKeepNote(){
        return this.dateKeepNote;
    }
    public void setDateKeepNote(String dateKeepNote){
        this.dateKeepNote = dateKeepNote;
    }


    public UtilisateurDto getPersonne(){
        return this.personne;
    }

    public void setPersonne(UtilisateurDto personne){
        this.personne = personne;
    }






}
