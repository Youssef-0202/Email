import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {EmailDto} from './Email.model';
import {TypeContenuDto} from '../commun/TypeContenu.model';

export class EmailpieceJoinDto extends BaseDto{

    public path: string;

    public taille: string;

    public email: EmailDto ;
    public typeContenu: TypeContenuDto ;
    

    constructor() {
        super();

        this.path = '';
        this.taille = '';
        this.email = new EmailDto() ;
        this.typeContenu = new TypeContenuDto() ;

        }

}
