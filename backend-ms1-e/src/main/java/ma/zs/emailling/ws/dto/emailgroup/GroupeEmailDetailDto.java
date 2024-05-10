package  ma.zs.emailling.ws.dto.emailgroup;

import ma.zs.emailling.zynerator.audit.Log;
import ma.zs.emailling.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.emailling.ws.dto.commun.UtilisateurDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class GroupeEmailDetailDto  extends AuditBaseDto {

    private String dateAjoute ;
    private String dateBlockage ;

    private UtilisateurDto personne ;
    private GroupeEmailDto groupeEmail ;



    public GroupeEmailDetailDto(){
        super();
    }



    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateAjoute(){
        return this.dateAjoute;
    }
    public void setDateAjoute(String dateAjoute){
        this.dateAjoute = dateAjoute;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateBlockage(){
        return this.dateBlockage;
    }
    public void setDateBlockage(String dateBlockage){
        this.dateBlockage = dateBlockage;
    }


    public UtilisateurDto getPersonne(){
        return this.personne;
    }

    public void setPersonne(UtilisateurDto personne){
        this.personne = personne;
    }
    public GroupeEmailDto getGroupeEmail(){
        return this.groupeEmail;
    }

    public void setGroupeEmail(GroupeEmailDto groupeEmail){
        this.groupeEmail = groupeEmail;
    }






}
