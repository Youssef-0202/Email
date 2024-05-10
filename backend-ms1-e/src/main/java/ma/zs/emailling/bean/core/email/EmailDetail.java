package ma.zs.emailling.bean.core.email;

import java.util.Objects;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.emailling.bean.core.commun.EtatEmail;
import ma.zs.emailling.bean.core.email.Email;
import ma.zs.emailling.bean.core.commun.Utilisateur;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.emailling.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "email_detail")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="email_detail_seq",sequenceName="email_detail_seq",allocationSize=1, initialValue = 1)
public class EmailDetail   extends AuditBusinessObject     {

    private Long id;

    private LocalDateTime dateLecture ;
    private LocalDateTime dateReception ;

    private Email email ;
    private Utilisateur personneDestinataire ;
    private EtatEmail etatEmail ;


    public EmailDetail(){
        super();
    }

    public EmailDetail(Long id){
        this.id = id;
    }





    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="email_detail_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "email")
    public Email getEmail(){
        return this.email;
    }
    public void setEmail(Email email){
        this.email = email;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personne_destinataire")
    public Utilisateur getPersonneDestinataire(){
        return this.personneDestinataire;
    }
    public void setPersonneDestinataire(Utilisateur personneDestinataire){
        this.personneDestinataire = personneDestinataire;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "etat_email")
    public EtatEmail getEtatEmail(){
        return this.etatEmail;
    }
    public void setEtatEmail(EtatEmail etatEmail){
        this.etatEmail = etatEmail;
    }
    public LocalDateTime getDateLecture(){
        return this.dateLecture;
    }
    public void setDateLecture(LocalDateTime dateLecture){
        this.dateLecture = dateLecture;
    }
    public LocalDateTime getDateReception(){
        return this.dateReception;
    }
    public void setDateReception(LocalDateTime dateReception){
        this.dateReception = dateReception;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailDetail emailDetail = (EmailDetail) o;
        return id != null && id.equals(emailDetail.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

