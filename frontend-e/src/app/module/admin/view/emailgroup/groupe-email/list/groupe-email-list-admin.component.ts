import {Component, OnInit} from '@angular/core';
import {GroupeEmailAdminService} from 'src/app/shared/service/admin/emailgroup/GroupeEmailAdmin.service';
import {GroupeEmailDto} from 'src/app/shared/model/emailgroup/GroupeEmail.model';
import {GroupeEmailCriteria} from 'src/app/shared/criteria/emailgroup/GroupeEmailCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {GroupeEmailDetailDto} from 'src/app/shared/model/emailgroup/GroupeEmailDetail.model';
import {GroupeEmailDetailAdminService} from 'src/app/shared/service/admin/emailgroup/GroupeEmailDetailAdmin.service';
import {UtilisateurDto} from 'src/app/shared/model/commun/Utilisateur.model';
import {UtilisateurAdminService} from 'src/app/shared/service/admin/commun/UtilisateurAdmin.service';


@Component({
  selector: 'app-groupe-email-list-admin',
  templateUrl: './groupe-email-list-admin.component.html'
})
export class GroupeEmailListAdminComponent extends AbstractListController<GroupeEmailDto, GroupeEmailCriteria, GroupeEmailAdminService>  implements OnInit {

    override fileName = 'GroupeEmail';


    adminGroupes: Array<UtilisateurDto>;


    constructor( private groupeEmailService: GroupeEmailAdminService  , private groupeEmailDetailService: GroupeEmailDetailAdminService, private utilisateurService: UtilisateurAdminService) {
        super(groupeEmailService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('GroupeEmail').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
                this.loadAdminGroupe();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
            {field: 'adminGroupe?.email', header: 'Admin groupe'},
        ];
    }


    public async loadAdminGroupe(){
       this.utilisateurService.findAllOptimized().subscribe(adminGroupes => this.adminGroupes = adminGroupes, error => console.log(error))
    }

	public override initDuplicate(res: GroupeEmailDto) {
        if (res.groupeEmailDetails != null) {
             res.groupeEmailDetails.forEach(d => { d.groupeEmail = null; d.id = null; });
        }
	}


   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Libelle': e.libelle ,
                'Admin groupe': e.adminGroupe?.email ,
            }
        });

        this.criteriaData = [{
            'Libelle': this.criteria.libelle ? this.criteria.libelle : environment.emptyForExport ,
        //'Admin groupe': this.criteria.adminGroupe?.email ? this.criteria.adminGroupe?.email : environment.emptyForExport ,
        }];
      }
}
