import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {KeepNoteDto} from 'src/app/shared/model/commun/KeepNote.model';
import {KeepNoteCriteria} from 'src/app/shared/criteria/commun/KeepNoteCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class KeepNoteAdminService extends AbstractService<KeepNoteDto, KeepNoteCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
    }

    public constrcutDto(): KeepNoteDto {
        return new KeepNoteDto();
    }

    public constrcutCriteria(): KeepNoteCriteria {
        return new KeepNoteCriteria();
    }

    get API() {
        return environment.apiUrlEmaillingservice + 'admin/keepNote/';
    }



    private _note:KeepNoteDto;
    private _notes:Array<KeepNoteDto>;
    private url=environment.apiUrlEmaillingservice + 'admin/keepNote/';

    public keepNote():Observable<KeepNoteDto>{
        return this.http.post<KeepNoteDto>(this.url+'keepNote',this.note);
    }


    get note(): KeepNoteDto {
        if(this._note==null){
            this._note=new KeepNoteDto();
        }
        return this._note;
    }

    set note(value: KeepNoteDto) {
        this._note = value;
    }

    get notes(): Array<KeepNoteDto> {
        if(this._notes==null){
            this._notes=new Array<KeepNoteDto>();
        }
        return this._notes;
    }

    set notes(value: Array<KeepNoteDto>) {
        this._notes = value;
    }
}
