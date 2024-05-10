import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';

export class UtilisateurCriteria  extends BaseCriteria  {

    public id: number;
    public username: string;
    public usernameLike: string;
    public password: string;
    public passwordLike: string;
    public email: string;
    public emailLike: string;
    public signature: string;
    public signatureLike: string;

}
