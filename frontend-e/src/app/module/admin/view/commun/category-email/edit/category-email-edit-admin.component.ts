import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {CategoryEmailAdminService} from 'src/app/shared/service/admin/commun/CategoryEmailAdmin.service';
import {CategoryEmailDto} from 'src/app/shared/model/commun/CategoryEmail.model';
import {CategoryEmailCriteria} from 'src/app/shared/criteria/commun/CategoryEmailCriteria.model';



@Component({
  selector: 'app-category-email-edit-admin',
  templateUrl: './category-email-edit-admin.component.html'
})
export class CategoryEmailEditAdminComponent extends AbstractEditController<CategoryEmailDto, CategoryEmailCriteria, CategoryEmailAdminService>   implements OnInit {


    private _validCategoryEmailName = true;
    private _validCategoryEmailCode = true;




    constructor( private categoryEmailService: CategoryEmailAdminService ) {
        super(categoryEmailService);
    }

    ngOnInit(): void {
    }


    public override setValidation(value: boolean){
        this.validCategoryEmailName = value;
        this.validCategoryEmailCode = value;
        }
    public override validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateCategoryEmailName();
        this.validateCategoryEmailCode();
    }
    public validateCategoryEmailName(){
        if (this.stringUtilService.isEmpty(this.item.name)) {
            this.errorMessages.push('Name non valide');
            this.validCategoryEmailName = false;
        } else {
            this.validCategoryEmailName = true;
        }
    }
    public validateCategoryEmailCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
            this.errorMessages.push('Code non valide');
            this.validCategoryEmailCode = false;
        } else {
            this.validCategoryEmailCode = true;
        }
    }






    get validCategoryEmailName(): boolean {
        return this._validCategoryEmailName;
    }
    set validCategoryEmailName(value: boolean) {
        this._validCategoryEmailName = value;
    }
    get validCategoryEmailCode(): boolean {
        return this._validCategoryEmailCode;
    }
    set validCategoryEmailCode(value: boolean) {
        this._validCategoryEmailCode = value;
    }

}
