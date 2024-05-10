import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {GroupeEmailDetailDto} from 'src/app/shared/model/emailgroup/GroupeEmailDetail.model';
import {GroupeEmailDetailCriteria} from 'src/app/shared/criteria/emailgroup/GroupeEmailDetailCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class GroupeEmailDetailAdminService extends AbstractService<GroupeEmailDetailDto, GroupeEmailDetailCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
    }

    public constrcutDto(): GroupeEmailDetailDto {
        return new GroupeEmailDetailDto();
    }

    public constrcutCriteria(): GroupeEmailDetailCriteria {
        return new GroupeEmailDetailCriteria();
    }

    get API() {
        return environment.apiUrlEmaillingservice + 'admin/groupeEmailDetail/';
    }
}
