import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {TypeContenuCriteria} from '../commun/TypeContenuCriteria.model';
import {GroupeEmailCriteria} from './GroupeEmailCriteria.model';

export class EmailGroupePieceJointCriteria  extends BaseCriteria  {

    public id: number;
    public path: string;
    public pathLike: string;
     public taille: number;
     public tailleMin: number;
     public tailleMax: number;

}
