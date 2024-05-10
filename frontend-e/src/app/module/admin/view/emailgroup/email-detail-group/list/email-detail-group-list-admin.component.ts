import {Component, OnInit} from '@angular/core';
import {EmailDetailGroupAdminService} from 'src/app/shared/service/admin/emailgroup/EmailDetailGroupAdmin.service';
import {EmailDetailGroupDto} from 'src/app/shared/model/emailgroup/EmailDetailGroup.model';
import {EmailDetailGroupCriteria} from 'src/app/shared/criteria/emailgroup/EmailDetailGroupCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {EmailDto} from 'src/app/shared/model/email/Email.model';
import {EmailAdminService} from 'src/app/shared/service/admin/email/EmailAdmin.service';
import {GroupeEmailDto} from 'src/app/shared/model/emailgroup/GroupeEmail.model';
import {GroupeEmailAdminService} from 'src/app/shared/service/admin/emailgroup/GroupeEmailAdmin.service';


@Component({
  selector: 'app-email-detail-group-list-admin',
  templateUrl: './email-detail-group-list-admin.component.html'
})
export class EmailDetailGroupListAdminComponent extends AbstractListController<EmailDetailGroupDto, EmailDetailGroupCriteria, EmailDetailGroupAdminService>  implements OnInit {

    override fileName = 'EmailDetailGroup';


    emails: Array<EmailDto>;
    destinations: Array<GroupeEmailDto>;


    constructor( private emailDetailGroupService: EmailDetailGroupAdminService  , private emailService: EmailAdminService, private groupeEmailService: GroupeEmailAdminService) {
        super(emailDetailGroupService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('EmailDetailGroup').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
                this.loadEmail();
                this.loadDestination();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'email?.ref', header: 'Email'},
            {field: 'destination?.id', header: 'Destination'},
            {field: 'dateReception', header: 'Date reception'},
            {field: 'dateLecture', header: 'Date lecture'},
        ];
    }


    public async loadEmail(){
       this.emailService.findAllOptimized().subscribe(emails => this.emails = emails, error => console.log(error))
    }
    public async loadDestination(){
       this.groupeEmailService.findAll().subscribe(destinations => this.destinations = destinations, error => console.log(error))
    }



   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                'Email': e.email?.ref ,
                'Destination': e.destination?.id ,
                'Date reception': this.datePipe.transform(e.dateReception , 'dd/MM/yyyy hh:mm'),
                'Date lecture': this.datePipe.transform(e.dateLecture , 'dd/MM/yyyy hh:mm'),
            }
        });

        this.criteriaData = [{
        //'Email': this.criteria.email?.ref ? this.criteria.email?.ref : environment.emptyForExport ,
        //'Destination': this.criteria.destination?.id ? this.criteria.destination?.id : environment.emptyForExport ,
            'Date reception Min': this.criteria.dateReceptionFrom ? this.datePipe.transform(this.criteria.dateReceptionFrom , this.dateFormat) : environment.emptyForExport ,
            'Date reception Max': this.criteria.dateReceptionTo ? this.datePipe.transform(this.criteria.dateReceptionTo , this.dateFormat) : environment.emptyForExport ,
            'Date lecture Min': this.criteria.dateLectureFrom ? this.datePipe.transform(this.criteria.dateLectureFrom , this.dateFormat) : environment.emptyForExport ,
            'Date lecture Max': this.criteria.dateLectureTo ? this.datePipe.transform(this.criteria.dateLectureTo , this.dateFormat) : environment.emptyForExport ,
        }];
      }
}
