import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {EmailDetailGroupAdminService} from 'src/app/shared/service/admin/emailgroup/EmailDetailGroupAdmin.service';
import {EmailDetailGroupDto} from 'src/app/shared/model/emailgroup/EmailDetailGroup.model';
import {EmailDetailGroupCriteria} from 'src/app/shared/criteria/emailgroup/EmailDetailGroupCriteria.model';


import {EmailDto} from 'src/app/shared/model/email/Email.model';
import {EmailAdminService} from 'src/app/shared/service/admin/email/EmailAdmin.service';
import {GroupeEmailDto} from 'src/app/shared/model/emailgroup/GroupeEmail.model';
import {GroupeEmailAdminService} from 'src/app/shared/service/admin/emailgroup/GroupeEmailAdmin.service';

@Component({
  selector: 'app-email-detail-group-edit-admin',
  templateUrl: './email-detail-group-edit-admin.component.html'
})
export class EmailDetailGroupEditAdminComponent extends AbstractEditController<EmailDetailGroupDto, EmailDetailGroupCriteria, EmailDetailGroupAdminService>   implements OnInit {



    private _validEmailRef = true;



    constructor( private emailDetailGroupService: EmailDetailGroupAdminService , private emailService: EmailAdminService, private groupeEmailService: GroupeEmailAdminService) {
        super(emailDetailGroupService);
    }

    ngOnInit(): void {
        this.email = new EmailDto();
        this.emailService.findAll().subscribe((data) => this.emails = data);
        this.destination = new GroupeEmailDto();
        this.groupeEmailService.findAll().subscribe((data) => this.destinations = data);
    }
    public override prepareEdit() {
        this.item.dateReception = this.emailDetailGroupService.format(this.item.dateReception);
        this.item.dateLecture = this.emailDetailGroupService.format(this.item.dateLecture);
    }



    public override setValidation(value: boolean){
        }
    public override validateForm(): void{
        this.errorMessages = new Array<string>();
    }



   public async openCreateDestination(destination: string) {
        const isPermistted = await this.roleService.isPermitted('GroupeEmail', 'edit');
        if (isPermistted) {
             this.destination = new GroupeEmailDto();
             this.createDestinationDialog = true;
        }else {
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
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



    get validEmailRef(): boolean {
        return this._validEmailRef;
    }
    set validEmailRef(value: boolean) {
        this._validEmailRef = value;
    }
}
