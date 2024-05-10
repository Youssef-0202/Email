import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {EmailAdminService} from 'src/app/shared/service/admin/email/EmailAdmin.service';
import {EmailDto} from 'src/app/shared/model/email/Email.model';
import {EmailCriteria} from 'src/app/shared/criteria/email/EmailCriteria.model';


import {EtatEmailDto} from 'src/app/shared/model/commun/EtatEmail.model';
import {EtatEmailAdminService} from 'src/app/shared/service/admin/commun/EtatEmailAdmin.service';
import {EmailpieceJoinDto} from 'src/app/shared/model/email/EmailpieceJoin.model';
import {EmailpieceJoinAdminService} from 'src/app/shared/service/admin/email/EmailpieceJoinAdmin.service';
import {TypeContenuDto} from 'src/app/shared/model/commun/TypeContenu.model';
import {TypeContenuAdminService} from 'src/app/shared/service/admin/commun/TypeContenuAdmin.service';
import {EmailDetailGroupDto} from 'src/app/shared/model/emailgroup/EmailDetailGroup.model';
import {EmailDetailGroupAdminService} from 'src/app/shared/service/admin/emailgroup/EmailDetailGroupAdmin.service';
import {UtilisateurDto} from 'src/app/shared/model/commun/Utilisateur.model';
import {UtilisateurAdminService} from 'src/app/shared/service/admin/commun/UtilisateurAdmin.service';
import {CategoryEmailDto} from 'src/app/shared/model/commun/CategoryEmail.model';
import {CategoryEmailAdminService} from 'src/app/shared/service/admin/commun/CategoryEmailAdmin.service';
import {EmailDetailDto} from 'src/app/shared/model/email/EmailDetail.model';
import {EmailDetailAdminService} from 'src/app/shared/service/admin/email/EmailDetailAdmin.service';
import {GroupeEmailDto} from 'src/app/shared/model/emailgroup/GroupeEmail.model';
import {GroupeEmailAdminService} from 'src/app/shared/service/admin/emailgroup/GroupeEmailAdmin.service';

@Component({
  selector: 'app-email-edit-admin',
  templateUrl: './email-edit-admin.component.html'
})
export class EmailEditAdminComponent extends AbstractEditController<EmailDto, EmailCriteria, EmailAdminService>   implements OnInit {

    private _emailDetailsElement = new EmailDetailDto();
    private _emailpieceJointsElement = new EmailpieceJoinDto();
    private _emailDetailGroupsElement = new EmailDetailGroupDto();

    private _validEmailRef = true;

    private _validPersonneSourceUsername = true;
    private _validPersonneSourceEmail = true;
    private _validCategoryEmailName = true;
    private _validCategoryEmailCode = true;
    private _validEtatEmailLibelle = true;
    private _validEtatEmailCode = true;



    constructor( private emailService: EmailAdminService , private etatEmailService: EtatEmailAdminService, private emailpieceJoinService: EmailpieceJoinAdminService, private typeContenuService: TypeContenuAdminService, private emailDetailGroupService: EmailDetailGroupAdminService, private utilisateurService: UtilisateurAdminService, private categoryEmailService: CategoryEmailAdminService, private emailDetailService: EmailDetailAdminService, private groupeEmailService: GroupeEmailAdminService) {
        super(emailService);
    }

    ngOnInit(): void {
        this.emailDetailsElement.personneDestinataire = new UtilisateurDto();
        this.utilisateurService.findAll().subscribe((data) => this.personneDestinataires = data);
        this.emailDetailsElement.etatEmail = new EtatEmailDto();
        this.etatEmailService.findAll().subscribe((data) => this.etatEmails = data);

        this.emailpieceJointsElement.typeContenu = new TypeContenuDto();
        this.typeContenuService.findAll().subscribe((data) => this.typeContenus = data);

        this.emailDetailGroupsElement.destination = new GroupeEmailDto();
        this.groupeEmailService.findAll().subscribe((data) => this.destinations = data);

        this.personneSource = new UtilisateurDto();
        this.utilisateurService.findAll().subscribe((data) => this.personneSources = data);
        this.categoryEmail = new CategoryEmailDto();
        this.categoryEmailService.findAll().subscribe((data) => this.categoryEmails = data);
        this.etatEmail = new EtatEmailDto();
        this.etatEmailService.findAll().subscribe((data) => this.etatEmails = data);
    }
    public override prepareEdit() {
        this.item.dateEnvoi = this.emailService.format(this.item.dateEnvoi);
    }



