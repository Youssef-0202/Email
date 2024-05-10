package ma.zs.emailling.bean.core.commun;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.emailling.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "type_contenu")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="type_contenu_seq",sequenceName="type_contenu_seq",allocationSize=1, initialValue = 1)
public class TypeContenu   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String libelle;
    @Column(length = 500)
    private String code;



    public TypeContenu(){
        super();
    }

    public TypeContenu(Long id){
        this.id = id;
    }

    public TypeContenu(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }
    public TypeContenu(String libelle){
        this.libelle = libelle ;
    }




    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="type_contenu_seq")
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
        TypeContenu typeContenu = (TypeContenu) o;
        return id != null && id.equals(typeContenu.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

