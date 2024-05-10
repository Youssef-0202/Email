import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {EmailGroupePieceJointAdminService} from 'src/app/shared/service/admin/emailgroup/EmailGroupePieceJointAdmin.service';
import {EmailGroupePieceJointDto} from 'src/app/shared/model/emailgroup/EmailGroupePieceJoint.model';
import {EmailGroupePieceJointCriteria} from 'src/app/shared/criteria/emailgroup/EmailGroupePieceJointCriteria.model';


import {TypeContenuDto} from 'src/app/shared/model/commun/TypeContenu.model';
import {TypeContenuAdminService} from 'src/app/shared/service/admin/commun/TypeContenuAdmin.service';
import {GroupeEmailDto} from 'src/app/shared/model/emailgroup/GroupeEmail.model';
import {GroupeEmailAdminService} from 'src/app/shared/service/admin/emailgroup/GroupeEmailAdmin.service';

@Component({
  selector: 'app-email-groupe-piece-joint-edit-admin',
  templateUrl: './email-groupe-piece-joint-edit-admin.component.html'
})
export class EmailGroupePieceJointEditAdminComponent extends AbstractEditController<EmailGroupePieceJointDto, EmailGroupePieceJointCriteria, EmailGroupePieceJointAdminService>   implements OnInit {



    private _validTypecontenuLibelle = true;
    private _validTypecontenuCode = true;



    constructor( private emailGroupePieceJointService: EmailGroupePieceJointAdminService , private typeContenuService: TypeContenuAdminService, private groupeEmailService: GroupeEmailAdminService) {
        super(emailGroupePieceJointService);
    }

    ngOnInit(): void {
        this.typecontenu = new TypeContenuDto();
        this.typeContenuService.findAll().subscribe((data) => this.typecontenus = data);
        this.groupeEmail = new GroupeEmailDto();
        this.groupeEmailService.findAll().subscribe((data) => this.groupeEmails = data);
    }


    public override setValidation(value: boolean){
        }
    public override validateForm(): void{
        this.errorMessages = new Array<string>();
    }



   public async openCreateGroupeEmail(groupeEmail: string) {
        const isPermistted = await this.roleService.isPermitted('GroupeEmail', 'edit');
        if (isPermistted) {
             this.groupeEmail = new GroupeEmailDto();
             this.createGroupeEmailDialog = true;
        }else {
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }

   get typecontenu(): TypeContenuDto {
       return this.typeContenuService.item;
   }
  set typecontenu(value: TypeContenuDto) {
        this.typeContenuService.item = value;
   }
   get typecontenus(): Array<TypeContenuDto> {
        return this.typeContenuService.items;
   }
   set typecontenus(value: Array<TypeContenuDto>) {
        this.typeContenuService.items = value;
   }
   get createTypecontenuDialog(): boolean {
       return this.typeContenuService.createDialog;
   }
  set createTypecontenuDialog(value: boolean) {
       this.typeContenuService.createDialog= value;
   }
   get groupeEmail(): GroupeEmailDto {
       return this.groupeEmailService.item;
   }
  set groupeEmail(value: GroupeEmailDto) {
        this.groupeEmailService.item = value;
   }
   get groupeEmails(): Array<GroupeEmailDto> {
        return this.groupeEmailService.items;
   }
   set groupeEmails(value: Array<GroupeEmailDto>) {
        this.groupeEmailService.items = value;
   }
   get createGroupeEmailDialog(): boolean {
       return this.groupeEmailService.createDialog;
   }
  set createGroupeEmailDialog(value: boolean) {
       this.groupeEmailService.createDialog= value;
   }



    get validTypecontenuLibelle(): boolean {
        return this._validTypecontenuLibelle;
    }
    set validTypecontenuLibelle(value: boolean) {
        this._validTypecontenuLibelle = value;
    }
    get validTypecontenuCode(): boolean {
        return this._validTypecontenuCode;
    }
    set validTypecontenuCode(value: boolean) {
        this._validTypecontenuCode = value;
    }
}
