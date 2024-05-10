import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {EmailDto} from 'src/app/shared/model/email/Email.model';
import {EmailCriteria} from 'src/app/shared/criteria/email/EmailCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class EmailAdminService extends AbstractService<EmailDto, EmailCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
    }

    public constrcutDto(): EmailDto {
        return new EmailDto();
    }

    public constrcutCriteria(): EmailCriteria {
        return new EmailCriteria();
    }

    get API() {
        return environment.apiUrlEmaillingservice + 'admin/email/';
    }
}
