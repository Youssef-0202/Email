import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

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
  selector: 'app-email-view-admin',
  templateUrl: './email-view-admin.component.html'
})
export class EmailViewAdminComponent extends AbstractViewController<EmailDto, EmailCriteria, EmailAdminService> implements OnInit {

    emailDetails = new EmailDetailDto();
    emailDetailss: Array<EmailDetailDto> = [];
    emailpieceJoints = new EmailpieceJoinDto();
    emailpieceJointss: Array<EmailpieceJoinDto> = [];
    emailDetailGroups = new EmailDetailGroupDto();
    emailDetailGroupss: Array<EmailDetailGroupDto> = [];

    constructor(private emailService: EmailAdminService, private etatEmailService: EtatEmailAdminService, private emailpieceJoinService: EmailpieceJoinAdminService, private typeContenuService: TypeContenuAdminService, private emailDetailGroupService: EmailDetailGroupAdminService, private utilisateurService: UtilisateurAdminService, private categoryEmailService: CategoryEmailAdminService, private emailDetailService: EmailDetailAdminService, private groupeEmailService: GroupeEmailAdminService){
        super(emailService);
    }

    ngOnInit(): void {
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


}
