package  ma.zs.emailling.dao.criteria.core.emailgroup;


import ma.zs.emailling.dao.criteria.core.commun.TypeContenuCriteria;

import ma.zs.emailling.zynerator.criteria.BaseCriteria;
import java.util.List;

public class EmailGroupePieceJointCriteria extends  BaseCriteria  {

    private String path;
    private String pathLike;
    private String taille;
    private String tailleMin;
    private String tailleMax;

    private TypeContenuCriteria typecontenu ;
    private List<TypeContenuCriteria> typecontenus ;
    private GroupeEmailCriteria groupeEmail ;
    private List<GroupeEmailCriteria> groupeEmails ;


    public EmailGroupePieceJointCriteria(){}

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
    public String getTailleMin(){
        return this.tailleMin;
    }
    public void setTailleMin(String tailleMin){
        this.tailleMin = tailleMin;
    }
    public String getTailleMax(){
        return this.tailleMax;
    }
    public void setTailleMax(String tailleMax){
        this.tailleMax = tailleMax;
    }
      

    public TypeContenuCriteria getTypecontenu(){
        return this.typecontenu;
    }

    public void setTypecontenu(TypeContenuCriteria typecontenu){
        this.typecontenu = typecontenu;
    }
    public List<TypeContenuCriteria> getTypecontenus(){
        return this.typecontenus;
    }

    public void setTypecontenus(List<TypeContenuCriteria> typecontenus){
        this.typecontenus = typecontenus;
    }
    public GroupeEmailCriteria getGroupeEmail(){
        return this.groupeEmail;
    }

    public void setGroupeEmail(GroupeEmailCriteria groupeEmail){
        this.groupeEmail = groupeEmail;
    }
    public List<GroupeEmailCriteria> getGroupeEmails(){
        return this.groupeEmails;
    }

    public void setGroupeEmails(List<GroupeEmailCriteria> groupeEmails){
        this.groupeEmails = groupeEmails;
    }
}
