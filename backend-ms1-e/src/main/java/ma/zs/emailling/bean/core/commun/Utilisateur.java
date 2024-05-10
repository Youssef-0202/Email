package ma.zs.emailling.bean.core.commun;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.emailling.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "utilisateur")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="utilisateur_seq",sequenceName="utilisateur_seq",allocationSize=1, initialValue = 1)
public class Utilisateur   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String username;
    @Column(length = 500)
    private String password;
    @Column(length = 500)
    private String email;
    @Column(length = 500)
    private String signature;



    public Utilisateur(){
        super();
    }

    public Utilisateur(Long id){
        this.id = id;
    }

    public Utilisateur(Long id,String email){
        this.id = id;
        this.email = email ;
    }
    public Utilisateur(String email){
        this.email = email ;
    }




    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="utilisateur_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getUsername(){
        return this.username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getSignature(){
        return this.signature;
    }
    public void setSignature(String signature){
        this.signature = signature;
    }

    @Transient
    public String getLabel() {
        label = email;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utilisateur utilisateur = (Utilisateur) o;
        return id != null && id.equals(utilisateur.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

