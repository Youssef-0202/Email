package  ma.zs.emailling.ws.dto.email;

import ma.zs.emailling.zynerator.audit.Log;
import ma.zs.emailling.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;



import ma.zs.emailling.ws.dto.commun.TypeContenuDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmailpieceJoinDto  extends AuditBaseDto {

    private String path  ;
    private String taille  ;

    private EmailDto email ;
    private TypeContenuDto typeContenu ;



    public EmailpieceJoinDto(){
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
    public String getTaille(){
        return this.taille;
    }
    public void setTaille(String taille){
        this.taille = taille;
    }


    public EmailDto getEmail(){
        return this.email;
    }

    public void setEmail(EmailDto email){
        this.email = email;
    }
    public TypeContenuDto getTypeContenu(){
        return this.typeContenu;
    }

    public void setTypeContenu(TypeContenuDto typeContenu){
        this.typeContenu = typeContenu;
    }






}
