import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {UtilisateurAdminService} from 'src/app/shared/service/admin/commun/UtilisateurAdmin.service';
import {UtilisateurDto} from 'src/app/shared/model/commun/Utilisateur.model';
import {UtilisateurCriteria} from 'src/app/shared/criteria/commun/UtilisateurCriteria.model';



@Component({
  selector: 'app-utilisateur-edit-admin',
  templateUrl: './utilisateur-edit-admin.component.html'
})
export class UtilisateurEditAdminComponent extends AbstractEditController<UtilisateurDto, UtilisateurCriteria, UtilisateurAdminService>   implements OnInit {


    private _validUtilisateurUsername = true;
    private _validUtilisateurEmail = true;




    constructor( private utilisateurService: UtilisateurAdminService ) {
        super(utilisateurService);
    }

    ngOnInit(): void {
    }


    public override setValidation(value: boolean){
        this.validUtilisateurUsername = value;
        this.validUtilisateurEmail = value;
        }
    public override validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateUtilisateurUsername();
        this.validateUtilisateurEmail();
    }
    public validateUtilisateurUsername(){
        if (this.stringUtilService.isEmpty(this.item.username)) {
            this.errorMessages.push('Username non valide');
            this.validUtilisateurUsername = false;
        } else {
            this.validUtilisateurUsername = true;
        }
    }
    public validateUtilisateurEmail(){
        if (this.stringUtilService.isEmpty(this.item.email)) {
            this.errorMessages.push('Email non valide');
            this.validUtilisateurEmail = false;
        } else {
            this.validUtilisateurEmail = true;
        }
    }






    get validUtilisateurUsername(): boolean {
        return this._validUtilisateurUsername;
    }
    set validUtilisateurUsername(value: boolean) {
        this._validUtilisateurUsername = value;
    }
    get validUtilisateurEmail(): boolean {
        return this._validUtilisateurEmail;
    }
    set validUtilisateurEmail(value: boolean) {
        this._validUtilisateurEmail = value;
    }

}
