import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {GroupeEmailAdminService} from 'src/app/shared/service/admin/emailgroup/GroupeEmailAdmin.service';
import {GroupeEmailDto} from 'src/app/shared/model/emailgroup/GroupeEmail.model';
import {GroupeEmailCriteria} from 'src/app/shared/criteria/emailgroup/GroupeEmailCriteria.model';

import {GroupeEmailDetailDto} from 'src/app/shared/model/emailgroup/GroupeEmailDetail.model';
import {GroupeEmailDetailAdminService} from 'src/app/shared/service/admin/emailgroup/GroupeEmailDetailAdmin.service';
import {UtilisateurDto} from 'src/app/shared/model/commun/Utilisateur.model';
import {UtilisateurAdminService} from 'src/app/shared/service/admin/commun/UtilisateurAdmin.service';
@Component({
  selector: 'app-groupe-email-view-admin',
  templateUrl: './groupe-email-view-admin.component.html'
})
export class GroupeEmailViewAdminComponent extends AbstractViewController<GroupeEmailDto, GroupeEmailCriteria, GroupeEmailAdminService> implements OnInit {

    groupeEmailDetails = new GroupeEmailDetailDto();
    groupeEmailDetailss: Array<GroupeEmailDetailDto> = [];

    constructor(private groupeEmailService: GroupeEmailAdminService, private groupeEmailDetailService: GroupeEmailDetailAdminService, private utilisateurService: UtilisateurAdminService){
        super(groupeEmailService);
    }

    ngOnInit(): void {
    }


    get adminGroupe(): UtilisateurDto {
       return this.utilisateurService.item;
    }
    set adminGroupe(value: UtilisateurDto) {
        this.utilisateurService.item = value;
    }
    get adminGroupes(): Array<UtilisateurDto> {
       return this.utilisateurService.items;
    }
    set adminGroupes(value: Array<UtilisateurDto>) {
        this.utilisateurService.items = value;
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


}
