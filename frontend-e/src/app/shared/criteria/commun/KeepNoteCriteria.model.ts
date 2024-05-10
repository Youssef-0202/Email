import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {UtilisateurCriteria} from './UtilisateurCriteria.model';

export class KeepNoteCriteria  extends BaseCriteria  {

    public id: number;
    public body: string;
    public bodyLike: string;
    public header: string;
    public headerLike: string;
    public dateKeepNote: Date;
    public dateKeepNoteFrom: Date;
    public dateKeepNoteTo: Date;

}
