import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {EmailDetailGroupDto} from 'src/app/shared/model/emailgroup/EmailDetailGroup.model';
import {EmailDetailGroupCriteria} from 'src/app/shared/criteria/emailgroup/EmailDetailGroupCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class EmailDetailGroupAdminService extends AbstractService<EmailDetailGroupDto, EmailDetailGroupCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
    }

    public constrcutDto(): EmailDetailGroupDto {
        return new EmailDetailGroupDto();
    }

    public constrcutCriteria(): EmailDetailGroupCriteria {
        return new EmailDetailGroupCriteria();
    }

    get API() {
        return environment.apiUrlEmaillingservice + 'admin/emailDetailGroup/';
    }
}
