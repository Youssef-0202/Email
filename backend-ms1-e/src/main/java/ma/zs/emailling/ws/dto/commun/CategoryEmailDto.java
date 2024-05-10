package  ma.zs.emailling.ws.dto.commun;

import ma.zs.emailling.zynerator.audit.Log;
import ma.zs.emailling.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;





@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryEmailDto  extends AuditBaseDto {

    private String name  ;
    private String code  ;




    public CategoryEmailDto(){
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
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }








}
