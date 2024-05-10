package  ma.zs.emailling.ws.dto.emailgroup;

import ma.zs.emailling.zynerator.audit.Log;
import ma.zs.emailling.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;



import ma.zs.emailling.ws.dto.commun.TypeContenuDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmailGroupePieceJointDto  extends AuditBaseDto {

    private String path  ;
    private Long taille  ;

    private TypeContenuDto typecontenu ;
    private GroupeEmailDto groupeEmail ;



    public EmailGroupePieceJointDto(){
        super();
    }



    @Log
    public String getPath(){
        return this.path;
    }
    public void setPath(String path){
        this.path = path;
    }

    @Log
    public Long getTaille(){
        return this.taille;
    }
    public void setTaille(Long taille){
        this.taille = taille;
    }


    public TypeContenuDto getTypecontenu(){
        return this.typecontenu;
    }

    public void setTypecontenu(TypeContenuDto typecontenu){
        this.typecontenu = typecontenu;
    }
    public GroupeEmailDto getGroupeEmail(){
        return this.groupeEmail;
    }

    public void setGroupeEmail(GroupeEmailDto groupeEmail){
        this.groupeEmail = groupeEmail;
    }






}
