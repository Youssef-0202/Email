package  ma.zs.emailling.dao.criteria.core.emailgroup;


import ma.zs.emailling.dao.criteria.core.commun.UtilisateurCriteria;

import ma.zs.emailling.zynerator.criteria.BaseCriteria;
import java.util.List;

public class GroupeEmailCriteria extends  BaseCriteria  {

    private String libelle;
    private String libelleLike;

    private UtilisateurCriteria adminGroupe ;
    private List<UtilisateurCriteria> adminGroupes ;


    public GroupeEmailCriteria(){}

    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    public String getLibelleLike(){
        return this.libelleLike;
    }
    public void setLibelleLike(String libelleLike){
        this.libelleLike = libelleLike;
    }


    public UtilisateurCriteria getAdminGroupe(){
        return this.adminGroupe;
    }

    public void setAdminGroupe(UtilisateurCriteria adminGroupe){
        this.adminGroupe = adminGroupe;
    }
    public List<UtilisateurCriteria> getAdminGroupes(){
        return this.adminGroupes;
    }

    public void setAdminGroupes(List<UtilisateurCriteria> adminGroupes){
        this.adminGroupes = adminGroupes;
    }
}
