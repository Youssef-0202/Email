package  ma.zs.emailling.ws.converter.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.emailling.ws.converter.email.EmailConverter;
import ma.zs.emailling.ws.converter.commun.TypeContenuConverter;

import ma.zs.emailling.bean.core.email.Email;


import ma.zs.emailling.zynerator.util.StringUtil;
import ma.zs.emailling.zynerator.converter.AbstractConverter;
import ma.zs.emailling.zynerator.util.DateUtil;
import ma.zs.emailling.bean.core.email.EmailpieceJoin;
import ma.zs.emailling.ws.dto.email.EmailpieceJoinDto;

@Component
public class EmailpieceJoinConverter extends AbstractConverter<EmailpieceJoin, EmailpieceJoinDto> {

    @Autowired
    private EmailConverter emailConverter ;
    @Autowired
    private TypeContenuConverter typeContenuConverter ;
    private boolean email;
    private boolean typeContenu;

    public  EmailpieceJoinConverter() {
        super(EmailpieceJoin.class, EmailpieceJoinDto.class);
        init(true);
    }

    @Override
    public EmailpieceJoin toItem(EmailpieceJoinDto dto) {
        if (dto == null) {
            return null;
        } else {
        EmailpieceJoin item = new EmailpieceJoin();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getPath()))
                item.setPath(dto.getPath());
            if(StringUtil.isNotEmpty(dto.getTaille()))
                item.setTaille(dto.getTaille());
            if(dto.getEmail() != null && dto.getEmail().getId() != null){
                item.setEmail(new Email());
                item.getEmail().setId(dto.getEmail().getId());
                item.getEmail().setRef(dto.getEmail().getRef());
            }

            if(this.typeContenu && dto.getTypeContenu()!=null)
                item.setTypeContenu(typeContenuConverter.toItem(dto.getTypeContenu())) ;




        return item;
        }
    }

    @Override
    public EmailpieceJoinDto toDto(EmailpieceJoin item) {
        if (item == null) {
            return null;
        } else {
            EmailpieceJoinDto dto = new EmailpieceJoinDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getPath()))
                dto.setPath(item.getPath());
            if(StringUtil.isNotEmpty(item.getTaille()))
                dto.setTaille(item.getTaille());
            if(this.email && item.getEmail()!=null) {
                dto.setEmail(emailConverter.toDto(item.getEmail())) ;

            }
            if(this.typeContenu && item.getTypeContenu()!=null) {
                dto.setTypeContenu(typeContenuConverter.toDto(item.getTypeContenu())) ;

            }


        return dto;
        }
    }

    public void copy(EmailpieceJoinDto dto, EmailpieceJoin t) {
    super.copy(dto, t);
    if (dto.getEmail() != null)
        emailConverter.copy(dto.getEmail(), t.getEmail());
    if (dto.getTypeContenu() != null)
        typeContenuConverter.copy(dto.getTypeContenu(), t.getTypeContenu());
    }



    public void initObject(boolean value) {
        this.email = value;
        this.typeContenu = value;
    }


    public EmailConverter getEmailConverter(){
        return this.emailConverter;
    }
    public void setEmailConverter(EmailConverter emailConverter ){
        this.emailConverter = emailConverter;
    }
    public TypeContenuConverter getTypeContenuConverter(){
        return this.typeContenuConverter;
    }
    public void setTypeContenuConverter(TypeContenuConverter typeContenuConverter ){
        this.typeContenuConverter = typeContenuConverter;
    }
    public boolean  isEmail(){
        return this.email;
    }
    public void  setEmail(boolean email){
        this.email = email;
    }
    public boolean  isTypeContenu(){
        return this.typeContenu;
    }
    public void  setTypeContenu(boolean typeContenu){
        this.typeContenu = typeContenu;
    }
}
