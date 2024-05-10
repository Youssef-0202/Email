import {Component, OnInit} from '@angular/core';
import {CategoryEmailAdminService} from 'src/app/shared/service/admin/commun/CategoryEmailAdmin.service';
import {CategoryEmailDto} from 'src/app/shared/model/commun/CategoryEmail.model';
import {CategoryEmailCriteria} from 'src/app/shared/criteria/commun/CategoryEmailCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';



@Component({
  selector: 'app-category-email-list-admin',
  templateUrl: './category-email-list-admin.component.html'
})
export class CategoryEmailListAdminComponent extends AbstractListController<CategoryEmailDto, CategoryEmailCriteria, CategoryEmailAdminService>  implements OnInit {

    override fileName = 'CategoryEmail';




    constructor( private categoryEmailService: CategoryEmailAdminService  ) {
        super(categoryEmailService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('CategoryEmail').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'name', header: 'Name'},
            {field: 'code', header: 'Code'},
        ];
    }





   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Name': e.name ,
                 'Code': e.code ,
            }
        });

        this.criteriaData = [{
            'Name': this.criteria.name ? this.criteria.name : environment.emptyForExport ,
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
        }];
      }
}
