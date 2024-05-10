package  ma.zs.emailling.ws.dto.emailgroup;

import ma.zs.emailling.zynerator.audit.Log;
import ma.zs.emailling.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.emailling.ws.dto.email.EmailDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmailDetailGroupDto  extends AuditBaseDto {

    private String dateReception ;
    private String dateLecture ;

    private EmailDto email ;
    private GroupeEmailDto destination ;



    public EmailDetailGroupDto(){
        super();
    }



    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateReception(){
        return this.dateReception;
    }
    public void setDateReception(String dateReception){
        this.dateReception = dateReception;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateLecture(){
        return this.dateLecture;
    }
    public void setDateLecture(String dateLecture){
        this.dateLecture = dateLecture;
    }


    public EmailDto getEmail(){
        return this.email;
    }

    public void setEmail(EmailDto email){
        this.email = email;
    }
    public GroupeEmailDto getDestination(){
        return this.destination;
    }

    public void setDestination(GroupeEmailDto destination){
        this.destination = destination;
    }






}
