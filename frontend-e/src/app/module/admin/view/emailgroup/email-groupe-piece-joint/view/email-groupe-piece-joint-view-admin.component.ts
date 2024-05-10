import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {EmailGroupePieceJointAdminService} from 'src/app/shared/service/admin/emailgroup/EmailGroupePieceJointAdmin.service';
import {EmailGroupePieceJointDto} from 'src/app/shared/model/emailgroup/EmailGroupePieceJoint.model';
import {EmailGroupePieceJointCriteria} from 'src/app/shared/criteria/emailgroup/EmailGroupePieceJointCriteria.model';

import {TypeContenuDto} from 'src/app/shared/model/commun/TypeContenu.model';
import {TypeContenuAdminService} from 'src/app/shared/service/admin/commun/TypeContenuAdmin.service';
import {GroupeEmailDto} from 'src/app/shared/model/emailgroup/GroupeEmail.model';
import {GroupeEmailAdminService} from 'src/app/shared/service/admin/emailgroup/GroupeEmailAdmin.service';
@Component({
  selector: 'app-email-groupe-piece-joint-view-admin',
  templateUrl: './email-groupe-piece-joint-view-admin.component.html'
})
export class EmailGroupePieceJointViewAdminComponent extends AbstractViewController<EmailGroupePieceJointDto, EmailGroupePieceJointCriteria, EmailGroupePieceJointAdminService> implements OnInit {


    constructor(private emailGroupePieceJointService: EmailGroupePieceJointAdminService, private typeContenuService: TypeContenuAdminService, private groupeEmailService: GroupeEmailAdminService){
        super(emailGroupePieceJointService);
    }

    ngOnInit(): void {
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


}
