import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class UtilisateurDto extends BaseDto{

    public username: string;

    public password: string;

    public email: string;

    public signature: string;

    

    constructor() {
        super();

        this.username = '';
        this.password = '';
        this.email = '';
        this.signature = '';

        }

}
