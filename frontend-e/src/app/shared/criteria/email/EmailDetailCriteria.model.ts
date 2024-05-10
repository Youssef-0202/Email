import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {EtatEmailCriteria} from '../commun/EtatEmailCriteria.model';
import {EmailCriteria} from './EmailCriteria.model';
import {UtilisateurCriteria} from '../commun/UtilisateurCriteria.model';

export class EmailDetailCriteria  extends BaseCriteria  {

    public id: number;
    public dateLecture: Date;
    public dateLectureFrom: Date;
    public dateLectureTo: Date;
    public dateReception: Date;
    public dateReceptionFrom: Date;
    public dateReceptionTo: Date;
  public email: EmailCriteria ;
  public emails: Array<EmailCriteria> ;

}
