import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {EmailDetailGroupAdminService} from 'src/app/shared/service/admin/emailgroup/EmailDetailGroupAdmin.service';
import {EmailDetailGroupDto} from 'src/app/shared/model/emailgroup/EmailDetailGroup.model';
import {EmailDetailGroupCriteria} from 'src/app/shared/criteria/emailgroup/EmailDetailGroupCriteria.model';

import {EmailDto} from 'src/app/shared/model/email/Email.model';
import {EmailAdminService} from 'src/app/shared/service/admin/email/EmailAdmin.service';
import {GroupeEmailDto} from 'src/app/shared/model/emailgroup/GroupeEmail.model';
import {GroupeEmailAdminService} from 'src/app/shared/service/admin/emailgroup/GroupeEmailAdmin.service';
@Component({
  selector: 'app-email-detail-group-view-admin',
  templateUrl: './email-detail-group-view-admin.component.html'
})
export class EmailDetailGroupViewAdminComponent extends AbstractViewController<EmailDetailGroupDto, EmailDetailGroupCriteria, EmailDetailGroupAdminService> implements OnInit {


    constructor(private emailDetailGroupService: EmailDetailGroupAdminService, private emailService: EmailAdminService, private groupeEmailService: GroupeEmailAdminService){
        super(emailDetailGroupService);
    }

    ngOnInit(): void {
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


}
