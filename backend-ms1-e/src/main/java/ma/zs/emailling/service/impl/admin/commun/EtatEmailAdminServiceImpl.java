package ma.zs.emailling.service.impl.admin.commun;


import ma.zs.emailling.bean.core.commun.EtatEmail;
import ma.zs.emailling.dao.criteria.core.commun.EtatEmailCriteria;
import ma.zs.emailling.dao.facade.core.commun.EtatEmailDao;
import ma.zs.emailling.dao.specification.core.commun.EtatEmailSpecification;
import ma.zs.emailling.service.facade.admin.commun.EtatEmailAdminService;
import ma.zs.emailling.zynerator.service.AbstractServiceImpl;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EtatEmailAdminServiceImpl extends AbstractServiceImpl<EtatEmail, EtatEmailCriteria, EtatEmailDao> implements EtatEmailAdminService {






    public EtatEmail findByReferenceEntity(EtatEmail t){
        return t==null? null : dao.findByCode(t.getCode());
    }


    public List<EtatEmail> findAllOptimized() {
        return dao.findAllOptimized();
    }

    @Override
    public EtatEmail findByLibelle(String libelle) {
        return dao.findByLibelle(libelle);
    }

    public void configure() {
        super.configure(EtatEmail.class, EtatEmailSpecification.class);
    }



    public EtatEmailAdminServiceImpl(EtatEmailDao dao) {
        super(dao);
    }

}
