import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {EmailGroupePieceJointDto} from 'src/app/shared/model/emailgroup/EmailGroupePieceJoint.model';
import {EmailGroupePieceJointCriteria} from 'src/app/shared/criteria/emailgroup/EmailGroupePieceJointCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class EmailGroupePieceJointAdminService extends AbstractService<EmailGroupePieceJointDto, EmailGroupePieceJointCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
    }

    public constrcutDto(): EmailGroupePieceJointDto {
        return new EmailGroupePieceJointDto();
    }

    public constrcutCriteria(): EmailGroupePieceJointCriteria {
        return new EmailGroupePieceJointCriteria();
    }

    get API() {
        return environment.apiUrlEmaillingservice + 'admin/emailGroupePieceJoint/';
    }
}
