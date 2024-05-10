import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {EtatEmailDto} from 'src/app/shared/model/commun/EtatEmail.model';
import {EtatEmailCriteria} from 'src/app/shared/criteria/commun/EtatEmailCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class EtatEmailAdminService extends AbstractService<EtatEmailDto, EtatEmailCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
    }

    public constrcutDto(): EtatEmailDto {
        return new EtatEmailDto();
    }

    public constrcutCriteria(): EtatEmailCriteria {
        return new EtatEmailCriteria();
    }

    get API() {
        return environment.apiUrlEmaillingservice + 'admin/etatEmail/';
    }
}
