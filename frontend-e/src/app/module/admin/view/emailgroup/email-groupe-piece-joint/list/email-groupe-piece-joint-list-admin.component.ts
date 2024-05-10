import {Component, OnInit} from '@angular/core';
import {EmailGroupePieceJointAdminService} from 'src/app/shared/service/admin/emailgroup/EmailGroupePieceJointAdmin.service';
import {EmailGroupePieceJointDto} from 'src/app/shared/model/emailgroup/EmailGroupePieceJoint.model';
import {EmailGroupePieceJointCriteria} from 'src/app/shared/criteria/emailgroup/EmailGroupePieceJointCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {TypeContenuDto} from 'src/app/shared/model/commun/TypeContenu.model';
import {TypeContenuAdminService} from 'src/app/shared/service/admin/commun/TypeContenuAdmin.service';
import {GroupeEmailDto} from 'src/app/shared/model/emailgroup/GroupeEmail.model';
import {GroupeEmailAdminService} from 'src/app/shared/service/admin/emailgroup/GroupeEmailAdmin.service';


@Component({
  selector: 'app-email-groupe-piece-joint-list-admin',
  templateUrl: './email-groupe-piece-joint-list-admin.component.html'
})
export class EmailGroupePieceJointListAdminComponent extends AbstractListController<EmailGroupePieceJointDto, EmailGroupePieceJointCriteria, EmailGroupePieceJointAdminService>  implements OnInit {

    override fileName = 'EmailGroupePieceJoint';


    typecontenus: Array<TypeContenuDto>;
    groupeEmails: Array<GroupeEmailDto>;


    constructor( private emailGroupePieceJointService: EmailGroupePieceJointAdminService  , private typeContenuService: TypeContenuAdminService, private groupeEmailService: GroupeEmailAdminService) {
        super(emailGroupePieceJointService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('EmailGroupePieceJoint').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
                this.loadTypecontenu();
                this.loadGroupeEmail();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'path', header: 'Path'},
            {field: 'taille', header: 'Taille'},
            {field: 'typecontenu?.libelle', header: 'Typecontenu'},
            {field: 'groupeEmail?.id', header: 'Groupe email'},
        ];
    }


    public async loadTypecontenu(){
       this.typeContenuService.findAllOptimized().subscribe(typecontenus => this.typecontenus = typecontenus, error => console.log(error))
    }
    public async loadGroupeEmail(){
       this.groupeEmailService.findAll().subscribe(groupeEmails => this.groupeEmails = groupeEmails, error => console.log(error))
    }



   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Path': e.path ,
                 'Taille': e.taille ,
                'Typecontenu': e.typecontenu?.libelle ,
                'Groupe email': e.groupeEmail?.id ,
            }
        });

        this.criteriaData = [{
            'Path': this.criteria.path ? this.criteria.path : environment.emptyForExport ,
            'Taille Min': this.criteria.tailleMin ? this.criteria.tailleMin : environment.emptyForExport ,
            'Taille Max': this.criteria.tailleMax ? this.criteria.tailleMax : environment.emptyForExport ,
        //'Typecontenu': this.criteria.typecontenu?.libelle ? this.criteria.typecontenu?.libelle : environment.emptyForExport ,
        //'Groupe email': this.criteria.groupeEmail?.id ? this.criteria.groupeEmail?.id : environment.emptyForExport ,
        }];
      }
}
