package ma.zs.emailling.service.impl.admin.commun;


import ma.zs.emailling.bean.core.commun.TypeContenu;
import ma.zs.emailling.dao.criteria.core.commun.TypeContenuCriteria;
import ma.zs.emailling.dao.facade.core.commun.TypeContenuDao;
import ma.zs.emailling.dao.specification.core.commun.TypeContenuSpecification;
import ma.zs.emailling.service.facade.admin.commun.TypeContenuAdminService;
import ma.zs.emailling.zynerator.service.AbstractServiceImpl;
import ma.zs.emailling.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class TypeContenuAdminServiceImpl extends AbstractServiceImpl<TypeContenu, TypeContenuCriteria, TypeContenuDao> implements TypeContenuAdminService {






    public TypeContenu findByReferenceEntity(TypeContenu t){
        return t==null? null : dao.findByCode(t.getCode());
    }


    public List<TypeContenu> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(TypeContenu.class, TypeContenuSpecification.class);
    }



    public TypeContenuAdminServiceImpl(TypeContenuDao dao) {
        super(dao);
    }

}
