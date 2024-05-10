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
@Table(name = "keep_note")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="keep_note_seq",sequenceName="keep_note_seq",allocationSize=1, initialValue = 1)
public class KeepNote   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String body;
    @Column(length = 500)
    private String header;
    private LocalDateTime dateKeepNote ;

    private Utilisateur personne ;


    public KeepNote(){
        super();
    }

    public KeepNote(Long id){
        this.id = id;
    }





    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="keep_note_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getBody(){
        return this.body;
    }
    public void setBody(String body){
        this.body = body;
    }
    public String getHeader(){
        return this.header;
    }
    public void setHeader(String header){
        this.header = header;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personne")
    public Utilisateur getPersonne(){
        return this.personne;
    }
    public void setPersonne(Utilisateur personne){
        this.personne = personne;
    }
    public LocalDateTime getDateKeepNote(){
        return this.dateKeepNote;
    }
    public void setDateKeepNote(LocalDateTime dateKeepNote){
        this.dateKeepNote = dateKeepNote;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeepNote keepNote = (KeepNote) o;
        return id != null && id.equals(keepNote.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

