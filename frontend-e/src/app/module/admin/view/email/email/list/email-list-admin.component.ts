import {Component, OnInit} from '@angular/core';
import {EmailAdminService} from 'src/app/shared/service/admin/email/EmailAdmin.service';
import {EmailDto} from 'src/app/shared/model/email/Email.model';
import {EmailCriteria} from 'src/app/shared/criteria/email/EmailCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {EtatEmailDto} from 'src/app/shared/model/commun/EtatEmail.model';
import {EtatEmailAdminService} from 'src/app/shared/service/admin/commun/EtatEmailAdmin.service';
import {EmailpieceJoinDto} from 'src/app/shared/model/email/EmailpieceJoin.model';
import {EmailpieceJoinAdminService} from 'src/app/shared/service/admin/email/EmailpieceJoinAdmin.service';
import {TypeContenuDto} from 'src/app/shared/model/commun/TypeContenu.model';
import {TypeContenuAdminService} from 'src/app/shared/service/admin/commun/TypeContenuAdmin.service';
import {EmailDetailGroupDto} from 'src/app/shared/model/emailgroup/EmailDetailGroup.model';
import {EmailDetailGroupAdminService} from 'src/app/shared/service/admin/emailgroup/EmailDetailGroupAdmin.service';
import {UtilisateurDto} from 'src/app/shared/model/commun/Utilisateur.model';
import {UtilisateurAdminService} from 'src/app/shared/service/admin/commun/UtilisateurAdmin.service';
import {CategoryEmailDto} from 'src/app/shared/model/commun/CategoryEmail.model';
import {CategoryEmailAdminService} from 'src/app/shared/service/admin/commun/CategoryEmailAdmin.service';
import {EmailDetailDto} from 'src/app/shared/model/email/EmailDetail.model';
import {EmailDetailAdminService} from 'src/app/shared/service/admin/email/EmailDetailAdmin.service';
import {GroupeEmailDto} from 'src/app/shared/model/emailgroup/GroupeEmail.model';
import {GroupeEmailAdminService} from 'src/app/shared/service/admin/emailgroup/GroupeEmailAdmin.service';


@Component({
  selector: 'app-email-list-admin',
  templateUrl: './email-list-admin.component.html'
})
export class EmailListAdminComponent extends AbstractListController<EmailDto, EmailCriteria, EmailAdminService>  implements OnInit {

    override fileName = 'Email';


    personneSources: Array<UtilisateurDto>;
    categoryEmails: Array<CategoryEmailDto>;
    etatEmails: Array<EtatEmailDto>;


    constructor( private emailService: EmailAdminService  , private etatEmailService: EtatEmailAdminService, private emailpieceJoinService: EmailpieceJoinAdminService, private typeContenuService: TypeContenuAdminService, private emailDetailGroupService: EmailDetailGroupAdminService, private utilisateurService: UtilisateurAdminService, private categoryEmailService: CategoryEmailAdminService, private emailDetailService: EmailDetailAdminService, private groupeEmailService: GroupeEmailAdminService) {
        super(emailService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('Email').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
                this.loadPersonneSource();
                this.loadCategoryEmail();
                this.loadEtatEmail();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'ref', header: 'Ref'},
            {field: 'personneSource?.email', header: 'Personne source'},
            {field: 'dateEnvoi', header: 'Date envoi'},
            {field: 'header', header: 'Header'},
            {field: 'categoryEmail?.name', header: 'Category email'},
            {field: 'etatEmail?.libelle', header: 'Etat email'},
        ];
    }


    public async loadPersonneSource(){
       this.utilisateurService.findAllOptimized().subscribe(personneSources => this.personneSources = personneSources, error => console.log(error))
    }
    public async loadCategoryEmail(){
       this.categoryEmailService.findAllOptimized().subscribe(categoryEmails => this.categoryEmails = categoryEmails, error => console.log(error))
    }
    public async loadEtatEmail(){
       this.etatEmailService.findAllOptimized().subscribe(etatEmails => this.etatEmails = etatEmails, error => console.log(error))
    }

	public override initDuplicate(res: EmailDto) {
        if (res.emailDetails != null) {
             res.emailDetails.forEach(d => { d.email = null; d.id = null; });
        }
        if (res.emailpieceJoints != null) {
             res.emailpieceJoints.forEach(d => { d.email = null; d.id = null; });
        }
        if (res.emailDetailGroups != null) {
             res.emailDetailGroups.forEach(d => { d.email = null; d.id = null; });
        }
	}


   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Ref': e.ref ,
                'Personne source': e.personneSource?.email ,
                'Date envoi': this.datePipe.transform(e.dateEnvoi , 'dd/MM/yyyy hh:mm'),
                 'Corps': e.corps ,
                 'Header': e.header ,
                'Category email': e.categoryEmail?.name ,
                'Etat email': e.etatEmail?.libelle ,
            }
        });

        this.criteriaData = [{
            'Ref': this.criteria.ref ? this.criteria.ref : environment.emptyForExport ,
        //'Personne source': this.criteria.personneSource?.email ? this.criteria.personneSource?.email : environment.emptyForExport ,
            'Date envoi Min': this.criteria.dateEnvoiFrom ? this.datePipe.transform(this.criteria.dateEnvoiFrom , this.dateFormat) : environment.emptyForExport ,
            'Date envoi Max': this.criteria.dateEnvoiTo ? this.datePipe.transform(this.criteria.dateEnvoiTo , this.dateFormat) : environment.emptyForExport ,
            'Corps': this.criteria.corps ? this.criteria.corps : environment.emptyForExport ,
            'Header': this.criteria.header ? this.criteria.header : environment.emptyForExport ,
        //'Category email': this.criteria.categoryEmail?.name ? this.criteria.categoryEmail?.name : environment.emptyForExport ,
        //'Etat email': this.criteria.etatEmail?.libelle ? this.criteria.etatEmail?.libelle : environment.emptyForExport ,
        }];
      }
}
