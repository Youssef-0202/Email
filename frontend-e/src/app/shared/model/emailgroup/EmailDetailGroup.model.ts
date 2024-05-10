import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {EmailDto} from '../email/Email.model';
import {GroupeEmailDto} from './GroupeEmail.model';

export class EmailDetailGroupDto extends BaseDto{

   public dateReception: Date;

   public dateLecture: Date;

    public email: EmailDto ;
    public destination: GroupeEmailDto ;
    

    constructor() {
        super();

        this.dateReception = null;
        this.dateLecture = null;
        this.email = new EmailDto() ;
        this.destination = new GroupeEmailDto() ;

        }

}
