import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {UtilisateurDto} from '../commun/Utilisateur.model';
import {GroupeEmailDto} from './GroupeEmail.model';

export class GroupeEmailDetailDto extends BaseDto{

   public dateAjoute: Date;

   public dateBlockage: Date;

    public personne: UtilisateurDto ;
    public groupeEmail: GroupeEmailDto ;
    

    constructor() {
        super();

        this.dateAjoute = null;
        this.dateBlockage = null;
        this.personne = new UtilisateurDto() ;
        this.groupeEmail = new GroupeEmailDto() ;

        }

}
