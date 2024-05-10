import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {EmailCriteria} from './EmailCriteria.model';
import {TypeContenuCriteria} from '../commun/TypeContenuCriteria.model';

export class EmailpieceJoinCriteria  extends BaseCriteria  {

    public id: number;
    public path: string;
    public pathLike: string;
    public taille: string;
    public tailleLike: string;
  public email: EmailCriteria ;
  public emails: Array<EmailCriteria> ;
  public typeContenu: TypeContenuCriteria ;
  public typeContenus: Array<TypeContenuCriteria> ;

}
