package ma.zs.emailling.bean.core.emailgroup;

import java.util.Objects;





import ma.zs.emailling.bean.core.commun.TypeContenu;
import ma.zs.emailling.bean.core.emailgroup.GroupeEmail;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.emailling.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "email_groupe_piece_joint")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="email_groupe_piece_joint_seq",sequenceName="email_groupe_piece_joint_seq",allocationSize=1, initialValue = 1)
public class EmailGroupePieceJoint   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String path;
    private Long taille ;

    private TypeContenu typecontenu ;
    private GroupeEmail groupeEmail ;


    public EmailGroupePieceJoint(){
        super();
    }

    public EmailGroupePieceJoint(Long id){
        this.id = id;
    }





    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="email_groupe_piece_joint_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getPath(){
        return this.path;
    }
    public void setPath(String path){
        this.path = path;
    }
    public Long getTaille(){
        return this.taille;
    }
    public void setTaille(Long taille){
        this.taille = taille;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "typecontenu")
    public TypeContenu getTypecontenu(){
        return this.typecontenu;
    }
    public void setTypecontenu(TypeContenu typecontenu){
        this.typecontenu = typecontenu;
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
        EmailGroupePieceJoint emailGroupePieceJoint = (EmailGroupePieceJoint) o;
        return id != null && id.equals(emailGroupePieceJoint.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

