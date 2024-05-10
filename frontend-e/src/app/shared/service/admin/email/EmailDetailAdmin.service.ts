import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {EmailDetailDto} from 'src/app/shared/model/email/EmailDetail.model';
import {EmailDetailCriteria} from 'src/app/shared/criteria/email/EmailDetailCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class EmailDetailAdminService extends AbstractService<EmailDetailDto, EmailDetailCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
    }

    public constrcutDto(): EmailDetailDto {
        return new EmailDetailDto();
    }

    public constrcutCriteria(): EmailDetailCriteria {
        return new EmailDetailCriteria();
    }

    get API() {
        return environment.apiUrlEmaillingservice + 'admin/emailDetail/';
    }
}
