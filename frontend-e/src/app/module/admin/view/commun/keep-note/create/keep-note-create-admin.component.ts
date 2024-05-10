import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {KeepNoteAdminService} from 'src/app/shared/service/admin/commun/KeepNoteAdmin.service';
import {KeepNoteDto} from 'src/app/shared/model/commun/KeepNote.model';
import {KeepNoteCriteria} from 'src/app/shared/criteria/commun/KeepNoteCriteria.model';
import {UtilisateurDto} from 'src/app/shared/model/commun/Utilisateur.model';
import {UtilisateurAdminService} from 'src/app/shared/service/admin/commun/UtilisateurAdmin.service';
@Component({
  selector: 'app-keep-note-create-admin',
  templateUrl: './keep-note-create-admin.component.html'
})
export class KeepNoteCreateAdminComponent extends AbstractCreateController<KeepNoteDto, KeepNoteCriteria, KeepNoteAdminService>  implements OnInit {



    private _validPersonneUsername = true;
    private _validPersonneEmail = true;

    constructor( private keepNoteService: KeepNoteAdminService , private utilisateurService: UtilisateurAdminService) {
        super(keepNoteService);
    }

    ngOnInit(): void {
        this.personne = new UtilisateurDto();
        this.utilisateurService.findAll().subscribe((data) => this.personnes = data);
    }





    public override setValidation(value: boolean){
    }



    public override validateForm(): void{
        this.errorMessages = new Array<string>();
    }



    public async openCreatePersonne(personne: string) {
    const isPermistted = await this.roleService.isPermitted('Utilisateur', 'add');
    if(isPermistted) {
         this.personne = new UtilisateurDto();
         this.createPersonneDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
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
    get createPersonneDialog(): boolean {
       return this.utilisateurService.createDialog;
    }
    set createPersonneDialog(value: boolean) {
        this.utilisateurService.createDialog= value;
    }




    get validPersonneUsername(): boolean {
        return this._validPersonneUsername;
    }
    set validPersonneUsername(value: boolean) {
        this._validPersonneUsername = value;
    }
    get validPersonneEmail(): boolean {
        return this._validPersonneEmail;
    }
    set validPersonneEmail(value: boolean) {
        this._validPersonneEmail = value;
    }


    get note(): KeepNoteDto {

        return this.keepNoteService.note;
    }

    set note(value: KeepNoteDto) {
        this.keepNoteService.note = value;
    }

    get notes(): Array<KeepNoteDto> {

        return this.keepNoteService.notes;
    }

    set notes(value: Array<KeepNoteDto>) {
        this.keepNoteService.notes = value;
    }

    public keepNote():void{
        this.keepNoteService.keepNote().subscribe();
    }


}
