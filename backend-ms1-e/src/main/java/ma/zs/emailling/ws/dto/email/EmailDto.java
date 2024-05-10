package  ma.zs.emailling.ws.dto.email;

import ma.zs.emailling.zynerator.audit.Log;
import ma.zs.emailling.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.emailling.ws.dto.commun.EtatEmailDto;
import ma.zs.emailling.ws.dto.commun.TypeContenuDto;
import ma.zs.emailling.ws.dto.emailgroup.EmailDetailGroupDto;
import ma.zs.emailling.ws.dto.commun.UtilisateurDto;
import ma.zs.emailling.ws.dto.commun.CategoryEmailDto;
import ma.zs.emailling.ws.dto.emailgroup.GroupeEmailDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmailDto  extends AuditBaseDto {

    private String ref  ;
    private String dateEnvoi ;
    private String corps  ;
    private String header  ;

    private UtilisateurDto personneSource ;
    private CategoryEmailDto categoryEmail ;
    private EtatEmailDto etatEmail ;

    private List<EmailDetailDto> emailDetails ;
    private List<EmailpieceJoinDto> emailpieceJoints ;
    private List<EmailDetailGroupDto> emailDetailGroups ;


    public EmailDto(){
        super();
    }



    @Log
    public String getRef(){
        return this.ref;
    }
    public void setRef(String ref){
        this.ref = ref;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateEnvoi(){
        return this.dateEnvoi;
    }
    public void setDateEnvoi(String dateEnvoi){
        this.dateEnvoi = dateEnvoi;
    }

    @Log
    public String getCorps(){
        return this.corps;
    }
    public void setCorps(String corps){
        this.corps = corps;
    }

    @Log
    public String getHeader(){
        return this.header;
    }
    public void setHeader(String header){
        this.header = header;
    }


    public UtilisateurDto getPersonneSource(){
        return this.personneSource;
    }

    public void setPersonneSource(UtilisateurDto personneSource){
        this.personneSource = personneSource;
    }
    public CategoryEmailDto getCategoryEmail(){
        return this.categoryEmail;
    }

    public void setCategoryEmail(CategoryEmailDto categoryEmail){
        this.categoryEmail = categoryEmail;
    }
    public EtatEmailDto getEtatEmail(){
        return this.etatEmail;
    }

    public void setEtatEmail(EtatEmailDto etatEmail){
        this.etatEmail = etatEmail;
    }



    public List<EmailDetailDto> getEmailDetails(){
        return this.emailDetails;
    }

    public void setEmailDetails(List<EmailDetailDto> emailDetails){
        this.emailDetails = emailDetails;
    }
    public List<EmailpieceJoinDto> getEmailpieceJoints(){
        return this.emailpieceJoints;
    }

    public void setEmailpieceJoints(List<EmailpieceJoinDto> emailpieceJoints){
        this.emailpieceJoints = emailpieceJoints;
    }
    public List<EmailDetailGroupDto> getEmailDetailGroups(){
        return this.emailDetailGroups;
    }

    public void setEmailDetailGroups(List<EmailDetailGroupDto> emailDetailGroups){
        this.emailDetailGroups = emailDetailGroups;
    }



}
