import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {UtilisateurDto} from 'src/app/shared/model/commun/Utilisateur.model';
import {UtilisateurCriteria} from 'src/app/shared/criteria/commun/UtilisateurCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class UtilisateurAdminService extends AbstractService<UtilisateurDto, UtilisateurCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
    }

    public constrcutDto(): UtilisateurDto {
        return new UtilisateurDto();
    }

    public constrcutCriteria(): UtilisateurCriteria {
        return new UtilisateurCriteria();
    }

    get API() {
        return environment.apiUrlEmaillingservice + 'admin/utilisateur/';
    }
}
