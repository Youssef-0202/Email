package  ma.zs.emailling.dao.criteria.core.email;


import ma.zs.emailling.dao.criteria.core.commun.EtatEmailCriteria;
import ma.zs.emailling.dao.criteria.core.commun.UtilisateurCriteria;
import ma.zs.emailling.dao.criteria.core.commun.CategoryEmailCriteria;

import ma.zs.emailling.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class EmailCriteria extends  BaseCriteria  {

    private String ref;
    private String refLike;
    private LocalDateTime dateEnvoi;
    private LocalDateTime dateEnvoiFrom;
    private LocalDateTime dateEnvoiTo;
    private String corps;
    private String corpsLike;
    private String header;
    private String headerLike;

    private UtilisateurCriteria personneSource ;
    private List<UtilisateurCriteria> personneSources ;
    private CategoryEmailCriteria categoryEmail ;
    private List<CategoryEmailCriteria> categoryEmails ;
    private EtatEmailCriteria etatEmail ;
    private List<EtatEmailCriteria> etatEmails ;


    public EmailCriteria(){}

    public String getRef(){
        return this.ref;
    }
    public void setRef(String ref){
        this.ref = ref;
    }
    public String getRefLike(){
        return this.refLike;
    }
    public void setRefLike(String refLike){
        this.refLike = refLike;
    }

    public LocalDateTime getDateEnvoi(){
        return this.dateEnvoi;
    }
    public void setDateEnvoi(LocalDateTime dateEnvoi){
        this.dateEnvoi = dateEnvoi;
    }
    public LocalDateTime getDateEnvoiFrom(){
        return this.dateEnvoiFrom;
    }
    public void setDateEnvoiFrom(LocalDateTime dateEnvoiFrom){
        this.dateEnvoiFrom = dateEnvoiFrom;
    }
    public LocalDateTime getDateEnvoiTo(){
        return this.dateEnvoiTo;
    }
    public void setDateEnvoiTo(LocalDateTime dateEnvoiTo){
        this.dateEnvoiTo = dateEnvoiTo;
    }
    public String getCorps(){
        return this.corps;
    }
    public void setCorps(String corps){
        this.corps = corps;
    }
    public String getCorpsLike(){
        return this.corpsLike;
    }
    public void setCorpsLike(String corpsLike){
        this.corpsLike = corpsLike;
    }

    public String getHeader(){
        return this.header;
    }
    public void setHeader(String header){
        this.header = header;
    }
    public String getHeaderLike(){
        return this.headerLike;
    }
    public void setHeaderLike(String headerLike){
        this.headerLike = headerLike;
    }


    public UtilisateurCriteria getPersonneSource(){
        return this.personneSource;
    }

    public void setPersonneSource(UtilisateurCriteria personneSource){
        this.personneSource = personneSource;
    }
    public List<UtilisateurCriteria> getPersonneSources(){
        return this.personneSources;
    }

    public void setPersonneSources(List<UtilisateurCriteria> personneSources){
        this.personneSources = personneSources;
    }
    public CategoryEmailCriteria getCategoryEmail(){
        return this.categoryEmail;
    }

    public void setCategoryEmail(CategoryEmailCriteria categoryEmail){
        this.categoryEmail = categoryEmail;
    }
    public List<CategoryEmailCriteria> getCategoryEmails(){
        return this.categoryEmails;
    }

    public void setCategoryEmails(List<CategoryEmailCriteria> categoryEmails){
        this.categoryEmails = categoryEmails;
    }
    public EtatEmailCriteria getEtatEmail(){
        return this.etatEmail;
    }

    public void setEtatEmail(EtatEmailCriteria etatEmail){
        this.etatEmail = etatEmail;
    }
    public List<EtatEmailCriteria> getEtatEmails(){
        return this.etatEmails;
    }

    public void setEtatEmails(List<EtatEmailCriteria> etatEmails){
        this.etatEmails = etatEmails;
    }
}
