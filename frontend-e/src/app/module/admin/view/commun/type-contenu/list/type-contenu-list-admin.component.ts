import {Component, OnInit} from '@angular/core';
import {TypeContenuAdminService} from 'src/app/shared/service/admin/commun/TypeContenuAdmin.service';
import {TypeContenuDto} from 'src/app/shared/model/commun/TypeContenu.model';
import {TypeContenuCriteria} from 'src/app/shared/criteria/commun/TypeContenuCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';



@Component({
  selector: 'app-type-contenu-list-admin',
  templateUrl: './type-contenu-list-admin.component.html'
})
export class TypeContenuListAdminComponent extends AbstractListController<TypeContenuDto, TypeContenuCriteria, TypeContenuAdminService>  implements OnInit {

    override fileName = 'TypeContenu';




    constructor( private typeContenuService: TypeContenuAdminService  ) {
        super(typeContenuService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('TypeContenu').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
            {field: 'code', header: 'Code'},
        ];
    }





   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Libelle': e.libelle ,
                 'Code': e.code ,
            }
        });

        this.criteriaData = [{
            'Libelle': this.criteria.libelle ? this.criteria.libelle : environment.emptyForExport ,
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
        }];
      }
}
