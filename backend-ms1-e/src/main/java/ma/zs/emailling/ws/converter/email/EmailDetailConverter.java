package  ma.zs.emailling.ws.converter.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.emailling.ws.converter.commun.EtatEmailConverter;
import ma.zs.emailling.ws.converter.email.EmailConverter;
import ma.zs.emailling.ws.converter.commun.UtilisateurConverter;

import ma.zs.emailling.bean.core.email.Email;


import ma.zs.emailling.zynerator.util.StringUtil;
import ma.zs.emailling.zynerator.converter.AbstractConverter;
import ma.zs.emailling.zynerator.util.DateUtil;
import ma.zs.emailling.bean.core.email.EmailDetail;
import ma.zs.emailling.ws.dto.email.EmailDetailDto;

@Component
public class EmailDetailConverter extends AbstractConverter<EmailDetail, EmailDetailDto> {

    @Autowired
    private EtatEmailConverter etatEmailConverter ;
    @Autowired
    private EmailConverter emailConverter ;
    @Autowired
    private UtilisateurConverter utilisateurConverter ;
    private boolean email;
    private boolean personneDestinataire;
    private boolean etatEmail;

    public  EmailDetailConverter() {
        super(EmailDetail.class, EmailDetailDto.class);
        init(true);
    }

    @Override
    public EmailDetail toItem(EmailDetailDto dto) {
        if (dto == null) {
            return null;
        } else {
        EmailDetail item = new EmailDetail();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getDateLecture()))
                item.setDateLecture(DateUtil.stringEnToDate(dto.getDateLecture()));
            if(StringUtil.isNotEmpty(dto.getDateReception()))
                item.setDateReception(DateUtil.stringEnToDate(dto.getDateReception()));
            if(dto.getEmail() != null && dto.getEmail().getId() != null){
                item.setEmail(new Email());
                item.getEmail().setId(dto.getEmail().getId());
                item.getEmail().setRef(dto.getEmail().getRef());
            }

            if(this.personneDestinataire && dto.getPersonneDestinataire()!=null)
                item.setPersonneDestinataire(utilisateurConverter.toItem(dto.getPersonneDestinataire())) ;

            if(this.etatEmail && dto.getEtatEmail()!=null)
                item.setEtatEmail(etatEmailConverter.toItem(dto.getEtatEmail())) ;




        return item;
        }
    }

    @Override
    public EmailDetailDto toDto(EmailDetail item) {
        if (item == null) {
            return null;
        } else {
            EmailDetailDto dto = new EmailDetailDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(item.getDateLecture()!=null)
                dto.setDateLecture(DateUtil.dateTimeToString(item.getDateLecture()));
            if(item.getDateReception()!=null)
                dto.setDateReception(DateUtil.dateTimeToString(item.getDateReception()));
            if(this.email && item.getEmail()!=null) {
                dto.setEmail(emailConverter.toDto(item.getEmail())) ;

            }
            if(this.personneDestinataire && item.getPersonneDestinataire()!=null) {
                dto.setPersonneDestinataire(utilisateurConverter.toDto(item.getPersonneDestinataire())) ;

            }
            if(this.etatEmail && item.getEtatEmail()!=null) {
                dto.setEtatEmail(etatEmailConverter.toDto(item.getEtatEmail())) ;

            }


        return dto;
        }
    }

    public void copy(EmailDetailDto dto, EmailDetail t) {
    super.copy(dto, t);
    if (dto.getEmail() != null)
        emailConverter.copy(dto.getEmail(), t.getEmail());
    if (dto.getPersonneDestinataire() != null)
        utilisateurConverter.copy(dto.getPersonneDestinataire(), t.getPersonneDestinataire());
    if (dto.getEtatEmail() != null)
        etatEmailConverter.copy(dto.getEtatEmail(), t.getEtatEmail());
    }



    public void initObject(boolean value) {
        this.email = value;
        this.personneDestinataire = value;
        this.etatEmail = value;
    }


    public EtatEmailConverter getEtatEmailConverter(){
        return this.etatEmailConverter;
    }
    public void setEtatEmailConverter(EtatEmailConverter etatEmailConverter ){
        this.etatEmailConverter = etatEmailConverter;
    }
    public EmailConverter getEmailConverter(){
        return this.emailConverter;
    }
    public void setEmailConverter(EmailConverter emailConverter ){
        this.emailConverter = emailConverter;
    }
    public UtilisateurConverter getUtilisateurConverter(){
        return this.utilisateurConverter;
    }
    public void setUtilisateurConverter(UtilisateurConverter utilisateurConverter ){
        this.utilisateurConverter = utilisateurConverter;
    }
    public boolean  isEmail(){
        return this.email;
    }
    public void  setEmail(boolean email){
        this.email = email;
    }
    public boolean  isPersonneDestinataire(){
        return this.personneDestinataire;
    }
    public void  setPersonneDestinataire(boolean personneDestinataire){
        this.personneDestinataire = personneDestinataire;
    }
    public boolean  isEtatEmail(){
        return this.etatEmail;
    }
    public void  setEtatEmail(boolean etatEmail){
        this.etatEmail = etatEmail;
    }
}
