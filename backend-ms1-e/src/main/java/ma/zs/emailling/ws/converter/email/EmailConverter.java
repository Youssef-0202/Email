package  ma.zs.emailling.ws.converter.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.emailling.zynerator.util.ListUtil;

import ma.zs.emailling.ws.converter.commun.EtatEmailConverter;
import ma.zs.emailling.ws.converter.email.EmailpieceJoinConverter;
import ma.zs.emailling.ws.converter.commun.TypeContenuConverter;
import ma.zs.emailling.ws.converter.emailgroup.EmailDetailGroupConverter;
import ma.zs.emailling.ws.converter.commun.UtilisateurConverter;
import ma.zs.emailling.ws.converter.commun.CategoryEmailConverter;
import ma.zs.emailling.ws.converter.email.EmailDetailConverter;
import ma.zs.emailling.ws.converter.emailgroup.GroupeEmailConverter;



import ma.zs.emailling.zynerator.util.StringUtil;
import ma.zs.emailling.zynerator.converter.AbstractConverter;
import ma.zs.emailling.zynerator.util.DateUtil;
import ma.zs.emailling.bean.core.email.Email;
import ma.zs.emailling.ws.dto.email.EmailDto;

@Component
public class EmailConverter extends AbstractConverter<Email, EmailDto> {

    @Autowired
    private EtatEmailConverter etatEmailConverter ;
    @Autowired
    private EmailpieceJoinConverter emailpieceJoinConverter ;
    @Autowired
    private TypeContenuConverter typeContenuConverter ;
    @Autowired
    private EmailDetailGroupConverter emailDetailGroupConverter ;
    @Autowired
    private UtilisateurConverter utilisateurConverter ;
    @Autowired
    private CategoryEmailConverter categoryEmailConverter ;
    @Autowired
    private EmailDetailConverter emailDetailConverter ;
    @Autowired
    private GroupeEmailConverter groupeEmailConverter ;
    private boolean personneSource;
    private boolean categoryEmail;
    private boolean etatEmail;
    private boolean emailDetails;
    private boolean emailpieceJoints;
    private boolean emailDetailGroups;

    public  EmailConverter() {
        super(Email.class, EmailDto.class);
        init(true);
    }

    @Override
    public Email toItem(EmailDto dto) {
        if (dto == null) {
            return null;
        } else {
        Email item = new Email();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getRef()))
                item.setRef(dto.getRef());
            if(StringUtil.isNotEmpty(dto.getDateEnvoi()))
                item.setDateEnvoi(DateUtil.stringEnToDate(dto.getDateEnvoi()));
            if(StringUtil.isNotEmpty(dto.getCorps()))
                item.setCorps(dto.getCorps());
            if(StringUtil.isNotEmpty(dto.getHeader()))
                item.setHeader(dto.getHeader());
            if(this.personneSource && dto.getPersonneSource()!=null)
                item.setPersonneSource(utilisateurConverter.toItem(dto.getPersonneSource())) ;

            if(this.categoryEmail && dto.getCategoryEmail()!=null)
                item.setCategoryEmail(categoryEmailConverter.toItem(dto.getCategoryEmail())) ;

            if(this.etatEmail && dto.getEtatEmail()!=null)
                item.setEtatEmail(etatEmailConverter.toItem(dto.getEtatEmail())) ;


            if(this.emailDetails && ListUtil.isNotEmpty(dto.getEmailDetails()))
                item.setEmailDetails(emailDetailConverter.toItem(dto.getEmailDetails()));
            if(this.emailpieceJoints && ListUtil.isNotEmpty(dto.getEmailpieceJoints()))
                item.setEmailpieceJoints(emailpieceJoinConverter.toItem(dto.getEmailpieceJoints()));
            if(this.emailDetailGroups && ListUtil.isNotEmpty(dto.getEmailDetailGroups()))
                item.setEmailDetailGroups(emailDetailGroupConverter.toItem(dto.getEmailDetailGroups()));


