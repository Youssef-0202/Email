package  ma.zs.emailling.ws.converter.emailgroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.emailling.zynerator.util.ListUtil;

import ma.zs.emailling.ws.converter.emailgroup.GroupeEmailDetailConverter;
import ma.zs.emailling.ws.converter.commun.UtilisateurConverter;



import ma.zs.emailling.zynerator.util.StringUtil;
import ma.zs.emailling.zynerator.converter.AbstractConverter;
import ma.zs.emailling.zynerator.util.DateUtil;
import ma.zs.emailling.bean.core.emailgroup.GroupeEmail;
import ma.zs.emailling.ws.dto.emailgroup.GroupeEmailDto;

@Component
public class GroupeEmailConverter extends AbstractConverter<GroupeEmail, GroupeEmailDto> {

    @Autowired
    private GroupeEmailDetailConverter groupeEmailDetailConverter ;
    @Autowired
    private UtilisateurConverter utilisateurConverter ;
    private boolean adminGroupe;
    private boolean groupeEmailDetails;

    public  GroupeEmailConverter() {
        super(GroupeEmail.class, GroupeEmailDto.class);
        init(true);
    }

    @Override
    public GroupeEmail toItem(GroupeEmailDto dto) {
        if (dto == null) {
            return null;
        } else {
        GroupeEmail item = new GroupeEmail();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(this.adminGroupe && dto.getAdminGroupe()!=null)
                item.setAdminGroupe(utilisateurConverter.toItem(dto.getAdminGroupe())) ;


            if(this.groupeEmailDetails && ListUtil.isNotEmpty(dto.getGroupeEmailDetails()))
                item.setGroupeEmailDetails(groupeEmailDetailConverter.toItem(dto.getGroupeEmailDetails()));


        return item;
        }
    }

    @Override
    public GroupeEmailDto toDto(GroupeEmail item) {
        if (item == null) {
            return null;
        } else {
            GroupeEmailDto dto = new GroupeEmailDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(this.adminGroupe && item.getAdminGroupe()!=null) {
                dto.setAdminGroupe(utilisateurConverter.toDto(item.getAdminGroupe())) ;

            }
        if(this.groupeEmailDetails && ListUtil.isNotEmpty(item.getGroupeEmailDetails())){
            groupeEmailDetailConverter.init(true);
            groupeEmailDetailConverter.setGroupeEmail(false);
            dto.setGroupeEmailDetails(groupeEmailDetailConverter.toDto(item.getGroupeEmailDetails()));
            groupeEmailDetailConverter.setGroupeEmail(true);

        }


        return dto;
        }
    }

    public void copy(GroupeEmailDto dto, GroupeEmail t) {
    super.copy(dto, t);
    if (dto.getAdminGroupe() != null)
        utilisateurConverter.copy(dto.getAdminGroupe(), t.getAdminGroupe());
    if (dto.getGroupeEmailDetails() != null)
        t.setGroupeEmailDetails(groupeEmailDetailConverter.copy(dto.getGroupeEmailDetails()));
    }


    public void initList(boolean value) {
        this.groupeEmailDetails = value;
    }

    public void initObject(boolean value) {
        this.adminGroupe = value;
    }


    public GroupeEmailDetailConverter getGroupeEmailDetailConverter(){
        return this.groupeEmailDetailConverter;
    }
    public void setGroupeEmailDetailConverter(GroupeEmailDetailConverter groupeEmailDetailConverter ){
        this.groupeEmailDetailConverter = groupeEmailDetailConverter;
    }
    public UtilisateurConverter getUtilisateurConverter(){
        return this.utilisateurConverter;
    }
    public void setUtilisateurConverter(UtilisateurConverter utilisateurConverter ){
        this.utilisateurConverter = utilisateurConverter;
    }
    public boolean  isAdminGroupe(){
        return this.adminGroupe;
    }
    public void  setAdminGroupe(boolean adminGroupe){
        this.adminGroupe = adminGroupe;
    }
    public boolean  isGroupeEmailDetails(){
        return this.groupeEmailDetails ;
    }
    public void  setGroupeEmailDetails(boolean groupeEmailDetails ){
        this.groupeEmailDetails  = groupeEmailDetails ;
    }
}
