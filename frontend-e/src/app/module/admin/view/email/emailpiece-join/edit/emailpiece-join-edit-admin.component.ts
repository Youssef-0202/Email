import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {EmailpieceJoinAdminService} from 'src/app/shared/service/admin/email/EmailpieceJoinAdmin.service';
import {EmailpieceJoinDto} from 'src/app/shared/model/email/EmailpieceJoin.model';
import {EmailpieceJoinCriteria} from 'src/app/shared/criteria/email/EmailpieceJoinCriteria.model';


import {EmailDto} from 'src/app/shared/model/email/Email.model';
import {EmailAdminService} from 'src/app/shared/service/admin/email/EmailAdmin.service';
import {TypeContenuDto} from 'src/app/shared/model/commun/TypeContenu.model';
import {TypeContenuAdminService} from 'src/app/shared/service/admin/commun/TypeContenuAdmin.service';

@Component({
  selector: 'app-emailpiece-join-edit-admin',
  templateUrl: './emailpiece-join-edit-admin.component.html'
})
export class EmailpieceJoinEditAdminComponent extends AbstractEditController<EmailpieceJoinDto, EmailpieceJoinCriteria, EmailpieceJoinAdminService>   implements OnInit {



    private _validEmailRef = true;
    private _validTypeContenuLibelle = true;
    private _validTypeContenuCode = true;



    constructor( private emailpieceJoinService: EmailpieceJoinAdminService , private emailService: EmailAdminService, private typeContenuService: TypeContenuAdminService) {
        super(emailpieceJoinService);
    }

    ngOnInit(): void {
        this.email = new EmailDto();
        this.emailService.findAll().subscribe((data) => this.emails = data);
        this.typeContenu = new TypeContenuDto();
        this.typeContenuService.findAll().subscribe((data) => this.typeContenus = data);
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



    get validEmailRef(): boolean {
        return this._validEmailRef;
    }
    set validEmailRef(value: boolean) {
        this._validEmailRef = value;
    }
    get validTypeContenuLibelle(): boolean {
        return this._validTypeContenuLibelle;
    }
    set validTypeContenuLibelle(value: boolean) {
        this._validTypeContenuLibelle = value;
    }
    get validTypeContenuCode(): boolean {
        return this._validTypeContenuCode;
    }
    set validTypeContenuCode(value: boolean) {
        this._validTypeContenuCode = value;
    }
}
