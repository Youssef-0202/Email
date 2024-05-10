import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {TypeContenuAdminService} from 'src/app/shared/service/admin/commun/TypeContenuAdmin.service';
import {TypeContenuDto} from 'src/app/shared/model/commun/TypeContenu.model';
import {TypeContenuCriteria} from 'src/app/shared/criteria/commun/TypeContenuCriteria.model';

@Component({
  selector: 'app-type-contenu-view-admin',
  templateUrl: './type-contenu-view-admin.component.html'
})
export class TypeContenuViewAdminComponent extends AbstractViewController<TypeContenuDto, TypeContenuCriteria, TypeContenuAdminService> implements OnInit {


    constructor(private typeContenuService: TypeContenuAdminService){
        super(typeContenuService);
    }

    ngOnInit(): void {
    }




}
