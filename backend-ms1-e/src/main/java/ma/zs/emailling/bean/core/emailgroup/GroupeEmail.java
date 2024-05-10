package ma.zs.emailling.bean.core.emailgroup;

import java.util.Objects;
import java.util.List;





import ma.zs.emailling.bean.core.emailgroup.GroupeEmailDetail;
import ma.zs.emailling.bean.core.commun.Utilisateur;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.emailling.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "groupe_email")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="groupe_email_seq",sequenceName="groupe_email_seq",allocationSize=1, initialValue = 1)
public class GroupeEmail   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String libelle;

    private Utilisateur adminGroupe ;

    private List<GroupeEmailDetail> groupeEmailDetails ;

    public GroupeEmail(){
        super();
    }

    public GroupeEmail(Long id){
        this.id = id;
    }





    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="groupe_email_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_groupe")
    public Utilisateur getAdminGroupe(){
        return this.adminGroupe;
    }
    public void setAdminGroupe(Utilisateur adminGroupe){
        this.adminGroupe = adminGroupe;
    }
    @OneToMany(mappedBy = "groupeEmail")

    public List<GroupeEmailDetail> getGroupeEmailDetails(){
        return this.groupeEmailDetails;
    }
    public void setGroupeEmailDetails(List<GroupeEmailDetail> groupeEmailDetails){
        this.groupeEmailDetails = groupeEmailDetails;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupeEmail groupeEmail = (GroupeEmail) o;
        return id != null && id.equals(groupeEmail.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

