package  ma.zs.emailling.ws.converter.emailgroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.emailling.ws.converter.commun.UtilisateurConverter;
import ma.zs.emailling.ws.converter.emailgroup.GroupeEmailConverter;

import ma.zs.emailling.bean.core.emailgroup.GroupeEmail;


import ma.zs.emailling.zynerator.util.StringUtil;
import ma.zs.emailling.zynerator.converter.AbstractConverter;
import ma.zs.emailling.zynerator.util.DateUtil;
import ma.zs.emailling.bean.core.emailgroup.GroupeEmailDetail;
import ma.zs.emailling.ws.dto.emailgroup.GroupeEmailDetailDto;

@Component
public class GroupeEmailDetailConverter extends AbstractConverter<GroupeEmailDetail, GroupeEmailDetailDto> {

    @Autowired
    private UtilisateurConverter utilisateurConverter ;
    @Autowired
    private GroupeEmailConverter groupeEmailConverter ;
    private boolean personne;
    private boolean groupeEmail;

    public  GroupeEmailDetailConverter() {
        super(GroupeEmailDetail.class, GroupeEmailDetailDto.class);
        init(true);
    }

    @Override
    public GroupeEmailDetail toItem(GroupeEmailDetailDto dto) {
        if (dto == null) {
            return null;
        } else {
        GroupeEmailDetail item = new GroupeEmailDetail();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getDateAjoute()))
                item.setDateAjoute(DateUtil.stringEnToDate(dto.getDateAjoute()));
            if(StringUtil.isNotEmpty(dto.getDateBlockage()))
                item.setDateBlockage(DateUtil.stringEnToDate(dto.getDateBlockage()));
            if(this.personne && dto.getPersonne()!=null)
                item.setPersonne(utilisateurConverter.toItem(dto.getPersonne())) ;

            if(dto.getGroupeEmail() != null && dto.getGroupeEmail().getId() != null){
                item.setGroupeEmail(new GroupeEmail());
                item.getGroupeEmail().setId(dto.getGroupeEmail().getId());
                item.getGroupeEmail().setId(dto.getGroupeEmail().getId());
            }




        return item;
        }
    }

    @Override
    public GroupeEmailDetailDto toDto(GroupeEmailDetail item) {
        if (item == null) {
            return null;
        } else {
            GroupeEmailDetailDto dto = new GroupeEmailDetailDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(item.getDateAjoute()!=null)
                dto.setDateAjoute(DateUtil.dateTimeToString(item.getDateAjoute()));
            if(item.getDateBlockage()!=null)
                dto.setDateBlockage(DateUtil.dateTimeToString(item.getDateBlockage()));
            if(this.personne && item.getPersonne()!=null) {
                dto.setPersonne(utilisateurConverter.toDto(item.getPersonne())) ;

            }
            if(this.groupeEmail && item.getGroupeEmail()!=null) {
                dto.setGroupeEmail(groupeEmailConverter.toDto(item.getGroupeEmail())) ;

            }


        return dto;
        }
    }

    public void copy(GroupeEmailDetailDto dto, GroupeEmailDetail t) {
    super.copy(dto, t);
    if (dto.getPersonne() != null)
        utilisateurConverter.copy(dto.getPersonne(), t.getPersonne());
    if (dto.getGroupeEmail() != null)
        groupeEmailConverter.copy(dto.getGroupeEmail(), t.getGroupeEmail());
    }



    public void initObject(boolean value) {
        this.personne = value;
        this.groupeEmail = value;
    }


    public UtilisateurConverter getUtilisateurConverter(){
        return this.utilisateurConverter;
    }
    public void setUtilisateurConverter(UtilisateurConverter utilisateurConverter ){
        this.utilisateurConverter = utilisateurConverter;
    }
    public GroupeEmailConverter getGroupeEmailConverter(){
        return this.groupeEmailConverter;
    }
    public void setGroupeEmailConverter(GroupeEmailConverter groupeEmailConverter ){
        this.groupeEmailConverter = groupeEmailConverter;
    }
    public boolean  isPersonne(){
        return this.personne;
    }
    public void  setPersonne(boolean personne){
        this.personne = personne;
    }
    public boolean  isGroupeEmail(){
        return this.groupeEmail;
    }
    public void  setGroupeEmail(boolean groupeEmail){
        this.groupeEmail = groupeEmail;
    }
}
