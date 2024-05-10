import {Component, OnInit} from '@angular/core';
import {GroupeEmailDetailAdminService} from 'src/app/shared/service/admin/emailgroup/GroupeEmailDetailAdmin.service';
import {GroupeEmailDetailDto} from 'src/app/shared/model/emailgroup/GroupeEmailDetail.model';
import {GroupeEmailDetailCriteria} from 'src/app/shared/criteria/emailgroup/GroupeEmailDetailCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {UtilisateurDto} from 'src/app/shared/model/commun/Utilisateur.model';
import {UtilisateurAdminService} from 'src/app/shared/service/admin/commun/UtilisateurAdmin.service';
import {GroupeEmailDto} from 'src/app/shared/model/emailgroup/GroupeEmail.model';
import {GroupeEmailAdminService} from 'src/app/shared/service/admin/emailgroup/GroupeEmailAdmin.service';


@Component({
  selector: 'app-groupe-email-detail-list-admin',
  templateUrl: './groupe-email-detail-list-admin.component.html'
})
export class GroupeEmailDetailListAdminComponent extends AbstractListController<GroupeEmailDetailDto, GroupeEmailDetailCriteria, GroupeEmailDetailAdminService>  implements OnInit {

    override fileName = 'GroupeEmailDetail';


    personnes: Array<UtilisateurDto>;
    groupeEmails: Array<GroupeEmailDto>;


    constructor( private groupeEmailDetailService: GroupeEmailDetailAdminService  , private utilisateurService: UtilisateurAdminService, private groupeEmailService: GroupeEmailAdminService) {
        super(groupeEmailDetailService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('GroupeEmailDetail').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
                this.loadPersonne();
                this.loadGroupeEmail();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'personne?.email', header: 'Personne'},
            {field: 'dateAjoute', header: 'Date ajoute'},
            {field: 'dateBlockage', header: 'Date blockage'},
            {field: 'groupeEmail?.id', header: 'Groupe email'},
        ];
    }


    public async loadPersonne(){
       this.utilisateurService.findAllOptimized().subscribe(personnes => this.personnes = personnes, error => console.log(error))
    }
    public async loadGroupeEmail(){
       this.groupeEmailService.findAll().subscribe(groupeEmails => this.groupeEmails = groupeEmails, error => console.log(error))
    }



   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                'Personne': e.personne?.email ,
                'Date ajoute': this.datePipe.transform(e.dateAjoute , 'dd/MM/yyyy hh:mm'),
                'Date blockage': this.datePipe.transform(e.dateBlockage , 'dd/MM/yyyy hh:mm'),
                'Groupe email': e.groupeEmail?.id ,
            }
        });

        this.criteriaData = [{
        //'Personne': this.criteria.personne?.email ? this.criteria.personne?.email : environment.emptyForExport ,
            'Date ajoute Min': this.criteria.dateAjouteFrom ? this.datePipe.transform(this.criteria.dateAjouteFrom , this.dateFormat) : environment.emptyForExport ,
            'Date ajoute Max': this.criteria.dateAjouteTo ? this.datePipe.transform(this.criteria.dateAjouteTo , this.dateFormat) : environment.emptyForExport ,
            'Date blockage Min': this.criteria.dateBlockageFrom ? this.datePipe.transform(this.criteria.dateBlockageFrom , this.dateFormat) : environment.emptyForExport ,
            'Date blockage Max': this.criteria.dateBlockageTo ? this.datePipe.transform(this.criteria.dateBlockageTo , this.dateFormat) : environment.emptyForExport ,
        //'Groupe email': this.criteria.groupeEmail?.id ? this.criteria.groupeEmail?.id : environment.emptyForExport ,
        }];
      }
}
