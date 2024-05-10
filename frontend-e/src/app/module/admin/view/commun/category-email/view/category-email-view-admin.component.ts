import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {CategoryEmailAdminService} from 'src/app/shared/service/admin/commun/CategoryEmailAdmin.service';
import {CategoryEmailDto} from 'src/app/shared/model/commun/CategoryEmail.model';
import {CategoryEmailCriteria} from 'src/app/shared/criteria/commun/CategoryEmailCriteria.model';

@Component({
  selector: 'app-category-email-view-admin',
  templateUrl: './category-email-view-admin.component.html'
})
export class CategoryEmailViewAdminComponent extends AbstractViewController<CategoryEmailDto, CategoryEmailCriteria, CategoryEmailAdminService> implements OnInit {


    constructor(private categoryEmailService: CategoryEmailAdminService){
        super(categoryEmailService);
    }

    ngOnInit(): void {
    }




}
