import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class CategoryEmailDto extends BaseDto{

    public name: string;

    public code: string;

    

    constructor() {
        super();

        this.name = '';
        this.code = '';

        }

}
