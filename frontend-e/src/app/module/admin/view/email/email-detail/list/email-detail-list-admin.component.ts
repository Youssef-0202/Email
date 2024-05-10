import {Component, OnInit} from '@angular/core';
import {EmailDetailAdminService} from 'src/app/shared/service/admin/email/EmailDetailAdmin.service';
import {EmailDetailDto} from 'src/app/shared/model/email/EmailDetail.model';
import {EmailDetailCriteria} from 'src/app/shared/criteria/email/EmailDetailCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {EtatEmailDto} from 'src/app/shared/model/commun/EtatEmail.model';
import {EtatEmailAdminService} from 'src/app/shared/service/admin/commun/EtatEmailAdmin.service';
import {EmailDto} from 'src/app/shared/model/email/Email.model';
import {EmailAdminService} from 'src/app/shared/service/admin/email/EmailAdmin.service';
import {UtilisateurDto} from 'src/app/shared/model/commun/Utilisateur.model';
import {UtilisateurAdminService} from 'src/app/shared/service/admin/commun/UtilisateurAdmin.service';


@Component({
  selector: 'app-email-detail-list-admin',
  templateUrl: './email-detail-list-admin.component.html'
})
export class EmailDetailListAdminComponent extends AbstractListController<EmailDetailDto, EmailDetailCriteria, EmailDetailAdminService>  implements OnInit {

    override fileName = 'EmailDetail';


    emails: Array<EmailDto>;
    personneDestinataires: Array<UtilisateurDto>;
    etatEmails: Array<EtatEmailDto>;


    constructor( private emailDetailService: EmailDetailAdminService  , private etatEmailService: EtatEmailAdminService, private emailService: EmailAdminService, private utilisateurService: UtilisateurAdminService) {
        super(emailDetailService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('EmailDetail').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
                this.loadEmail();
                this.loadPersonneDestinataire();
                this.loadEtatEmail();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'email?.ref', header: 'Email'},
            {field: 'personneDestinataire?.email', header: 'Personne destinataire'},
            {field: 'etatEmail?.libelle', header: 'Etat email'},
            {field: 'dateLecture', header: 'Date lecture'},
            {field: 'dateReception', header: 'Date reception'},
        ];
    }


    public async loadEmail(){
       this.emailService.findAllOptimized().subscribe(emails => this.emails = emails, error => console.log(error))
    }
    public async loadPersonneDestinataire(){
       this.utilisateurService.findAllOptimized().subscribe(personneDestinataires => this.personneDestinataires = personneDestinataires, error => console.log(error))
    }
    public async loadEtatEmail(){
       this.etatEmailService.findAllOptimized().subscribe(etatEmails => this.etatEmails = etatEmails, error => console.log(error))
    }



   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                'Email': e.email?.ref ,
                'Personne destinataire': e.personneDestinataire?.email ,
                'Etat email': e.etatEmail?.libelle ,
                'Date lecture': this.datePipe.transform(e.dateLecture , 'dd/MM/yyyy hh:mm'),
                'Date reception': this.datePipe.transform(e.dateReception , 'dd/MM/yyyy hh:mm'),
            }
        });

        this.criteriaData = [{
        //'Email': this.criteria.email?.ref ? this.criteria.email?.ref : environment.emptyForExport ,
        //'Personne destinataire': this.criteria.personneDestinataire?.email ? this.criteria.personneDestinataire?.email : environment.emptyForExport ,
        //'Etat email': this.criteria.etatEmail?.libelle ? this.criteria.etatEmail?.libelle : environment.emptyForExport ,
            'Date lecture Min': this.criteria.dateLectureFrom ? this.datePipe.transform(this.criteria.dateLectureFrom , this.dateFormat) : environment.emptyForExport ,
            'Date lecture Max': this.criteria.dateLectureTo ? this.datePipe.transform(this.criteria.dateLectureTo , this.dateFormat) : environment.emptyForExport ,
            'Date reception Min': this.criteria.dateReceptionFrom ? this.datePipe.transform(this.criteria.dateReceptionFrom , this.dateFormat) : environment.emptyForExport ,
            'Date reception Max': this.criteria.dateReceptionTo ? this.datePipe.transform(this.criteria.dateReceptionTo , this.dateFormat) : environment.emptyForExport ,
        }];
      }
}
