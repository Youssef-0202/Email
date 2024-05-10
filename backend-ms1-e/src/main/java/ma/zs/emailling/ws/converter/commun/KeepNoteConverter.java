package  ma.zs.emailling.ws.converter.commun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.emailling.ws.converter.commun.UtilisateurConverter;



import ma.zs.emailling.zynerator.util.StringUtil;
import ma.zs.emailling.zynerator.converter.AbstractConverter;
import ma.zs.emailling.zynerator.util.DateUtil;
import ma.zs.emailling.bean.core.commun.KeepNote;
import ma.zs.emailling.ws.dto.commun.KeepNoteDto;

@Component
public class KeepNoteConverter extends AbstractConverter<KeepNote, KeepNoteDto> {

    @Autowired
    private UtilisateurConverter utilisateurConverter ;
    private boolean personne;

    public  KeepNoteConverter() {
        super(KeepNote.class, KeepNoteDto.class);
        init(true);
    }

    @Override
    public KeepNote toItem(KeepNoteDto dto) {
        if (dto == null) {
            return null;
        } else {
        KeepNote item = new KeepNote();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getBody()))
                item.setBody(dto.getBody());
            if(StringUtil.isNotEmpty(dto.getHeader()))
                item.setHeader(dto.getHeader());
            if(StringUtil.isNotEmpty(dto.getDateKeepNote()))
                item.setDateKeepNote(DateUtil.stringEnToDate(dto.getDateKeepNote()));
            if(this.personne && dto.getPersonne()!=null)
                item.setPersonne(utilisateurConverter.toItem(dto.getPersonne())) ;




        return item;
        }
    }

    @Override
    public KeepNoteDto toDto(KeepNote item) {
        if (item == null) {
            return null;
        } else {
            KeepNoteDto dto = new KeepNoteDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getBody()))
                dto.setBody(item.getBody());
            if(StringUtil.isNotEmpty(item.getHeader()))
                dto.setHeader(item.getHeader());
            if(item.getDateKeepNote()!=null)
                dto.setDateKeepNote(DateUtil.dateTimeToString(item.getDateKeepNote()));
            if(this.personne && item.getPersonne()!=null) {
                dto.setPersonne(utilisateurConverter.toDto(item.getPersonne())) ;

            }


        return dto;
        }
    }

    public void copy(KeepNoteDto dto, KeepNote t) {
    super.copy(dto, t);
    if (dto.getPersonne() != null)
        utilisateurConverter.copy(dto.getPersonne(), t.getPersonne());
    }



    public void initObject(boolean value) {
        this.personne = value;
    }


    public UtilisateurConverter getUtilisateurConverter(){
        return this.utilisateurConverter;
    }
    public void setUtilisateurConverter(UtilisateurConverter utilisateurConverter ){
        this.utilisateurConverter = utilisateurConverter;
    }
    public boolean  isPersonne(){
        return this.personne;
    }
    public void  setPersonne(boolean personne){
        this.personne = personne;
    }
}
