import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {GroupeEmailDto} from 'src/app/shared/model/emailgroup/GroupeEmail.model';
import {GroupeEmailCriteria} from 'src/app/shared/criteria/emailgroup/GroupeEmailCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class GroupeEmailAdminService extends AbstractService<GroupeEmailDto, GroupeEmailCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
    }

    public constrcutDto(): GroupeEmailDto {
        return new GroupeEmailDto();
    }

    public constrcutCriteria(): GroupeEmailCriteria {
        return new GroupeEmailCriteria();
    }

    get API() {
        return environment.apiUrlEmaillingservice + 'admin/groupeEmail/';
    }
}
