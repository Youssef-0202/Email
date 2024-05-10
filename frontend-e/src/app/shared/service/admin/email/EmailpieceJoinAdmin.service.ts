import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {EmailpieceJoinDto} from 'src/app/shared/model/email/EmailpieceJoin.model';
import {EmailpieceJoinCriteria} from 'src/app/shared/criteria/email/EmailpieceJoinCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class EmailpieceJoinAdminService extends AbstractService<EmailpieceJoinDto, EmailpieceJoinCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
    }

    public constrcutDto(): EmailpieceJoinDto {
        return new EmailpieceJoinDto();
    }

    public constrcutCriteria(): EmailpieceJoinCriteria {
        return new EmailpieceJoinCriteria();
    }

    get API() {
        return environment.apiUrlEmaillingservice + 'admin/emailpieceJoin/';
    }
}
