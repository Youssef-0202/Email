import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {TypeContenuDto} from '../commun/TypeContenu.model';
import {GroupeEmailDto} from './GroupeEmail.model';

export class EmailGroupePieceJointDto extends BaseDto{

    public path: string;

    public taille: null | number;

    public typecontenu: TypeContenuDto ;
    public groupeEmail: GroupeEmailDto ;
    

    constructor() {
        super();

        this.path = '';
        this.taille = null;

        }

}
