package  ma.zs.emailling.ws.dto.commun;

import ma.zs.emailling.zynerator.audit.Log;
import ma.zs.emailling.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;





@JsonInclude(JsonInclude.Include.NON_NULL)
public class TypeContenuDto  extends AuditBaseDto {

    private String libelle  ;
    private String code  ;




    public TypeContenuDto(){
        super();
    }



    @Log
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }

    @Log
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }








}
