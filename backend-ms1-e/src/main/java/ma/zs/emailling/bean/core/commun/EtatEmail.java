package ma.zs.emailling.bean.core.commun;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.emailling.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "etat_email")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="etat_email_seq",sequenceName="etat_email_seq",allocationSize=1, initialValue = 1)
public class EtatEmail   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String libelle;
    @Column(length = 500)
    private String code;



    public EtatEmail(){
        super();
    }

    public EtatEmail(Long id){
        this.id = id;
    }

    public EtatEmail(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }
    public EtatEmail(String libelle){
        this.libelle = libelle ;
    }




    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="etat_email_seq")
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
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }

    @Transient
    public String getLabel() {
        label = libelle;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EtatEmail etatEmail = (EtatEmail) o;
        return id != null && id.equals(etatEmail.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

