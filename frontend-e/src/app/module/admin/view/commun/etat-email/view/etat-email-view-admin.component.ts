import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {EtatEmailAdminService} from 'src/app/shared/service/admin/commun/EtatEmailAdmin.service';
import {EtatEmailDto} from 'src/app/shared/model/commun/EtatEmail.model';
import {EtatEmailCriteria} from 'src/app/shared/criteria/commun/EtatEmailCriteria.model';

@Component({
  selector: 'app-etat-email-view-admin',
  templateUrl: './etat-email-view-admin.component.html'
})
export class EtatEmailViewAdminComponent extends AbstractViewController<EtatEmailDto, EtatEmailCriteria, EtatEmailAdminService> implements OnInit {


    constructor(private etatEmailService: EtatEmailAdminService){
        super(etatEmailService);
    }

    ngOnInit(): void {
    }




}
