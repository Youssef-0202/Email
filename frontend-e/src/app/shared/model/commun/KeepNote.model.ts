import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {UtilisateurDto} from './Utilisateur.model';

export class KeepNoteDto extends BaseDto{

    public body: string;

    public header: string;

   public dateKeepNote: Date;

    public personne: UtilisateurDto ;
    

    constructor() {
        super();

        this.body = '';
        this.header = '';
        this.dateKeepNote = null;

        }

}
