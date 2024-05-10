import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {UtilisateurDto} from './Utilisateur.model';

export class ContactDto extends BaseDto{

    public name: string;

   public dateAjout: Date;

    public personneSource: UtilisateurDto ;
    public personneDestination: UtilisateurDto ;
    

    constructor() {
        super();

        this.name = '';
        this.dateAjout = null;
        this.personneSource = new UtilisateurDto() ;
        this.personneDestination = new UtilisateurDto() ;

        }

}
