import {Component, OnInit} from '@angular/core';
import {EtatEmailAdminService} from 'src/app/shared/service/admin/commun/EtatEmailAdmin.service';
import {EtatEmailDto} from 'src/app/shared/model/commun/EtatEmail.model';
import {EtatEmailCriteria} from 'src/app/shared/criteria/commun/EtatEmailCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';



@Component({
  selector: 'app-etat-email-list-admin',
  templateUrl: './etat-email-list-admin.component.html'
})
export class EtatEmailListAdminComponent extends AbstractListController<EtatEmailDto, EtatEmailCriteria, EtatEmailAdminService>  implements OnInit {

    override fileName = 'EtatEmail';




    constructor( private etatEmailService: EtatEmailAdminService  ) {
        super(etatEmailService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('EtatEmail').subscribe(() => {
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
