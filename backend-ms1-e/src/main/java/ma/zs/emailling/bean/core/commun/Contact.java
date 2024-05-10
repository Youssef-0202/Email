package ma.zs.emailling.bean.core.commun;

import java.util.Objects;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.emailling.bean.core.commun.Utilisateur;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.emailling.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "contact")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="contact_seq",sequenceName="contact_seq",allocationSize=1, initialValue = 1)
public class Contact   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String name;
    private LocalDateTime dateAjout ;
    private Utilisateur personneSource ;
    private Utilisateur personneDestination ;


    public Contact(){
        super();
    }

    public Contact(Long id){
        this.id = id;
    }





    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="contact_seq")
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
    public LocalDateTime getDateAjout(){
        return this.dateAjout;
    }
    public void setDateAjout(LocalDateTime dateAjout){
        this.dateAjout = dateAjout;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personne_source")
    public Utilisateur getPersonneSource(){
        return this.personneSource;
    }
    public void setPersonneSource(Utilisateur personneSource){
        this.personneSource = personneSource;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personne_destination")
    public Utilisateur getPersonneDestination(){
        return this.personneDestination;
    }
    public void setPersonneDestination(Utilisateur personneDestination){
        this.personneDestination = personneDestination;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return id != null && id.equals(contact.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

