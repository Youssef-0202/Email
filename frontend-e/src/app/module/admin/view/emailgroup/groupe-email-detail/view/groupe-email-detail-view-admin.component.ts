import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {GroupeEmailDetailAdminService} from 'src/app/shared/service/admin/emailgroup/GroupeEmailDetailAdmin.service';
import {GroupeEmailDetailDto} from 'src/app/shared/model/emailgroup/GroupeEmailDetail.model';
import {GroupeEmailDetailCriteria} from 'src/app/shared/criteria/emailgroup/GroupeEmailDetailCriteria.model';

import {UtilisateurDto} from 'src/app/shared/model/commun/Utilisateur.model';
import {UtilisateurAdminService} from 'src/app/shared/service/admin/commun/UtilisateurAdmin.service';
import {GroupeEmailDto} from 'src/app/shared/model/emailgroup/GroupeEmail.model';
import {GroupeEmailAdminService} from 'src/app/shared/service/admin/emailgroup/GroupeEmailAdmin.service';
@Component({
  selector: 'app-groupe-email-detail-view-admin',
  templateUrl: './groupe-email-detail-view-admin.component.html'
})
export class GroupeEmailDetailViewAdminComponent extends AbstractViewController<GroupeEmailDetailDto, GroupeEmailDetailCriteria, GroupeEmailDetailAdminService> implements OnInit {


    constructor(private groupeEmailDetailService: GroupeEmailDetailAdminService, private utilisateurService: UtilisateurAdminService, private groupeEmailService: GroupeEmailAdminService){
        super(groupeEmailDetailService);
    }

    ngOnInit(): void {
    }


    get personne(): UtilisateurDto {
       return this.utilisateurService.item;
    }
    set personne(value: UtilisateurDto) {
        this.utilisateurService.item = value;
    }
    get personnes(): Array<UtilisateurDto> {
       return this.utilisateurService.items;
    }
    set personnes(value: Array<UtilisateurDto>) {
        this.utilisateurService.items = value;
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
