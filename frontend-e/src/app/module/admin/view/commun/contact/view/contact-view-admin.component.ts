import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {ContactAdminService} from 'src/app/shared/service/admin/commun/ContactAdmin.service';
import {ContactDto} from 'src/app/shared/model/commun/Contact.model';
import {ContactCriteria} from 'src/app/shared/criteria/commun/ContactCriteria.model';

import {UtilisateurDto} from 'src/app/shared/model/commun/Utilisateur.model';
import {UtilisateurAdminService} from 'src/app/shared/service/admin/commun/UtilisateurAdmin.service';
@Component({
  selector: 'app-contact-view-admin',
  templateUrl: './contact-view-admin.component.html'
})
export class ContactViewAdminComponent extends AbstractViewController<ContactDto, ContactCriteria, ContactAdminService> implements OnInit {


    constructor(private contactService: ContactAdminService, private utilisateurService: UtilisateurAdminService){
        super(contactService);
    }

    ngOnInit(): void {
    }


    get personneSource(): UtilisateurDto {
       return this.utilisateurService.item;
    }
    set personneSource(value: UtilisateurDto) {
        this.utilisateurService.item = value;
    }
    get personneSources(): Array<UtilisateurDto> {
       return this.utilisateurService.items;
    }
    set personneSources(value: Array<UtilisateurDto>) {
        this.utilisateurService.items = value;
    }
    get personneDestination(): UtilisateurDto {
       return this.utilisateurService.item;
    }
    set personneDestination(value: UtilisateurDto) {
        this.utilisateurService.item = value;
    }
    get personneDestinations(): Array<UtilisateurDto> {
       return this.utilisateurService.items;
    }
    set personneDestinations(value: Array<UtilisateurDto>) {
        this.utilisateurService.items = value;
    }


}
