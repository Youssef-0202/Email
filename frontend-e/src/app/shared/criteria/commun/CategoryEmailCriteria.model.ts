import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';

export class CategoryEmailCriteria  extends BaseCriteria  {

    public id: number;
    public name: string;
    public nameLike: string;
    public code: string;
    public codeLike: string;

}
