package ma.zs.emailling.service.impl.admin.commun;


import ma.zs.emailling.bean.core.commun.CategoryEmail;
import ma.zs.emailling.dao.criteria.core.commun.CategoryEmailCriteria;
import ma.zs.emailling.dao.facade.core.commun.CategoryEmailDao;
import ma.zs.emailling.dao.specification.core.commun.CategoryEmailSpecification;
import ma.zs.emailling.service.facade.admin.commun.CategoryEmailAdminService;
import ma.zs.emailling.zynerator.service.AbstractServiceImpl;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryEmailAdminServiceImpl extends AbstractServiceImpl<CategoryEmail, CategoryEmailCriteria, CategoryEmailDao> implements CategoryEmailAdminService {

    @Override
    public CategoryEmail findByName(String name) {
        return dao.findByName(name);
    }

    public CategoryEmail findByReferenceEntity(CategoryEmail t){
        return t==null? null : dao.findByCode(t.getCode());
    }


    public List<CategoryEmail> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(CategoryEmail.class, CategoryEmailSpecification.class);
    }



    public CategoryEmailAdminServiceImpl(CategoryEmailDao dao) {
        super(dao);
    }

}
