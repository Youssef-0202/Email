import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {EtatEmailDto} from '../commun/EtatEmail.model';
import {EmailDto} from './Email.model';
import {UtilisateurDto} from '../commun/Utilisateur.model';

export class EmailDetailDto extends BaseDto{

   public dateLecture: Date;

   public dateReception: Date;

    public email: EmailDto ;
    public personneDestinataire: UtilisateurDto ;
    public etatEmail: EtatEmailDto ;
    

    constructor() {
        super();

        this.dateLecture = null;
        this.dateReception = null;
        this.email = new EmailDto() ;

        }

}
