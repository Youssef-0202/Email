package  ma.zs.emailling.dao.criteria.core.email;


import ma.zs.emailling.dao.criteria.core.commun.TypeContenuCriteria;

import ma.zs.emailling.zynerator.criteria.BaseCriteria;
import java.util.List;

public class EmailpieceJoinCriteria extends  BaseCriteria  {

    private String path;
    private String pathLike;
    private String taille;
    private String tailleLike;

    private EmailCriteria email ;
    private List<EmailCriteria> emails ;
    private TypeContenuCriteria typeContenu ;
    private List<TypeContenuCriteria> typeContenus ;


    public EmailpieceJoinCriteria(){}

    public String getPath(){
        return this.path;
    }
    public void setPath(String path){
        this.path = path;
    }
    public String getPathLike(){
        return this.pathLike;
    }
    public void setPathLike(String pathLike){
        this.pathLike = pathLike;
    }

    public String getTaille(){
        return this.taille;
    }
    public void setTaille(String taille){
        this.taille = taille;
    }
    public String getTailleLike(){
        return this.tailleLike;
    }
    public void setTailleLike(String tailleLike){
        this.tailleLike = tailleLike;
    }


    public EmailCriteria getEmail(){
        return this.email;
    }

    public void setEmail(EmailCriteria email){
        this.email = email;
    }
    public List<EmailCriteria> getEmails(){
        return this.emails;
    }

    public void setEmails(List<EmailCriteria> emails){
        this.emails = emails;
    }
    public TypeContenuCriteria getTypeContenu(){
        return this.typeContenu;
    }

    public void setTypeContenu(TypeContenuCriteria typeContenu){
        this.typeContenu = typeContenu;
    }
    public List<TypeContenuCriteria> getTypeContenus(){
        return this.typeContenus;
    }

    public void setTypeContenus(List<TypeContenuCriteria> typeContenus){
        this.typeContenus = typeContenus;
    }
}
