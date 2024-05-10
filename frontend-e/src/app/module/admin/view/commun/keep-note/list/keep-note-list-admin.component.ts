import {Component, OnInit} from '@angular/core';
import {KeepNoteAdminService} from 'src/app/shared/service/admin/commun/KeepNoteAdmin.service';
import {KeepNoteDto} from 'src/app/shared/model/commun/KeepNote.model';
import {KeepNoteCriteria} from 'src/app/shared/criteria/commun/KeepNoteCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {UtilisateurDto} from 'src/app/shared/model/commun/Utilisateur.model';
import {UtilisateurAdminService} from 'src/app/shared/service/admin/commun/UtilisateurAdmin.service';


@Component({
  selector: 'app-keep-note-list-admin',
  templateUrl: './keep-note-list-admin.component.html'
})
export class KeepNoteListAdminComponent extends AbstractListController<KeepNoteDto, KeepNoteCriteria, KeepNoteAdminService>  implements OnInit {

    override fileName = 'KeepNote';


    personnes: Array<UtilisateurDto>;


    constructor( private keepNoteService: KeepNoteAdminService  , private utilisateurService: UtilisateurAdminService) {
        super(keepNoteService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('KeepNote').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
                this.loadPersonne();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'header', header: 'Header'},
            {field: 'personne?.email', header: 'Personne'},
            {field: 'dateKeepNote', header: 'Date keep note'},
        ];
    }


    public async loadPersonne(){
       this.utilisateurService.findAllOptimized().subscribe(personnes => this.personnes = personnes, error => console.log(error))
    }



   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Body': e.body ,
                 'Header': e.header ,
                'Personne': e.personne?.email ,
                'Date keep note': this.datePipe.transform(e.dateKeepNote , 'dd/MM/yyyy hh:mm'),
            }
        });

        this.criteriaData = [{
            'Body': this.criteria.body ? this.criteria.body : environment.emptyForExport ,
            'Header': this.criteria.header ? this.criteria.header : environment.emptyForExport ,
        //'Personne': this.criteria.personne?.email ? this.criteria.personne?.email : environment.emptyForExport ,
            'Date keep note Min': this.criteria.dateKeepNoteFrom ? this.datePipe.transform(this.criteria.dateKeepNoteFrom , this.dateFormat) : environment.emptyForExport ,
            'Date keep note Max': this.criteria.dateKeepNoteTo ? this.datePipe.transform(this.criteria.dateKeepNoteTo , this.dateFormat) : environment.emptyForExport ,
        }];
      }
}