        return item;
        }
    }

    @Override
    public EmailDto toDto(Email item) {
        if (item == null) {
            return null;
        } else {
            EmailDto dto = new EmailDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getRef()))
                dto.setRef(item.getRef());
            if(item.getDateEnvoi()!=null)
                dto.setDateEnvoi(DateUtil.dateTimeToString(item.getDateEnvoi()));
            if(StringUtil.isNotEmpty(item.getCorps()))
                dto.setCorps(item.getCorps());
            if(StringUtil.isNotEmpty(item.getHeader()))
                dto.setHeader(item.getHeader());
            if(this.personneSource && item.getPersonneSource()!=null) {
                dto.setPersonneSource(utilisateurConverter.toDto(item.getPersonneSource())) ;

            }
            if(this.categoryEmail && item.getCategoryEmail()!=null) {
                dto.setCategoryEmail(categoryEmailConverter.toDto(item.getCategoryEmail())) ;

            }
            if(this.etatEmail && item.getEtatEmail()!=null) {
                dto.setEtatEmail(etatEmailConverter.toDto(item.getEtatEmail())) ;

            }
        if(this.emailDetails && ListUtil.isNotEmpty(item.getEmailDetails())){
            emailDetailConverter.init(true);
            emailDetailConverter.setEmail(false);
            dto.setEmailDetails(emailDetailConverter.toDto(item.getEmailDetails()));
            emailDetailConverter.setEmail(true);

        }
        if(this.emailpieceJoints && ListUtil.isNotEmpty(item.getEmailpieceJoints())){
            emailpieceJoinConverter.init(true);
            emailpieceJoinConverter.setEmail(false);
            dto.setEmailpieceJoints(emailpieceJoinConverter.toDto(item.getEmailpieceJoints()));
            emailpieceJoinConverter.setEmail(true);

        }
        if(this.emailDetailGroups && ListUtil.isNotEmpty(item.getEmailDetailGroups())){
            emailDetailGroupConverter.init(true);
            emailDetailGroupConverter.setEmail(false);
            dto.setEmailDetailGroups(emailDetailGroupConverter.toDto(item.getEmailDetailGroups()));
            emailDetailGroupConverter.setEmail(true);

        }


        return dto;
        }
    }

    public void copy(EmailDto dto, Email t) {
    super.copy(dto, t);
    if (dto.getPersonneSource() != null)
        utilisateurConverter.copy(dto.getPersonneSource(), t.getPersonneSource());
    if (dto.getCategoryEmail() != null)
        categoryEmailConverter.copy(dto.getCategoryEmail(), t.getCategoryEmail());
    if (dto.getEtatEmail() != null)
        etatEmailConverter.copy(dto.getEtatEmail(), t.getEtatEmail());
    if (dto.getEmailDetails() != null)
        t.setEmailDetails(emailDetailConverter.copy(dto.getEmailDetails()));
    if (dto.getEmailpieceJoints() != null)
        t.setEmailpieceJoints(emailpieceJoinConverter.copy(dto.getEmailpieceJoints()));
    if (dto.getEmailDetailGroups() != null)
        t.setEmailDetailGroups(emailDetailGroupConverter.copy(dto.getEmailDetailGroups()));
    }


    public void initList(boolean value) {
        this.emailDetails = value;
        this.emailpieceJoints = value;
        this.emailDetailGroups = value;
    }

    public void initObject(boolean value) {
        this.personneSource = value;
        this.categoryEmail = value;
        this.etatEmail = value;
    }


    public EtatEmailConverter getEtatEmailConverter(){
        return this.etatEmailConverter;
    }
    public void setEtatEmailConverter(EtatEmailConverter etatEmailConverter ){
        this.etatEmailConverter = etatEmailConverter;
    }
    public EmailpieceJoinConverter getEmailpieceJoinConverter(){
        return this.emailpieceJoinConverter;
    }
    public void setEmailpieceJoinConverter(EmailpieceJoinConverter emailpieceJoinConverter ){
        this.emailpieceJoinConverter = emailpieceJoinConverter;
    }
    public TypeContenuConverter getTypeContenuConverter(){
        return this.typeContenuConverter;
    }
    public void setTypeContenuConverter(TypeContenuConverter typeContenuConverter ){
        this.typeContenuConverter = typeContenuConverter;
    }
    public EmailDetailGroupConverter getEmailDetailGroupConverter(){
        return this.emailDetailGroupConverter;
    }
    public void setEmailDetailGroupConverter(EmailDetailGroupConverter emailDetailGroupConverter ){
        this.emailDetailGroupConverter = emailDetailGroupConverter;
    }
    public UtilisateurConverter getUtilisateurConverter(){
        return this.utilisateurConverter;
    }
    public void setUtilisateurConverter(UtilisateurConverter utilisateurConverter ){
        this.utilisateurConverter = utilisateurConverter;
    }
    public CategoryEmailConverter getCategoryEmailConverter(){
        return this.categoryEmailConverter;
    }
    public void setCategoryEmailConverter(CategoryEmailConverter categoryEmailConverter ){
        this.categoryEmailConverter = categoryEmailConverter;
    }
    public EmailDetailConverter getEmailDetailConverter(){
        return this.emailDetailConverter;
    }
    public void setEmailDetailConverter(EmailDetailConverter emailDetailConverter ){
        this.emailDetailConverter = emailDetailConverter;
    }
    public GroupeEmailConverter getGroupeEmailConverter(){
        return this.groupeEmailConverter;
    }
    public void setGroupeEmailConverter(GroupeEmailConverter groupeEmailConverter ){
        this.groupeEmailConverter = groupeEmailConverter;
    }
    public boolean  isPersonneSource(){
        return this.personneSource;
    }
    public void  setPersonneSource(boolean personneSource){
        this.personneSource = personneSource;
    }
    public boolean  isCategoryEmail(){
        return this.categoryEmail;
    }
    public void  setCategoryEmail(boolean categoryEmail){
        this.categoryEmail = categoryEmail;
    }
    public boolean  isEtatEmail(){
        return this.etatEmail;
    }
    public void  setEtatEmail(boolean etatEmail){
        this.etatEmail = etatEmail;
    }
    public boolean  isEmailDetails(){
        return this.emailDetails ;
    }
    public void  setEmailDetails(boolean emailDetails ){
        this.emailDetails  = emailDetails ;
    }
    public boolean  isEmailpieceJoints(){
        return this.emailpieceJoints ;
    }
    public void  setEmailpieceJoints(boolean emailpieceJoints ){
        this.emailpieceJoints  = emailpieceJoints ;
    }
    public boolean  isEmailDetailGroups(){
        return this.emailDetailGroups ;
    }
    public void  setEmailDetailGroups(boolean emailDetailGroups ){
        this.emailDetailGroups  = emailDetailGroups ;
    }
}
