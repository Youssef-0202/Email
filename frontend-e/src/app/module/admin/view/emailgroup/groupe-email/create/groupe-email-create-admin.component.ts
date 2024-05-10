import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {GroupeEmailAdminService} from 'src/app/shared/service/admin/emailgroup/GroupeEmailAdmin.service';
import {GroupeEmailDto} from 'src/app/shared/model/emailgroup/GroupeEmail.model';
import {GroupeEmailCriteria} from 'src/app/shared/criteria/emailgroup/GroupeEmailCriteria.model';
import {GroupeEmailDetailDto} from 'src/app/shared/model/emailgroup/GroupeEmailDetail.model';
import {GroupeEmailDetailAdminService} from 'src/app/shared/service/admin/emailgroup/GroupeEmailDetailAdmin.service';
import {UtilisateurDto} from 'src/app/shared/model/commun/Utilisateur.model';
import {UtilisateurAdminService} from 'src/app/shared/service/admin/commun/UtilisateurAdmin.service';
@Component({
  selector: 'app-groupe-email-create-admin',
  templateUrl: './groupe-email-create-admin.component.html'
})
export class GroupeEmailCreateAdminComponent extends AbstractCreateController<GroupeEmailDto, GroupeEmailCriteria, GroupeEmailAdminService>  implements OnInit {

    private _groupeEmailDetailsElement = new GroupeEmailDetailDto();


    private _validAdminGroupeUsername = true;
    private _validAdminGroupeEmail = true;

    constructor( private groupeEmailService: GroupeEmailAdminService , private groupeEmailDetailService: GroupeEmailDetailAdminService, private utilisateurService: UtilisateurAdminService) {
        super(groupeEmailService);
    }

    ngOnInit(): void {
        this.groupeEmailDetailsElement.personne = new UtilisateurDto();
        this.utilisateurService.findAll().subscribe((data) => this.personnes = data);
        this.adminGroupe = new UtilisateurDto();
        this.utilisateurService.findAll().subscribe((data) => this.adminGroupes = data);
    }



    validateGroupeEmailDetails(){
        this.errorMessages = new Array();
    }


    public override setValidation(value: boolean){
    }

    public addGroupeEmailDetails() {
        if( this.item.groupeEmailDetails == null )
            this.item.groupeEmailDetails = new Array<GroupeEmailDetailDto>();
       this.validateGroupeEmailDetails();
       if (this.errorMessages.length === 0) {
              this.item.groupeEmailDetails.push({... this.groupeEmailDetailsElement});
              this.groupeEmailDetailsElement = new GroupeEmailDetailDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs',detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
       }
    }


    public deletegroupeEmailDetails(p: GroupeEmailDetailDto) {
        this.item.groupeEmailDetails.forEach((element, index) => {
            if (element === p) { this.item.groupeEmailDetails.splice(index, 1); }
        });
    }

    public editgroupeEmailDetails(p: GroupeEmailDetailDto) {
        this.groupeEmailDetailsElement = {... p};
        this.activeTab = 0;
    }


    public override validateForm(): void{
        this.errorMessages = new Array<string>();
    }




    get adminGroupe(): UtilisateurDto {
        return this.utilisateurService.item;
    }
    set adminGroupe(value: UtilisateurDto) {
        this.utilisateurService.item = value;
    }
    get adminGroupes(): Array<UtilisateurDto> {
        return this.utilisateurService.items;
    }
    set adminGroupes(value: Array<UtilisateurDto>) {
        this.utilisateurService.items = value;
    }
    get createAdminGroupeDialog(): boolean {
       return this.utilisateurService.createDialog;
    }
    set createAdminGroupeDialog(value: boolean) {
        this.utilisateurService.createDialog= value;
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




    get validAdminGroupeUsername(): boolean {
        return this._validAdminGroupeUsername;
    }
    set validAdminGroupeUsername(value: boolean) {
        this._validAdminGroupeUsername = value;
    }
    get validAdminGroupeEmail(): boolean {
        return this._validAdminGroupeEmail;
    }
    set validAdminGroupeEmail(value: boolean) {
        this._validAdminGroupeEmail = value;
    }

    get groupeEmailDetailsElement(): GroupeEmailDetailDto {
        if( this._groupeEmailDetailsElement == null )
            this._groupeEmailDetailsElement = new GroupeEmailDetailDto();
        return this._groupeEmailDetailsElement;
    }

    set groupeEmailDetailsElement(value: GroupeEmailDetailDto) {
        this._groupeEmailDetailsElement = value;
    }

}
