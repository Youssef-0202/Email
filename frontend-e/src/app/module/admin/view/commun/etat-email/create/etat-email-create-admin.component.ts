import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {EtatEmailAdminService} from 'src/app/shared/service/admin/commun/EtatEmailAdmin.service';
import {EtatEmailDto} from 'src/app/shared/model/commun/EtatEmail.model';
import {EtatEmailCriteria} from 'src/app/shared/criteria/commun/EtatEmailCriteria.model';
@Component({
  selector: 'app-etat-email-create-admin',
  templateUrl: './etat-email-create-admin.component.html'
})
export class EtatEmailCreateAdminComponent extends AbstractCreateController<EtatEmailDto, EtatEmailCriteria, EtatEmailAdminService>  implements OnInit {



   private _validEtatEmailLibelle = true;
   private _validEtatEmailCode = true;

    constructor( private etatEmailService: EtatEmailAdminService ) {
        super(etatEmailService);
    }

    ngOnInit(): void {
    }





    public override setValidation(value: boolean){
        this.validEtatEmailLibelle = value;
        this.validEtatEmailCode = value;
    }



    public override validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateEtatEmailLibelle();
        this.validateEtatEmailCode();
    }

    public validateEtatEmailLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
        this.errorMessages.push('Libelle non valide');
        this.validEtatEmailLibelle = false;
        } else {
            this.validEtatEmailLibelle = true;
        }
    }
    public validateEtatEmailCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
        this.errorMessages.push('Code non valide');
        this.validEtatEmailCode = false;
        } else {
            this.validEtatEmailCode = true;
        }
    }






    get validEtatEmailLibelle(): boolean {
        return this._validEtatEmailLibelle;
    }

    set validEtatEmailLibelle(value: boolean) {
         this._validEtatEmailLibelle = value;
    }
    get validEtatEmailCode(): boolean {
        return this._validEtatEmailCode;
    }

    set validEtatEmailCode(value: boolean) {
         this._validEtatEmailCode = value;
    }



}
