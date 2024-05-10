import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {EtatEmailCriteria} from '../commun/EtatEmailCriteria.model';
import {EmailpieceJoinCriteria} from './EmailpieceJoinCriteria.model';
import {EmailDetailGroupCriteria} from '../emailgroup/EmailDetailGroupCriteria.model';
import {UtilisateurCriteria} from '../commun/UtilisateurCriteria.model';
import {CategoryEmailCriteria} from '../commun/CategoryEmailCriteria.model';
import {EmailDetailCriteria} from './EmailDetailCriteria.model';

export class EmailCriteria  extends BaseCriteria  {

    public id: number;
    public ref: string;
    public refLike: string;
    public dateEnvoi: Date;
    public dateEnvoiFrom: Date;
    public dateEnvoiTo: Date;
    public corps: string;
    public corpsLike: string;
    public header: string;
    public headerLike: string;
      public emailDetails: Array<EmailDetailCriteria>;
      public emailpieceJoints: Array<EmailpieceJoinCriteria>;
      public emailDetailGroups: Array<EmailDetailGroupCriteria>;

}
