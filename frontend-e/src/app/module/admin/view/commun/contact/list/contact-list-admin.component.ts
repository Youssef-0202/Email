import {Component, OnInit} from '@angular/core';
import {ContactAdminService} from 'src/app/shared/service/admin/commun/ContactAdmin.service';
import {ContactDto} from 'src/app/shared/model/commun/Contact.model';
import {ContactCriteria} from 'src/app/shared/criteria/commun/ContactCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {UtilisateurDto} from 'src/app/shared/model/commun/Utilisateur.model';
import {UtilisateurAdminService} from 'src/app/shared/service/admin/commun/UtilisateurAdmin.service';


@Component({
  selector: 'app-contact-list-admin',
  templateUrl: './contact-list-admin.component.html'
})
export class ContactListAdminComponent extends AbstractListController<ContactDto, ContactCriteria, ContactAdminService>  implements OnInit {

    override fileName = 'Contact';


    personneSources: Array<UtilisateurDto>;
    personneDestinations: Array<UtilisateurDto>;


    constructor( private contactService: ContactAdminService  , private utilisateurService: UtilisateurAdminService) {
        super(contactService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('Contact').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
                this.loadPersonneSource();
                this.loadPersonneDestination();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'name', header: 'Name'},
            {field: 'dateAjout', header: 'Date ajout'},
            {field: 'personneSource?.email', header: 'Personne source'},
            {field: 'personneDestination?.email', header: 'Personne destination'},
        ];
    }


    public async loadPersonneSource(){
       this.utilisateurService.findAllOptimized().subscribe(personneSources => this.personneSources = personneSources, error => console.log(error))
    }
    public async loadPersonneDestination(){
       this.utilisateurService.findAllOptimized().subscribe(personneDestinations => this.personneDestinations = personneDestinations, error => console.log(error))
    }



   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Name': e.name ,
                'Date ajout': this.datePipe.transform(e.dateAjout , 'dd/MM/yyyy hh:mm'),
                'Personne source': e.personneSource?.email ,
                'Personne destination': e.personneDestination?.email ,
            }
        });

        this.criteriaData = [{
            'Name': this.criteria.name ? this.criteria.name : environment.emptyForExport ,
            'Date ajout Min': this.criteria.dateAjoutFrom ? this.datePipe.transform(this.criteria.dateAjoutFrom , this.dateFormat) : environment.emptyForExport ,
            'Date ajout Max': this.criteria.dateAjoutTo ? this.datePipe.transform(this.criteria.dateAjoutTo , this.dateFormat) : environment.emptyForExport ,
        //'Personne source': this.criteria.personneSource?.email ? this.criteria.personneSource?.email : environment.emptyForExport ,
        //'Personne destination': this.criteria.personneDestination?.email ? this.criteria.personneDestination?.email : environment.emptyForExport ,
        }];
      }
}
