import {Component, OnInit} from '@angular/core';
import {UtilisateurAdminService} from 'src/app/shared/service/admin/commun/UtilisateurAdmin.service';
import {UtilisateurDto} from 'src/app/shared/model/commun/Utilisateur.model';
import {UtilisateurCriteria} from 'src/app/shared/criteria/commun/UtilisateurCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';



@Component({
  selector: 'app-utilisateur-list-admin',
  templateUrl: './utilisateur-list-admin.component.html'
})
export class UtilisateurListAdminComponent extends AbstractListController<UtilisateurDto, UtilisateurCriteria, UtilisateurAdminService>  implements OnInit {

    override fileName = 'Utilisateur';




    constructor( private utilisateurService: UtilisateurAdminService  ) {
        super(utilisateurService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('Utilisateur').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'username', header: 'Username'},
            {field: 'password', header: 'Password'},
            {field: 'email', header: 'Email'},
            {field: 'signature', header: 'Signature'},
        ];
    }





   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Username': e.username ,
                 'Password': e.password ,
                 'Email': e.email ,
                 'Signature': e.signature ,
            }
        });

        this.criteriaData = [{
            'Username': this.criteria.username ? this.criteria.username : environment.emptyForExport ,
            'Password': this.criteria.password ? this.criteria.password : environment.emptyForExport ,
            'Email': this.criteria.email ? this.criteria.email : environment.emptyForExport ,
            'Signature': this.criteria.signature ? this.criteria.signature : environment.emptyForExport ,
        }];
      }
}