    public validateEmailDetails(){
        this.errorMessages = new Array();
    }
    public validateEmailpieceJoints(){
        this.errorMessages = new Array();
    }
    public validateEmailDetailGroups(){
        this.errorMessages = new Array();
    }
    public override setValidation(value: boolean){
        this.validEmailRef = value;
        }
   public addEmailDetails() {
        if( this.item.emailDetails == null )
            this.item.emailDetails = new Array<EmailDetailDto>();
       this.validateEmailDetails();
       if (this.errorMessages.length === 0) {
            if(this.emailDetailsElement.id == null){
                this.item.emailDetails.push(this.emailDetailsElement);
            }else{
                const index = this.item.emailDetails.findIndex(e => e.id == this.emailDetailsElement.id);
                this.item.emailDetails[index] = this.emailDetailsElement;
            }
          this.emailDetailsElement = new EmailDetailDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs', detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
        }
   }

    public deleteEmailDetails(p: EmailDetailDto) {
        this.item.emailDetails.forEach((element, index) => {
            if (element === p) { this.item.emailDetails.splice(index, 1); }
        });
    }

    public editEmailDetails(p: EmailDetailDto) {
        this.emailDetailsElement = {... p};
        this.activeTab = 0;
    }
   public addEmailpieceJoints() {
        if( this.item.emailpieceJoints == null )
            this.item.emailpieceJoints = new Array<EmailpieceJoinDto>();
       this.validateEmailpieceJoints();
       if (this.errorMessages.length === 0) {
            if(this.emailpieceJointsElement.id == null){
                this.item.emailpieceJoints.push(this.emailpieceJointsElement);
            }else{
                const index = this.item.emailpieceJoints.findIndex(e => e.id == this.emailpieceJointsElement.id);
                this.item.emailpieceJoints[index] = this.emailpieceJointsElement;
            }
          this.emailpieceJointsElement = new EmailpieceJoinDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs', detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
        }
   }

    public deleteEmailpieceJoints(p: EmailpieceJoinDto) {
        this.item.emailpieceJoints.forEach((element, index) => {
            if (element === p) { this.item.emailpieceJoints.splice(index, 1); }
        });
    }

    public editEmailpieceJoints(p: EmailpieceJoinDto) {
        this.emailpieceJointsElement = {... p};
        this.activeTab = 0;
    }
   public addEmailDetailGroups() {
        if( this.item.emailDetailGroups == null )
            this.item.emailDetailGroups = new Array<EmailDetailGroupDto>();
       this.validateEmailDetailGroups();
       if (this.errorMessages.length === 0) {
            if(this.emailDetailGroupsElement.id == null){
                this.item.emailDetailGroups.push(this.emailDetailGroupsElement);
            }else{
                const index = this.item.emailDetailGroups.findIndex(e => e.id == this.emailDetailGroupsElement.id);
                this.item.emailDetailGroups[index] = this.emailDetailGroupsElement;
            }
          this.emailDetailGroupsElement = new EmailDetailGroupDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs', detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
        }
   }

    public deleteEmailDetailGroups(p: EmailDetailGroupDto) {
        this.item.emailDetailGroups.forEach((element, index) => {
            if (element === p) { this.item.emailDetailGroups.splice(index, 1); }
        });
    }

