package  ma.zs.emailling.dao.criteria.core.emailgroup;


import ma.zs.emailling.dao.criteria.core.email.EmailCriteria;

import ma.zs.emailling.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class EmailDetailGroupCriteria extends  BaseCriteria  {

    private LocalDateTime dateReception;
    private LocalDateTime dateReceptionFrom;
    private LocalDateTime dateReceptionTo;
    private LocalDateTime dateLecture;
    private LocalDateTime dateLectureFrom;
    private LocalDateTime dateLectureTo;

    private EmailCriteria email ;
    private List<EmailCriteria> emails ;
    private GroupeEmailCriteria destination ;
    private List<GroupeEmailCriteria> destinations ;


    public EmailDetailGroupCriteria(){}

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
    public GroupeEmailCriteria getDestination(){
        return this.destination;
    }

    public void setDestination(GroupeEmailCriteria destination){
        this.destination = destination;
    }
    public List<GroupeEmailCriteria> getDestinations(){
        return this.destinations;
    }

    public void setDestinations(List<GroupeEmailCriteria> destinations){
        this.destinations = destinations;
    }
}
