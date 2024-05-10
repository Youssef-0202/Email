package ma.zs.emailling.bean.core.emailgroup;

import java.util.Objects;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.emailling.bean.core.email.Email;
import ma.zs.emailling.bean.core.emailgroup.GroupeEmail;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.emailling.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "email_detail_group")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="email_detail_group_seq",sequenceName="email_detail_group_seq",allocationSize=1, initialValue = 1)
public class EmailDetailGroup   extends AuditBusinessObject     {

    private Long id;

    private LocalDateTime dateReception ;
    private LocalDateTime dateLecture ;

    private Email email ;
    private GroupeEmail destination ;


    public EmailDetailGroup(){
        super();
    }

    public EmailDetailGroup(Long id){
        this.id = id;
    }





    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="email_detail_group_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "email")
    public Email getEmail(){
        return this.email;
    }
    public void setEmail(Email email){
        this.email = email;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "destination")
    public GroupeEmail getDestination(){
        return this.destination;
    }
    public void setDestination(GroupeEmail destination){
        this.destination = destination;
    }
    public LocalDateTime getDateReception(){
        return this.dateReception;
    }
    public void setDateReception(LocalDateTime dateReception){
        this.dateReception = dateReception;
    }
    public LocalDateTime getDateLecture(){
        return this.dateLecture;
    }
    public void setDateLecture(LocalDateTime dateLecture){
        this.dateLecture = dateLecture;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailDetailGroup emailDetailGroup = (EmailDetailGroup) o;
        return id != null && id.equals(emailDetailGroup.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

