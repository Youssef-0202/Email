package  ma.zs.emailling.dao.criteria.core.commun;



import ma.zs.emailling.zynerator.criteria.BaseCriteria;
import java.util.List;

public class CategoryEmailCriteria extends  BaseCriteria  {

    private String name;
    private String nameLike;
    private String code;
    private String codeLike;



    public CategoryEmailCriteria(){}

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getNameLike(){
        return this.nameLike;
    }
    public void setNameLike(String nameLike){
        this.nameLike = nameLike;
    }

    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getCodeLike(){
        return this.codeLike;
    }
    public void setCodeLike(String codeLike){
        this.codeLike = codeLike;
    }


}
