import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {TypeContenuDto} from 'src/app/shared/model/commun/TypeContenu.model';
import {TypeContenuCriteria} from 'src/app/shared/criteria/commun/TypeContenuCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class TypeContenuAdminService extends AbstractService<TypeContenuDto, TypeContenuCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
    }

    public constrcutDto(): TypeContenuDto {
        return new TypeContenuDto();
    }

    public constrcutCriteria(): TypeContenuCriteria {
        return new TypeContenuCriteria();
    }

    get API() {
        return environment.apiUrlEmaillingservice + 'admin/typeContenu/';
    }
}
