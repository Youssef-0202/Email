package ma.zs.emailling.bean.core.emailgroup;

import java.util.Objects;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.emailling.bean.core.commun.Utilisateur;
import ma.zs.emailling.bean.core.emailgroup.GroupeEmail;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.emailling.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "groupe_email_detail")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="groupe_email_detail_seq",sequenceName="groupe_email_detail_seq",allocationSize=1, initialValue = 1)
public class GroupeEmailDetail   extends AuditBusinessObject     {

    private Long id;

    private LocalDateTime dateAjoute ;
    private LocalDateTime dateBlockage ;

    private Utilisateur personne ;
    private GroupeEmail groupeEmail ;


    public GroupeEmailDetail(){
        super();
    }

    public GroupeEmailDetail(Long id){
        this.id = id;
    }





    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="groupe_email_detail_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personne")
    public Utilisateur getPersonne(){
        return this.personne;
    }
    public void setPersonne(Utilisateur personne){
        this.personne = personne;
    }
    public LocalDateTime getDateAjoute(){
        return this.dateAjoute;
    }
    public void setDateAjoute(LocalDateTime dateAjoute){
        this.dateAjoute = dateAjoute;
    }
    public LocalDateTime getDateBlockage(){
        return this.dateBlockage;
    }
    public void setDateBlockage(LocalDateTime dateBlockage){
        this.dateBlockage = dateBlockage;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "groupe_email")
    public GroupeEmail getGroupeEmail(){
        return this.groupeEmail;
    }
    public void setGroupeEmail(GroupeEmail groupeEmail){
        this.groupeEmail = groupeEmail;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupeEmailDetail groupeEmailDetail = (GroupeEmailDetail) o;
        return id != null && id.equals(groupeEmailDetail.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

