import { OnInit } from '@angular/core';
import { Component } from '@angular/core';
import { LayoutService } from './service/app.layout.service';
import {RoleService} from "../zynerator/security/shared/service/Role.service";
import {AppComponent} from "../app.component";
import {AuthService} from "../zynerator/security/shared/service/Auth.service";
import {Router} from "@angular/router";
import {AppLayoutComponent} from "./app.layout.component";

@Component({
  selector: 'app-menu',
  templateUrl: './app.menu.component.html'
})
export class AppMenuComponent implements OnInit {
  model: any[];
  modelanonymous: any[];
    modelAdmin: any[];
constructor(public layoutService: LayoutService, public app: AppComponent, public appMain: AppLayoutComponent, private roleService: RoleService, private authService: AuthService, private router: Router) { }
  ngOnInit() {
    this.modelAdmin =
      [

				{
                    label: 'Pages',
                    icon: 'pi pi-fw pi-briefcase',
                    items: [
					  {
						label: 'Contact Management',
						icon: 'pi pi-wallet',
						items: [
								  {
									label: 'Liste contact',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/commun/contact/list']
								  },
						]
					  },
					  {
						label: 'GroupeEmail Management',
						icon: 'pi pi-wallet',
						items: [
								  {
									label: 'Liste email groupe piece joint',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/emailgroup/email-groupe-piece-joint/list']
								  },
								  {
									label: 'Liste groupe email',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/emailgroup/groupe-email/list']
								  },
								  {
									label: 'Liste email detail group',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/emailgroup/email-detail-group/list']
								  },
								  {
									label: 'Liste groupe email detail',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/emailgroup/groupe-email-detail/list']
								  },
						]
					  },
					  {
						label: 'Utilisateur Management',
						icon: 'pi pi-wallet',
						items: [
								  {
									label: 'Liste utilisateur',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/commun/utilisateur/list']
								  },
						]
					  },
					  {
						label: 'Mail Management',
						icon: 'pi pi-wallet',
						items: [
								  {
									label: 'Liste email',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/email/email/list']
								  },
								  {
									label: 'Liste email detail',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/email/email-detail/list']
								  },
								  {
									label: 'Liste etat email',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/commun/etat-email/list']
								  },
								  {
									label: 'Liste emailpiece join',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/email/emailpiece-join/list']
								  },
						]
					  },
					  {
						label: 'KeepNote Management',
						icon: 'pi pi-wallet',
						items: [
								  {
									label: 'Liste keep note',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/commun/keep-note/list']
								  },
						]
					  },
					  {
						label: 'Referentiel Management',
						icon: 'pi pi-wallet',
						items: [
								  {
									label: 'Liste type contenu',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/commun/type-contenu/list']
								  },
								  {
									label: 'Liste category email',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/commun/category-email/list']
								  },
						]
					  },

				   {
					  label: 'Security Management',
					  icon: 'pi pi-wallet',
					  items: [
						  {
							  label: 'List User',
							  icon: 'pi pi-fw pi-plus-circle',
							  routerLink: ['/app/admin/security/user/list']
						  },
						  {
							  label: 'List Model',
							  icon: 'pi pi-fw pi-plus-circle',
							  routerLink: ['/app/admin/security/model-permission/list']
						  },
						  {
							  label: 'List Action Permission',
							  icon: 'pi pi-fw pi-plus-circle',
							  routerLink: ['/app/admin/security/action-permission/list']
						  },
					  ]
				  }
			]
	    }
    ];

        if (this.authService.authenticated) {
            if (this.authService.authenticatedUser.roleUsers) {
              this.authService.authenticatedUser.roleUsers.forEach(role => {
                  const roleName: string = this.getRole(role.role.authority);
                  this.roleService._role.next(roleName.toUpperCase());
                  eval('this.model = this.model' + this.getRole(role.role.authority));
              })
            }
        }
  }

    getRole(text){
        const [role, ...rest] = text.split('_');
        return this.upperCaseFirstLetter(rest.join(''));
    }

    upperCaseFirstLetter(word: string) {
      if (!word) { return word; }
      return word[0].toUpperCase() + word.substr(1).toLowerCase();
    }

    onMenuClick(event) {
        this.appMain.onMenuClick(event);
    }
}
