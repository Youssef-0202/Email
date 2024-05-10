package  ma.zs.emailling.dao.criteria.core.commun;



import ma.zs.emailling.zynerator.criteria.BaseCriteria;
import java.util.List;

public class UtilisateurCriteria extends  BaseCriteria  {

    private String username;
    private String usernameLike;
    private String password;
    private String passwordLike;
    private String email;
    private String emailLike;
    private String signature;
    private String signatureLike;



    public UtilisateurCriteria(){}

    public String getUsername(){
        return this.username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getUsernameLike(){
        return this.usernameLike;
    }
    public void setUsernameLike(String usernameLike){
        this.usernameLike = usernameLike;
    }

    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPasswordLike(){
        return this.passwordLike;
    }
    public void setPasswordLike(String passwordLike){
        this.passwordLike = passwordLike;
    }

    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmailLike(){
        return this.emailLike;
    }
    public void setEmailLike(String emailLike){
        this.emailLike = emailLike;
    }

    public String getSignature(){
        return this.signature;
    }
    public void setSignature(String signature){
        this.signature = signature;
    }
    public String getSignatureLike(){
        return this.signatureLike;
    }
    public void setSignatureLike(String signatureLike){
        this.signatureLike = signatureLike;
    }


}