    public editEmailDetailGroups(p: EmailDetailGroupDto) {
        this.emailDetailGroupsElement = {... p};
        this.activeTab = 0;
    }
    public override validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateEmailRef();
    }
    public validateEmailRef(){
        if (this.stringUtilService.isEmpty(this.item.ref)) {
            this.errorMessages.push('Ref non valide');
            this.validEmailRef = false;
        } else {
            this.validEmailRef = true;
        }
    }




   get categoryEmail(): CategoryEmailDto {
       return this.categoryEmailService.item;
   }
  set categoryEmail(value: CategoryEmailDto) {
        this.categoryEmailService.item = value;
   }
   get categoryEmails(): Array<CategoryEmailDto> {
        return this.categoryEmailService.items;
   }
   set categoryEmails(value: Array<CategoryEmailDto>) {
        this.categoryEmailService.items = value;
   }
   get createCategoryEmailDialog(): boolean {
       return this.categoryEmailService.createDialog;
   }
  set createCategoryEmailDialog(value: boolean) {
       this.categoryEmailService.createDialog= value;
   }
   get destination(): GroupeEmailDto {
       return this.groupeEmailService.item;
   }
  set destination(value: GroupeEmailDto) {
        this.groupeEmailService.item = value;
   }
   get destinations(): Array<GroupeEmailDto> {
        return this.groupeEmailService.items;
   }
   set destinations(value: Array<GroupeEmailDto>) {
        this.groupeEmailService.items = value;
   }
   get createDestinationDialog(): boolean {
       return this.groupeEmailService.createDialog;
   }
  set createDestinationDialog(value: boolean) {
       this.groupeEmailService.createDialog= value;
   }
   get etatEmail(): EtatEmailDto {
       return this.etatEmailService.item;
   }
  set etatEmail(value: EtatEmailDto) {
        this.etatEmailService.item = value;
   }
   get etatEmails(): Array<EtatEmailDto> {
        return this.etatEmailService.items;
   }
   set etatEmails(value: Array<EtatEmailDto>) {
        this.etatEmailService.items = value;
   }
   get createEtatEmailDialog(): boolean {
       return this.etatEmailService.createDialog;
   }
  set createEtatEmailDialog(value: boolean) {
       this.etatEmailService.createDialog= value;
   }
   get personneDestinataire(): UtilisateurDto {
       return this.utilisateurService.item;
   }
  set personneDestinataire(value: UtilisateurDto) {
        this.utilisateurService.item = value;
   }
   get personneDestinataires(): Array<UtilisateurDto> {
        return this.utilisateurService.items;
   }
   set personneDestinataires(value: Array<UtilisateurDto>) {
        this.utilisateurService.items = value;
   }
   get createPersonneDestinataireDialog(): boolean {
       return this.utilisateurService.createDialog;
   }
  set createPersonneDestinataireDialog(value: boolean) {
       this.utilisateurService.createDialog= value;
   }
   get typeContenu(): TypeContenuDto {
       return this.typeContenuService.item;
   }
  set typeContenu(value: TypeContenuDto) {
        this.typeContenuService.item = value;
   }
   get typeContenus(): Array<TypeContenuDto> {
        return this.typeContenuService.items;
   }
   set typeContenus(value: Array<TypeContenuDto>) {
        this.typeContenuService.items = value;
   }
   get createTypeContenuDialog(): boolean {
       return this.typeContenuService.createDialog;
   }
  set createTypeContenuDialog(value: boolean) {
       this.typeContenuService.createDialog= value;
   }
   get personneSource(): UtilisateurDto {
       return this.utilisateurService.item;
   }
  set personneSource(value: UtilisateurDto) {
        this.utilisateurService.item = value;
   }
   get personneSources(): Array<UtilisateurDto> {
        return this.utilisateurService.items;
   }
   set personneSources(value: Array<UtilisateurDto>) {
        this.utilisateurService.items = value;
   }
   get createPersonneSourceDialog(): boolean {
       return this.utilisateurService.createDialog;
   }
  set createPersonneSourceDialog(value: boolean) {
       this.utilisateurService.createDialog= value;
   }

    get emailDetailsElement(): EmailDetailDto {
        if( this._emailDetailsElement == null )
            this._emailDetailsElement = new EmailDetailDto();
         return this._emailDetailsElement;
    }

    set emailDetailsElement(value: EmailDetailDto) {
        this._emailDetailsElement = value;
    }
    get emailpieceJointsElement(): EmailpieceJoinDto {
        if( this._emailpieceJointsElement == null )
            this._emailpieceJointsElement = new EmailpieceJoinDto();
         return this._emailpieceJointsElement;
    }

    set emailpieceJointsElement(value: EmailpieceJoinDto) {
        this._emailpieceJointsElement = value;
    }
    get emailDetailGroupsElement(): EmailDetailGroupDto {
        if( this._emailDetailGroupsElement == null )
            this._emailDetailGroupsElement = new EmailDetailGroupDto();
         return this._emailDetailGroupsElement;
    }

    set emailDetailGroupsElement(value: EmailDetailGroupDto) {
        this._emailDetailGroupsElement = value;
    }

    get validEmailRef(): boolean {
        return this._validEmailRef;
    }
    set validEmailRef(value: boolean) {
        this._validEmailRef = value;
    }

    get validPersonneSourceUsername(): boolean {
        return this._validPersonneSourceUsername;
    }
    set validPersonneSourceUsername(value: boolean) {
        this._validPersonneSourceUsername = value;
    }
    get validPersonneSourceEmail(): boolean {
        return this._validPersonneSourceEmail;
    }
    set validPersonneSourceEmail(value: boolean) {
        this._validPersonneSourceEmail = value;
    }
    get validCategoryEmailName(): boolean {
        return this._validCategoryEmailName;
    }
    set validCategoryEmailName(value: boolean) {
        this._validCategoryEmailName = value;
    }
    get validCategoryEmailCode(): boolean {
        return this._validCategoryEmailCode;
    }
    set validCategoryEmailCode(value: boolean) {
        this._validCategoryEmailCode = value;
    }
    get validEtatEmailLibelle(): boolean {
        return this._validEtatEmailLibelle;
    }
    set validEtatEmailLibelle(value: boolean) {
        this._validEtatEmailLibelle = value;
    }
    get validEtatEmailCode(): boolean {
        return this._validEtatEmailCode;
    }
    set validEtatEmailCode(value: boolean) {
        this._validEtatEmailCode = value;
    }
}
