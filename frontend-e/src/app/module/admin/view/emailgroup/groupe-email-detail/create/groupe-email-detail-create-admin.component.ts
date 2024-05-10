import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {GroupeEmailDetailAdminService} from 'src/app/shared/service/admin/emailgroup/GroupeEmailDetailAdmin.service';
import {GroupeEmailDetailDto} from 'src/app/shared/model/emailgroup/GroupeEmailDetail.model';
import {GroupeEmailDetailCriteria} from 'src/app/shared/criteria/emailgroup/GroupeEmailDetailCriteria.model';
import {UtilisateurDto} from 'src/app/shared/model/commun/Utilisateur.model';
import {UtilisateurAdminService} from 'src/app/shared/service/admin/commun/UtilisateurAdmin.service';
import {GroupeEmailDto} from 'src/app/shared/model/emailgroup/GroupeEmail.model';
import {GroupeEmailAdminService} from 'src/app/shared/service/admin/emailgroup/GroupeEmailAdmin.service';
@Component({
  selector: 'app-groupe-email-detail-create-admin',
  templateUrl: './groupe-email-detail-create-admin.component.html'
})
export class GroupeEmailDetailCreateAdminComponent extends AbstractCreateController<GroupeEmailDetailDto, GroupeEmailDetailCriteria, GroupeEmailDetailAdminService>  implements OnInit {



    private _validPersonneUsername = true;
    private _validPersonneEmail = true;

    constructor( private groupeEmailDetailService: GroupeEmailDetailAdminService , private utilisateurService: UtilisateurAdminService, private groupeEmailService: GroupeEmailAdminService) {
        super(groupeEmailDetailService);
    }

    ngOnInit(): void {
        this.personne = new UtilisateurDto();
        this.utilisateurService.findAll().subscribe((data) => this.personnes = data);
        this.groupeEmail = new GroupeEmailDto();
        this.groupeEmailService.findAll().subscribe((data) => this.groupeEmails = data);
    }





    public override setValidation(value: boolean){
    }



    public override validateForm(): void{
        this.errorMessages = new Array<string>();
    }



    public async openCreateGroupeEmail(groupeEmail: string) {
    const isPermistted = await this.roleService.isPermitted('GroupeEmail', 'add');
    if(isPermistted) {
         this.groupeEmail = new GroupeEmailDto();
         this.createGroupeEmailDialog = true;
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
    get groupeEmail(): GroupeEmailDto {
        return this.groupeEmailService.item;
    }
    set groupeEmail(value: GroupeEmailDto) {
        this.groupeEmailService.item = value;
    }
    get groupeEmails(): Array<GroupeEmailDto> {
        return this.groupeEmailService.items;
    }
    set groupeEmails(value: Array<GroupeEmailDto>) {
        this.groupeEmailService.items = value;
    }
    get createGroupeEmailDialog(): boolean {
       return this.groupeEmailService.createDialog;
    }
    set createGroupeEmailDialog(value: boolean) {
        this.groupeEmailService.createDialog= value;
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


}
