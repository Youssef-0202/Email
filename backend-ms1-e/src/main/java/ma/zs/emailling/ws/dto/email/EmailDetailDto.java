package  ma.zs.emailling.ws.dto.email;

import ma.zs.emailling.zynerator.audit.Log;
import ma.zs.emailling.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.emailling.ws.dto.commun.EtatEmailDto;
import ma.zs.emailling.ws.dto.commun.UtilisateurDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmailDetailDto  extends AuditBaseDto {

    private String dateLecture ;
    private String dateReception ;

    private EmailDto email ;
    private UtilisateurDto personneDestinataire ;
    private EtatEmailDto etatEmail ;



    public EmailDetailDto(){
        super();
    }



    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateLecture(){
        return this.dateLecture;
    }
    public void setDateLecture(String dateLecture){
        this.dateLecture = dateLecture;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateReception(){
        return this.dateReception;
    }
    public void setDateReception(String dateReception){
        this.dateReception = dateReception;
    }


    public EmailDto getEmail(){
        return this.email;
    }

    public void setEmail(EmailDto email){
        this.email = email;
    }
    public UtilisateurDto getPersonneDestinataire(){
        return this.personneDestinataire;
    }

    public void setPersonneDestinataire(UtilisateurDto personneDestinataire){
        this.personneDestinataire = personneDestinataire;
    }
    public EtatEmailDto getEtatEmail(){
        return this.etatEmail;
    }

    public void setEtatEmail(EtatEmailDto etatEmail){
        this.etatEmail = etatEmail;
    }






}
