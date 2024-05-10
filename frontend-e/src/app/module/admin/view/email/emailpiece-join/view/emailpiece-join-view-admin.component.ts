import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {EmailpieceJoinAdminService} from 'src/app/shared/service/admin/email/EmailpieceJoinAdmin.service';
import {EmailpieceJoinDto} from 'src/app/shared/model/email/EmailpieceJoin.model';
import {EmailpieceJoinCriteria} from 'src/app/shared/criteria/email/EmailpieceJoinCriteria.model';

import {EmailDto} from 'src/app/shared/model/email/Email.model';
import {EmailAdminService} from 'src/app/shared/service/admin/email/EmailAdmin.service';
import {TypeContenuDto} from 'src/app/shared/model/commun/TypeContenu.model';
import {TypeContenuAdminService} from 'src/app/shared/service/admin/commun/TypeContenuAdmin.service';
@Component({
  selector: 'app-emailpiece-join-view-admin',
  templateUrl: './emailpiece-join-view-admin.component.html'
})
export class EmailpieceJoinViewAdminComponent extends AbstractViewController<EmailpieceJoinDto, EmailpieceJoinCriteria, EmailpieceJoinAdminService> implements OnInit {


    constructor(private emailpieceJoinService: EmailpieceJoinAdminService, private emailService: EmailAdminService, private typeContenuService: TypeContenuAdminService){
        super(emailpieceJoinService);
    }

    ngOnInit(): void {
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


}
