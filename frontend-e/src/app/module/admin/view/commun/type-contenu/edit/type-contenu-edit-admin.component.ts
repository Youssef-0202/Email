import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {TypeContenuAdminService} from 'src/app/shared/service/admin/commun/TypeContenuAdmin.service';
import {TypeContenuDto} from 'src/app/shared/model/commun/TypeContenu.model';
import {TypeContenuCriteria} from 'src/app/shared/criteria/commun/TypeContenuCriteria.model';



@Component({
  selector: 'app-type-contenu-edit-admin',
  templateUrl: './type-contenu-edit-admin.component.html'
})
export class TypeContenuEditAdminComponent extends AbstractEditController<TypeContenuDto, TypeContenuCriteria, TypeContenuAdminService>   implements OnInit {


    private _validTypeContenuLibelle = true;
    private _validTypeContenuCode = true;




    constructor( private typeContenuService: TypeContenuAdminService ) {
        super(typeContenuService);
    }

    ngOnInit(): void {
    }


    public override setValidation(value: boolean){
        this.validTypeContenuLibelle = value;
        this.validTypeContenuCode = value;
        }
    public override validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateTypeContenuLibelle();
        this.validateTypeContenuCode();
    }
    public validateTypeContenuLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
            this.errorMessages.push('Libelle non valide');
            this.validTypeContenuLibelle = false;
        } else {
            this.validTypeContenuLibelle = true;
        }
    }
    public validateTypeContenuCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
            this.errorMessages.push('Code non valide');
            this.validTypeContenuCode = false;
        } else {
            this.validTypeContenuCode = true;
        }
    }






    get validTypeContenuLibelle(): boolean {
        return this._validTypeContenuLibelle;
    }
    set validTypeContenuLibelle(value: boolean) {
        this._validTypeContenuLibelle = value;
    }
    get validTypeContenuCode(): boolean {
        return this._validTypeContenuCode;
    }
    set validTypeContenuCode(value: boolean) {
        this._validTypeContenuCode = value;
    }

}
