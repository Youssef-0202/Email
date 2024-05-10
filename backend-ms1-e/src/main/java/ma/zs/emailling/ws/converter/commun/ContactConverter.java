package  ma.zs.emailling.ws.converter.commun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.emailling.ws.converter.commun.UtilisateurConverter;



import ma.zs.emailling.zynerator.util.StringUtil;
import ma.zs.emailling.zynerator.converter.AbstractConverter;
import ma.zs.emailling.zynerator.util.DateUtil;
import ma.zs.emailling.bean.core.commun.Contact;
import ma.zs.emailling.ws.dto.commun.ContactDto;

@Component
public class ContactConverter extends AbstractConverter<Contact, ContactDto> {

    @Autowired
    private UtilisateurConverter utilisateurConverter ;
    private boolean personneSource;
    private boolean personneDestination;

    public  ContactConverter() {
        super(Contact.class, ContactDto.class);
        init(true);
    }

    @Override
    public Contact toItem(ContactDto dto) {
        if (dto == null) {
            return null;
        } else {
        Contact item = new Contact();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getName()))
                item.setName(dto.getName());
            if(StringUtil.isNotEmpty(dto.getDateAjout()))
                item.setDateAjout(DateUtil.stringEnToDate(dto.getDateAjout()));
            if(this.personneSource && dto.getPersonneSource()!=null)
                item.setPersonneSource(utilisateurConverter.toItem(dto.getPersonneSource())) ;

            if(this.personneDestination && dto.getPersonneDestination()!=null)
                item.setPersonneDestination(utilisateurConverter.toItem(dto.getPersonneDestination())) ;




        return item;
        }
    }

    @Override
    public ContactDto toDto(Contact item) {
        if (item == null) {
            return null;
        } else {
            ContactDto dto = new ContactDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getName()))
                dto.setName(item.getName());
            if(item.getDateAjout()!=null)
                dto.setDateAjout(DateUtil.dateTimeToString(item.getDateAjout()));
            if(this.personneSource && item.getPersonneSource()!=null) {
                dto.setPersonneSource(utilisateurConverter.toDto(item.getPersonneSource())) ;

            }
            if(this.personneDestination && item.getPersonneDestination()!=null) {
                dto.setPersonneDestination(utilisateurConverter.toDto(item.getPersonneDestination())) ;

            }


        return dto;
        }
    }

    public void copy(ContactDto dto, Contact t) {
    super.copy(dto, t);
    if (dto.getPersonneSource() != null)
        utilisateurConverter.copy(dto.getPersonneSource(), t.getPersonneSource());
    if (dto.getPersonneDestination() != null)
        utilisateurConverter.copy(dto.getPersonneDestination(), t.getPersonneDestination());
    }



    public void initObject(boolean value) {
        this.personneSource = value;
        this.personneDestination = value;
    }


    public UtilisateurConverter getUtilisateurConverter(){
        return this.utilisateurConverter;
    }
    public void setUtilisateurConverter(UtilisateurConverter utilisateurConverter ){
        this.utilisateurConverter = utilisateurConverter;
    }
    public boolean  isPersonneSource(){
        return this.personneSource;
    }
    public void  setPersonneSource(boolean personneSource){
        this.personneSource = personneSource;
    }
    public boolean  isPersonneDestination(){
        return this.personneDestination;
    }
    public void  setPersonneDestination(boolean personneDestination){
        this.personneDestination = personneDestination;
    }
}
