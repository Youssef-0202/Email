package  ma.zs.emailling.ws.converter.emailgroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.emailling.ws.converter.commun.TypeContenuConverter;
import ma.zs.emailling.ws.converter.emailgroup.GroupeEmailConverter;

import ma.zs.emailling.bean.core.emailgroup.GroupeEmail;


import ma.zs.emailling.zynerator.util.StringUtil;
import ma.zs.emailling.zynerator.converter.AbstractConverter;
import ma.zs.emailling.zynerator.util.DateUtil;
import ma.zs.emailling.bean.core.emailgroup.EmailGroupePieceJoint;
import ma.zs.emailling.ws.dto.emailgroup.EmailGroupePieceJointDto;

@Component
public class EmailGroupePieceJointConverter extends AbstractConverter<EmailGroupePieceJoint, EmailGroupePieceJointDto> {

    @Autowired
    private TypeContenuConverter typeContenuConverter ;
    @Autowired
    private GroupeEmailConverter groupeEmailConverter ;
    private boolean typecontenu;
    private boolean groupeEmail;

    public  EmailGroupePieceJointConverter() {
        super(EmailGroupePieceJoint.class, EmailGroupePieceJointDto.class);
        init(true);
    }

    @Override
    public EmailGroupePieceJoint toItem(EmailGroupePieceJointDto dto) {
        if (dto == null) {
            return null;
        } else {
        EmailGroupePieceJoint item = new EmailGroupePieceJoint();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getPath()))
                item.setPath(dto.getPath());
            if(StringUtil.isNotEmpty(dto.getTaille()))
                item.setTaille(dto.getTaille());
            if(this.typecontenu && dto.getTypecontenu()!=null)
                item.setTypecontenu(typeContenuConverter.toItem(dto.getTypecontenu())) ;

            if(dto.getGroupeEmail() != null && dto.getGroupeEmail().getId() != null){
                item.setGroupeEmail(new GroupeEmail());
                item.getGroupeEmail().setId(dto.getGroupeEmail().getId());
                item.getGroupeEmail().setId(dto.getGroupeEmail().getId());
            }




        return item;
        }
    }

    @Override
    public EmailGroupePieceJointDto toDto(EmailGroupePieceJoint item) {
        if (item == null) {
            return null;
        } else {
            EmailGroupePieceJointDto dto = new EmailGroupePieceJointDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getPath()))
                dto.setPath(item.getPath());
            if(StringUtil.isNotEmpty(item.getTaille()))
                dto.setTaille(item.getTaille());
            if(this.typecontenu && item.getTypecontenu()!=null) {
                dto.setTypecontenu(typeContenuConverter.toDto(item.getTypecontenu())) ;

            }
            if(this.groupeEmail && item.getGroupeEmail()!=null) {
                dto.setGroupeEmail(groupeEmailConverter.toDto(item.getGroupeEmail())) ;

            }


        return dto;
        }
    }

    public void copy(EmailGroupePieceJointDto dto, EmailGroupePieceJoint t) {
    super.copy(dto, t);
    if (dto.getTypecontenu() != null)
        typeContenuConverter.copy(dto.getTypecontenu(), t.getTypecontenu());
    if (dto.getGroupeEmail() != null)
        groupeEmailConverter.copy(dto.getGroupeEmail(), t.getGroupeEmail());
    }



    public void initObject(boolean value) {
        this.typecontenu = value;
        this.groupeEmail = value;
    }


    public TypeContenuConverter getTypeContenuConverter(){
        return this.typeContenuConverter;
    }
    public void setTypeContenuConverter(TypeContenuConverter typeContenuConverter ){
        this.typeContenuConverter = typeContenuConverter;
    }
    public GroupeEmailConverter getGroupeEmailConverter(){
        return this.groupeEmailConverter;
    }
    public void setGroupeEmailConverter(GroupeEmailConverter groupeEmailConverter ){
        this.groupeEmailConverter = groupeEmailConverter;
    }
    public boolean  isTypecontenu(){
        return this.typecontenu;
    }
    public void  setTypecontenu(boolean typecontenu){
        this.typecontenu = typecontenu;
    }
    public boolean  isGroupeEmail(){
        return this.groupeEmail;
    }
    public void  setGroupeEmail(boolean groupeEmail){
        this.groupeEmail = groupeEmail;
    }
}
