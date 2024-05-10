import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {UtilisateurCriteria} from '../commun/UtilisateurCriteria.model';
import {GroupeEmailCriteria} from './GroupeEmailCriteria.model';

export class GroupeEmailDetailCriteria  extends BaseCriteria  {

    public id: number;
    public dateAjoute: Date;
    public dateAjouteFrom: Date;
    public dateAjouteTo: Date;
    public dateBlockage: Date;
    public dateBlockageFrom: Date;
    public dateBlockageTo: Date;
  public personne: UtilisateurCriteria ;
  public personnes: Array<UtilisateurCriteria> ;
  public groupeEmail: GroupeEmailCriteria ;
  public groupeEmails: Array<GroupeEmailCriteria> ;

}
