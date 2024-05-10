package ma.zs.emailling.bean.core.commun;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.emailling.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "category_email")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="category_email_seq",sequenceName="category_email_seq",allocationSize=1, initialValue = 1)
public class CategoryEmail   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String name;
    @Column(length = 500)
    private String code;



    public CategoryEmail(){
        super();
    }

    public CategoryEmail(Long id){
        this.id = id;
    }

    public CategoryEmail(Long id,String name){
        this.id = id;
        this.name = name ;
    }
    public CategoryEmail(String name){
        this.name = name ;
    }




    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="category_email_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }

    @Transient
    public String getLabel() {
        label = name;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryEmail categoryEmail = (CategoryEmail) o;
        return id != null && id.equals(categoryEmail.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

