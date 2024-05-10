package ma.zs.emailling.bean.core.email;

import java.util.Objects;
import java.util.List;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.emailling.bean.core.commun.EtatEmail;
import ma.zs.emailling.bean.core.email.EmailpieceJoin;
import ma.zs.emailling.bean.core.commun.TypeContenu;
import ma.zs.emailling.bean.core.emailgroup.EmailDetailGroup;
import ma.zs.emailling.bean.core.commun.Utilisateur;
import ma.zs.emailling.bean.core.commun.CategoryEmail;
import ma.zs.emailling.bean.core.email.EmailDetail;
import ma.zs.emailling.bean.core.emailgroup.GroupeEmail;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.emailling.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "email")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="email_seq",sequenceName="email_seq",allocationSize=1, initialValue = 1)
public class Email   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String ref;
    private LocalDateTime dateEnvoi ;
    @Column(length = 500)
    private String corps;
    @Column(length = 500)
    private String header;

    private Utilisateur personneSource ;
    private CategoryEmail categoryEmail ;
    private EtatEmail etatEmail ;

    private List<EmailDetail> emailDetails ;
    private List<EmailpieceJoin> emailpieceJoints ;
    private List<EmailDetailGroup> emailDetailGroups ;

    public Email(){
        super();
    }

    public Email(Long id){
        this.id = id;
    }

    public Email(Long id,String ref){
        this.id = id;
        this.ref = ref ;
    }
    public Email(String ref){
        this.ref = ref ;
    }




    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="email_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getRef(){
        return this.ref;
    }
    public void setRef(String ref){
        this.ref = ref;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personne_source")
    public Utilisateur getPersonneSource(){
        return this.personneSource;
    }
    public void setPersonneSource(Utilisateur personneSource){
        this.personneSource = personneSource;
    }
    public LocalDateTime getDateEnvoi(){
        return this.dateEnvoi;
    }
    public void setDateEnvoi(LocalDateTime dateEnvoi){
        this.dateEnvoi = dateEnvoi;
    }
    public String getCorps(){
        return this.corps;
    }
    public void setCorps(String corps){
        this.corps = corps;
    }
    public String getHeader(){
        return this.header;
    }
    public void setHeader(String header){
        this.header = header;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_email")
    public CategoryEmail getCategoryEmail(){
        return this.categoryEmail;
    }
    public void setCategoryEmail(CategoryEmail categoryEmail){
        this.categoryEmail = categoryEmail;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "etat_email")
    public EtatEmail getEtatEmail(){
        return this.etatEmail;
    }
    public void setEtatEmail(EtatEmail etatEmail){
        this.etatEmail = etatEmail;
    }
    @OneToMany(mappedBy = "email")

    public List<EmailDetail> getEmailDetails(){
        return this.emailDetails;
    }
    public void setEmailDetails(List<EmailDetail> emailDetails){
        this.emailDetails = emailDetails;
    }
    @OneToMany(mappedBy = "email")

    public List<EmailpieceJoin> getEmailpieceJoints(){
        return this.emailpieceJoints;
    }
    public void setEmailpieceJoints(List<EmailpieceJoin> emailpieceJoints){
        this.emailpieceJoints = emailpieceJoints;
    }
    @OneToMany(mappedBy = "email")

    public List<EmailDetailGroup> getEmailDetailGroups(){
        return this.emailDetailGroups;
    }
    public void setEmailDetailGroups(List<EmailDetailGroup> emailDetailGroups){
        this.emailDetailGroups = emailDetailGroups;
    }

    @Transient
    public String getLabel() {
        label = ref;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return id != null && id.equals(email.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

