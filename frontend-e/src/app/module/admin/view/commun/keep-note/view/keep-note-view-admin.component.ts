import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {KeepNoteAdminService} from 'src/app/shared/service/admin/commun/KeepNoteAdmin.service';
import {KeepNoteDto} from 'src/app/shared/model/commun/KeepNote.model';
import {KeepNoteCriteria} from 'src/app/shared/criteria/commun/KeepNoteCriteria.model';

import {UtilisateurDto} from 'src/app/shared/model/commun/Utilisateur.model';
import {UtilisateurAdminService} from 'src/app/shared/service/admin/commun/UtilisateurAdmin.service';
@Component({
  selector: 'app-keep-note-view-admin',
  templateUrl: './keep-note-view-admin.component.html'
})
export class KeepNoteViewAdminComponent extends AbstractViewController<KeepNoteDto, KeepNoteCriteria, KeepNoteAdminService> implements OnInit {


    constructor(private keepNoteService: KeepNoteAdminService, private utilisateurService: UtilisateurAdminService){
        super(keepNoteService);
    }

    ngOnInit(): void {
    }


    get personne(): UtilisateurDto {
       return this.utilisateurService.item;
    }
    set personne(value: UtilisateurDto) {
        this.utilisateurService.item = value;
    }
    get personnes(): Array<UtilisateurDto> {
       return this.utilisateurService.items;
    }
    set personnes(value: Array<UtilisateurDto>) {
        this.utilisateurService.items = value;
    }


}
