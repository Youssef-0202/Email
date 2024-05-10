import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {UtilisateurAdminService} from 'src/app/shared/service/admin/commun/UtilisateurAdmin.service';
import {UtilisateurDto} from 'src/app/shared/model/commun/Utilisateur.model';
import {UtilisateurCriteria} from 'src/app/shared/criteria/commun/UtilisateurCriteria.model';

@Component({
  selector: 'app-utilisateur-view-admin',
  templateUrl: './utilisateur-view-admin.component.html'
})
export class UtilisateurViewAdminComponent extends AbstractViewController<UtilisateurDto, UtilisateurCriteria, UtilisateurAdminService> implements OnInit {


    constructor(private utilisateurService: UtilisateurAdminService){
        super(utilisateurService);
    }

    ngOnInit(): void {
    }




}
