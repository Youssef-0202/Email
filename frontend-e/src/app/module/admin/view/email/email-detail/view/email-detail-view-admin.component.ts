import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

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
  selector: 'app-email-detail-view-admin',
  templateUrl: './email-detail-view-admin.component.html'
})
export class EmailDetailViewAdminComponent extends AbstractViewController<EmailDetailDto, EmailDetailCriteria, EmailDetailAdminService> implements OnInit {


    constructor(private emailDetailService: EmailDetailAdminService, private etatEmailService: EtatEmailAdminService, private emailService: EmailAdminService, private utilisateurService: UtilisateurAdminService){
        super(emailDetailService);
    }

    ngOnInit(): void {
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


}
