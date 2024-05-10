import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {CategoryEmailDto} from 'src/app/shared/model/commun/CategoryEmail.model';
import {CategoryEmailCriteria} from 'src/app/shared/criteria/commun/CategoryEmailCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class CategoryEmailAdminService extends AbstractService<CategoryEmailDto, CategoryEmailCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
    }

    public constrcutDto(): CategoryEmailDto {
        return new CategoryEmailDto();
    }

    public constrcutCriteria(): CategoryEmailCriteria {
        return new CategoryEmailCriteria();
    }

    get API() {
        return environment.apiUrlEmaillingservice + 'admin/categoryEmail/';
    }
}
