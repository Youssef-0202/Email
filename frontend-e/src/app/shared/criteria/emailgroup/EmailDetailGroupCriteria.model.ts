import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {EmailCriteria} from '../email/EmailCriteria.model';
import {GroupeEmailCriteria} from './GroupeEmailCriteria.model';

export class EmailDetailGroupCriteria  extends BaseCriteria  {

    public id: number;
    public dateReception: Date;
    public dateReceptionFrom: Date;
    public dateReceptionTo: Date;
    public dateLecture: Date;
    public dateLectureFrom: Date;
    public dateLectureTo: Date;
  public email: EmailCriteria ;
  public emails: Array<EmailCriteria> ;
  public destination: GroupeEmailCriteria ;
  public destinations: Array<GroupeEmailCriteria> ;

}
