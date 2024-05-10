import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {EmailDetailAdminService} from 'src/app/shared/service/admin/email/EmailDetailAdmin.service';
import {EmailDetailDto} from 'src/app/shared/model/email/EmailDetail.model';
import {EmailDetailCriteria} from 'src/app/shared/criteria/email/EmailDetailCriteria.model';


import {EtatEmailDto} from 'src/app/shared/model/commun/EtatEmail.model';
import {EtatEmailAdminService} from 'src/app/shared/service/admin/commun/EtatEmailAdmin.service';
import {EmailDto} from 'src/app/shared/model/email/Email.model';
import {EmailAdminService} from 'src/app/shared/service/admin/email/EmailAdmin.service';
import {UtilisateurDto} from 'src/app/shared/model/commun/Utilisateur.model';
import {UtilisateurAdminService} from 'src/app/shared/service/admin/commun/UtilisateurAdmin.service';

@Component({
  selector: 'app-email-detail-edit-admin',
  templateUrl: './email-detail-edit-admin.component.html'
})
export class EmailDetailEditAdminComponent extends AbstractEditController<EmailDetailDto, EmailDetailCriteria, EmailDetailAdminService>   implements OnInit {



    private _validEmailRef = true;
    private _validPersonneDestinataireUsername = true;
    private _validPersonneDestinataireEmail = true;
    private _validEtatEmailLibelle = true;
    private _validEtatEmailCode = true;



    constructor( private emailDetailService: EmailDetailAdminService , private etatEmailService: EtatEmailAdminService, private emailService: EmailAdminService, private utilisateurService: UtilisateurAdminService) {
        super(emailDetailService);
    }

    ngOnInit(): void {
        this.email = new EmailDto();
        this.emailService.findAll().subscribe((data) => this.emails = data);
        this.personneDestinataire = new UtilisateurDto();
        this.utilisateurService.findAll().subscribe((data) => this.personneDestinataires = data);
        this.etatEmail = new EtatEmailDto();
        this.etatEmailService.findAll().subscribe((data) => this.etatEmails = data);
    }
    public override prepareEdit() {
        this.item.dateLecture = this.emailDetailService.format(this.item.dateLecture);
        this.item.dateReception = this.emailDetailService.format(this.item.dateReception);
    }



    public override setValidation(value: boolean){
        }
    public override validateForm(): void{
        this.errorMessages = new Array<string>();
    }



   public async openCreateEmail(email: string) {
        const isPermistted = await this.roleService.isPermitted('Email', 'edit');
        if (isPermistted) {
             this.email = new EmailDto();
             this.createEmailDialog = true;
        }else {
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
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
   get email(): EmailDto {
       return this.emailService.item;
   }
  set email(value: EmailDto) {
        this.emailService.item = value;
   }
   get emails(): Array<EmailDto> {
        return this.emailService.items;
   }
   set emails(value: Array<EmailDto>) {
        this.emailService.items = value;
   }
   get createEmailDialog(): boolean {
       return this.emailService.createDialog;
   }
  set createEmailDialog(value: boolean) {
       this.emailService.createDialog= value;
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



    get validEmailRef(): boolean {
        return this._validEmailRef;
    }
    set validEmailRef(value: boolean) {
        this._validEmailRef = value;
    }
    get validPersonneDestinataireUsername(): boolean {
        return this._validPersonneDestinataireUsername;
    }
    set validPersonneDestinataireUsername(value: boolean) {
        this._validPersonneDestinataireUsername = value;
    }
    get validPersonneDestinataireEmail(): boolean {
        return this._validPersonneDestinataireEmail;
    }
    set validPersonneDestinataireEmail(value: boolean) {
        this._validPersonneDestinataireEmail = value;
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
