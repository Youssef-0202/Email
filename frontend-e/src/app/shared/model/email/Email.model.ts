import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {EtatEmailDto} from '../commun/EtatEmail.model';
import {EmailpieceJoinDto} from './EmailpieceJoin.model';
import {EmailDetailGroupDto} from '../emailgroup/EmailDetailGroup.model';
import {UtilisateurDto} from '../commun/Utilisateur.model';
import {CategoryEmailDto} from '../commun/CategoryEmail.model';
import {EmailDetailDto} from './EmailDetail.model';

export class EmailDto extends BaseDto{

    public ref: string;

   public dateEnvoi: Date;

    public corps: string;

    public header: string;

    public personneSource: UtilisateurDto ;
    public categoryEmail: CategoryEmailDto ;
    public etatEmail: EtatEmailDto ;
     public emailDetails: Array<EmailDetailDto>;
     public emailpieceJoints: Array<EmailpieceJoinDto>;
     public emailDetailGroups: Array<EmailDetailGroupDto>;
    

    constructor() {
        super();

        this.ref = '';
        this.dateEnvoi = null;
        this.corps = '';
        this.header = '';
        this.emailDetails = new Array<EmailDetailDto>();
        this.emailpieceJoints = new Array<EmailpieceJoinDto>();
        this.emailDetailGroups = new Array<EmailDetailGroupDto>();

        }

}
