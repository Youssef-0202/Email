import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

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
  selector: 'app-email-create-admin',
  templateUrl: './email-create-admin.component.html'
})
export class EmailCreateAdminComponent extends AbstractCreateController<EmailDto, EmailCriteria, EmailAdminService>  implements OnInit {

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



    validateEmailDetails(){
        this.errorMessages = new Array();
    }
    validateEmailpieceJoints(){
        this.errorMessages = new Array();
    }
    validateEmailDetailGroups(){
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
              this.item.emailDetails.push({... this.emailDetailsElement});
              this.emailDetailsElement = new EmailDetailDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs',detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
       }
    }


    public deleteemailDetails(p: EmailDetailDto) {
        this.item.emailDetails.forEach((element, index) => {
            if (element === p) { this.item.emailDetails.splice(index, 1); }
        });
    }

    public editemailDetails(p: EmailDetailDto) {
        this.emailDetailsElement = {... p};
        this.activeTab = 0;
    }
    public addEmailpieceJoints() {
        if( this.item.emailpieceJoints == null )
            this.item.emailpieceJoints = new Array<EmailpieceJoinDto>();
       this.validateEmailpieceJoints();
       if (this.errorMessages.length === 0) {
              this.item.emailpieceJoints.push({... this.emailpieceJointsElement});
              this.emailpieceJointsElement = new EmailpieceJoinDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs',detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
       }
    }


    public deleteemailpieceJoints(p: EmailpieceJoinDto) {
        this.item.emailpieceJoints.forEach((element, index) => {
            if (element === p) { this.item.emailpieceJoints.splice(index, 1); }
        });
    }

    public editemailpieceJoints(p: EmailpieceJoinDto) {
        this.emailpieceJointsElement = {... p};
        this.activeTab = 0;
    }
    public addEmailDetailGroups() {
        if( this.item.emailDetailGroups == null )
            this.item.emailDetailGroups = new Array<EmailDetailGroupDto>();
       this.validateEmailDetailGroups();
       if (this.errorMessages.length === 0) {
              this.item.emailDetailGroups.push({... this.emailDetailGroupsElement});
              this.emailDetailGroupsElement = new EmailDetailGroupDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs',detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
       }
    }


    public deleteemailDetailGroups(p: EmailDetailGroupDto) {
        this.item.emailDetailGroups.forEach((element, index) => {
            if (element === p) { this.item.emailDetailGroups.splice(index, 1); }
        });
    }

    public editemailDetailGroups(p: EmailDetailGroupDto) {
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


    public onFileChange(event: any): void {
        const file = event.target.files[0];
        if (file) {
            this._emailpieceJointsElement.path = file.name; // Stocker le chemin du fichier
            const fileSizeInBytes = file.size;
            this._emailpieceJointsElement.taille = this.formatBytes(fileSizeInBytes);
        }
    }

    private formatBytes(bytes: number, decimals = 2): string {
        if (bytes === 0) return '0 Mo';

        const k = 1024;
        const dm = decimals < 0 ? 0 : decimals;
        const sizes = ['Octets', 'Ko', 'Mo', 'Go', 'To'];

        const i = Math.floor(Math.log(bytes) / Math.log(k));

        return parseFloat((bytes / Math.pow(k, i)).toFixed(dm)) + ' ' + sizes[i];
    }

}
