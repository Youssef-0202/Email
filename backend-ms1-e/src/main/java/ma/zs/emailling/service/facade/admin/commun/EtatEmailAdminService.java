package ma.zs.emailling.service.facade.admin.commun;

import java.util.List;
import ma.zs.emailling.bean.core.commun.EtatEmail;
import ma.zs.emailling.dao.criteria.core.commun.EtatEmailCriteria;
import ma.zs.emailling.zynerator.service.IService;



public interface EtatEmailAdminService extends  IService<EtatEmail,EtatEmailCriteria>  {


    EtatEmail findByLibelle(String libelle);
}
