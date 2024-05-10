package  ma.zs.emailling.dao.criteria.core.emailgroup;


import ma.zs.emailling.dao.criteria.core.commun.UtilisateurCriteria;

import ma.zs.emailling.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class GroupeEmailDetailCriteria extends  BaseCriteria  {

    private LocalDateTime dateAjoute;
    private LocalDateTime dateAjouteFrom;
    private LocalDateTime dateAjouteTo;
    private LocalDateTime dateBlockage;
    private LocalDateTime dateBlockageFrom;
    private LocalDateTime dateBlockageTo;

    private UtilisateurCriteria personne ;
    private List<UtilisateurCriteria> personnes ;
    private GroupeEmailCriteria groupeEmail ;
    private List<GroupeEmailCriteria> groupeEmails ;


    public GroupeEmailDetailCriteria(){}

    public LocalDateTime getDateAjoute(){
        return this.dateAjoute;
    }
    public void setDateAjoute(LocalDateTime dateAjoute){
        this.dateAjoute = dateAjoute;
    }
    public LocalDateTime getDateAjouteFrom(){
        return this.dateAjouteFrom;
    }
    public void setDateAjouteFrom(LocalDateTime dateAjouteFrom){
        this.dateAjouteFrom = dateAjouteFrom;
    }
    public LocalDateTime getDateAjouteTo(){
        return this.dateAjouteTo;
    }
    public void setDateAjouteTo(LocalDateTime dateAjouteTo){
        this.dateAjouteTo = dateAjouteTo;
    }
    public LocalDateTime getDateBlockage(){
        return this.dateBlockage;
    }
    public void setDateBlockage(LocalDateTime dateBlockage){
        this.dateBlockage = dateBlockage;
    }
    public LocalDateTime getDateBlockageFrom(){
        return this.dateBlockageFrom;
    }
    public void setDateBlockageFrom(LocalDateTime dateBlockageFrom){
        this.dateBlockageFrom = dateBlockageFrom;
    }
    public LocalDateTime getDateBlockageTo(){
        return this.dateBlockageTo;
    }
    public void setDateBlockageTo(LocalDateTime dateBlockageTo){
        this.dateBlockageTo = dateBlockageTo;
    }

    public UtilisateurCriteria getPersonne(){
        return this.personne;
    }

    public void setPersonne(UtilisateurCriteria personne){
        this.personne = personne;
    }
    public List<UtilisateurCriteria> getPersonnes(){
        return this.personnes;
    }

    public void setPersonnes(List<UtilisateurCriteria> personnes){
        this.personnes = personnes;
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
