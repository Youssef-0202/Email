package  ma.zs.emailling.dao.criteria.core.email;


import ma.zs.emailling.dao.criteria.core.commun.EtatEmailCriteria;
import ma.zs.emailling.dao.criteria.core.commun.UtilisateurCriteria;

import ma.zs.emailling.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class EmailDetailCriteria extends  BaseCriteria  {

    private LocalDateTime dateLecture;
    private LocalDateTime dateLectureFrom;
    private LocalDateTime dateLectureTo;
    private LocalDateTime dateReception;
    private LocalDateTime dateReceptionFrom;
    private LocalDateTime dateReceptionTo;

    private EmailCriteria email ;
    private List<EmailCriteria> emails ;
    private UtilisateurCriteria personneDestinataire ;
    private List<UtilisateurCriteria> personneDestinataires ;
    private EtatEmailCriteria etatEmail ;
    private List<EtatEmailCriteria> etatEmails ;


    public EmailDetailCriteria(){}

    public LocalDateTime getDateLecture(){
        return this.dateLecture;
    }
    public void setDateLecture(LocalDateTime dateLecture){
        this.dateLecture = dateLecture;
    }
    public LocalDateTime getDateLectureFrom(){
        return this.dateLectureFrom;
    }
    public void setDateLectureFrom(LocalDateTime dateLectureFrom){
        this.dateLectureFrom = dateLectureFrom;
    }
    public LocalDateTime getDateLectureTo(){
        return this.dateLectureTo;
    }
    public void setDateLectureTo(LocalDateTime dateLectureTo){
        this.dateLectureTo = dateLectureTo;
    }
    public LocalDateTime getDateReception(){
        return this.dateReception;
    }
    public void setDateReception(LocalDateTime dateReception){
        this.dateReception = dateReception;
    }
    public LocalDateTime getDateReceptionFrom(){
        return this.dateReceptionFrom;
    }
    public void setDateReceptionFrom(LocalDateTime dateReceptionFrom){
        this.dateReceptionFrom = dateReceptionFrom;
    }
    public LocalDateTime getDateReceptionTo(){
        return this.dateReceptionTo;
    }
    public void setDateReceptionTo(LocalDateTime dateReceptionTo){
        this.dateReceptionTo = dateReceptionTo;
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
    public UtilisateurCriteria getPersonneDestinataire(){
        return this.personneDestinataire;
    }

    public void setPersonneDestinataire(UtilisateurCriteria personneDestinataire){
        this.personneDestinataire = personneDestinataire;
    }
    public List<UtilisateurCriteria> getPersonneDestinataires(){
        return this.personneDestinataires;
    }

    public void setPersonneDestinataires(List<UtilisateurCriteria> personneDestinataires){
        this.personneDestinataires = personneDestinataires;
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
