package  ma.zs.emailling.ws.dto.emailgroup;

import ma.zs.emailling.zynerator.audit.Log;
import ma.zs.emailling.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;


import ma.zs.emailling.ws.dto.commun.UtilisateurDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class GroupeEmailDto  extends AuditBaseDto {

    private String libelle  ;

    private UtilisateurDto adminGroupe ;

    private List<GroupeEmailDetailDto> groupeEmailDetails ;


    public GroupeEmailDto(){
        super();
    }



    @Log
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }


    public UtilisateurDto getAdminGroupe(){
        return this.adminGroupe;
    }

    public void setAdminGroupe(UtilisateurDto adminGroupe){
        this.adminGroupe = adminGroupe;
    }



    public List<GroupeEmailDetailDto> getGroupeEmailDetails(){
        return this.groupeEmailDetails;
    }

    public void setGroupeEmailDetails(List<GroupeEmailDetailDto> groupeEmailDetails){
        this.groupeEmailDetails = groupeEmailDetails;
    }



}
