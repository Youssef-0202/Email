import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {GroupeEmailDetailCriteria} from './GroupeEmailDetailCriteria.model';
import {UtilisateurCriteria} from '../commun/UtilisateurCriteria.model';

export class GroupeEmailCriteria  extends BaseCriteria  {

    public id: number;
    public libelle: string;
    public libelleLike: string;
  public adminGroupe: UtilisateurCriteria ;
  public adminGroupes: Array<UtilisateurCriteria> ;
      public groupeEmailDetails: Array<GroupeEmailDetailCriteria>;

}
