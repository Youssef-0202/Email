package  ma.zs.emailling.ws.converter.emailgroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.emailling.ws.converter.email.EmailConverter;
import ma.zs.emailling.ws.converter.emailgroup.GroupeEmailConverter;

import ma.zs.emailling.bean.core.email.Email;
import ma.zs.emailling.bean.core.emailgroup.GroupeEmail;


import ma.zs.emailling.zynerator.util.StringUtil;
import ma.zs.emailling.zynerator.converter.AbstractConverter;
import ma.zs.emailling.zynerator.util.DateUtil;
import ma.zs.emailling.bean.core.emailgroup.EmailDetailGroup;
import ma.zs.emailling.ws.dto.emailgroup.EmailDetailGroupDto;

@Component
public class EmailDetailGroupConverter extends AbstractConverter<EmailDetailGroup, EmailDetailGroupDto> {

    @Autowired
    private EmailConverter emailConverter ;
    @Autowired
    private GroupeEmailConverter groupeEmailConverter ;
    private boolean email;
    private boolean destination;

    public  EmailDetailGroupConverter() {
        super(EmailDetailGroup.class, EmailDetailGroupDto.class);
        init(true);
    }

    @Override
    public EmailDetailGroup toItem(EmailDetailGroupDto dto) {
        if (dto == null) {
            return null;
        } else {
        EmailDetailGroup item = new EmailDetailGroup();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getDateReception()))
                item.setDateReception(DateUtil.stringEnToDate(dto.getDateReception()));
            if(StringUtil.isNotEmpty(dto.getDateLecture()))
                item.setDateLecture(DateUtil.stringEnToDate(dto.getDateLecture()));
            if(dto.getEmail() != null && dto.getEmail().getId() != null){
                item.setEmail(new Email());
                item.getEmail().setId(dto.getEmail().getId());
                item.getEmail().setRef(dto.getEmail().getRef());
            }

            if(dto.getDestination() != null && dto.getDestination().getId() != null){
                item.setDestination(new GroupeEmail());
                item.getDestination().setId(dto.getDestination().getId());
                item.getDestination().setId(dto.getDestination().getId());
            }




        return item;
        }
    }

    @Override
    public EmailDetailGroupDto toDto(EmailDetailGroup item) {
        if (item == null) {
            return null;
        } else {
            EmailDetailGroupDto dto = new EmailDetailGroupDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(item.getDateReception()!=null)
                dto.setDateReception(DateUtil.dateTimeToString(item.getDateReception()));
            if(item.getDateLecture()!=null)
                dto.setDateLecture(DateUtil.dateTimeToString(item.getDateLecture()));
            if(this.email && item.getEmail()!=null) {
                dto.setEmail(emailConverter.toDto(item.getEmail())) ;

            }
            if(this.destination && item.getDestination()!=null) {
                dto.setDestination(groupeEmailConverter.toDto(item.getDestination())) ;

            }


        return dto;
        }
    }

    public void copy(EmailDetailGroupDto dto, EmailDetailGroup t) {
    super.copy(dto, t);
    if (dto.getEmail() != null)
        emailConverter.copy(dto.getEmail(), t.getEmail());
    if (dto.getDestination() != null)
        groupeEmailConverter.copy(dto.getDestination(), t.getDestination());
    }



    public void initObject(boolean value) {
        this.email = value;
        this.destination = value;
    }


    public EmailConverter getEmailConverter(){
        return this.emailConverter;
    }
    public void setEmailConverter(EmailConverter emailConverter ){
        this.emailConverter = emailConverter;
    }
    public GroupeEmailConverter getGroupeEmailConverter(){
        return this.groupeEmailConverter;
    }
    public void setGroupeEmailConverter(GroupeEmailConverter groupeEmailConverter ){
        this.groupeEmailConverter = groupeEmailConverter;
    }
    public boolean  isEmail(){
        return this.email;
    }
    public void  setEmail(boolean email){
        this.email = email;
    }
    public boolean  isDestination(){
        return this.destination;
    }
    public void  setDestination(boolean destination){
        this.destination = destination;
    }
}
