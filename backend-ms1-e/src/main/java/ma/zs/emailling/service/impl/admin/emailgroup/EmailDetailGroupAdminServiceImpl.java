package ma.zs.emailling.service.impl.admin.emailgroup;


import ma.zs.emailling.bean.core.emailgroup.EmailDetailGroup;
import ma.zs.emailling.dao.criteria.core.emailgroup.EmailDetailGroupCriteria;
import ma.zs.emailling.dao.facade.core.emailgroup.EmailDetailGroupDao;
import ma.zs.emailling.dao.specification.core.emailgroup.EmailDetailGroupSpecification;
import ma.zs.emailling.service.facade.admin.emailgroup.EmailDetailGroupAdminService;
import ma.zs.emailling.zynerator.service.AbstractServiceImpl;
import ma.zs.emailling.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.emailling.service.facade.admin.email.EmailAdminService ;
import ma.zs.emailling.bean.core.email.Email ;
import ma.zs.emailling.service.facade.admin.emailgroup.GroupeEmailAdminService ;
import ma.zs.emailling.bean.core.emailgroup.GroupeEmail ;

import java.util.List;
@Service
public class EmailDetailGroupAdminServiceImpl extends AbstractServiceImpl<EmailDetailGroup, EmailDetailGroupCriteria, EmailDetailGroupDao> implements EmailDetailGroupAdminService {






    public void findOrSaveAssociatedObject(EmailDetailGroup t){
        if( t != null) {
            t.setEmail(emailService.findOrSave(t.getEmail()));
            t.setDestination(groupeEmailService.findOrSave(t.getDestination()));
        }
    }

    public List<EmailDetailGroup> findByEmailId(Long id){
        return dao.findByEmailId(id);
    }
    public int deleteByEmailId(Long id){
        return dao.deleteByEmailId(id);
    }
    public long countByEmailRef(String ref){
        return dao.countByEmailRef(ref);
    }
    public List<EmailDetailGroup> findByDestinationId(Long id){
        return dao.findByDestinationId(id);
    }
    public int deleteByDestinationId(Long id){
        return dao.deleteByDestinationId(id);
    }
    public long countByDestinationId(Long id){
        return dao.countByDestinationId(id);
    }






    public void configure() {
        super.configure(EmailDetailGroup.class, EmailDetailGroupSpecification.class);
    }


    @Autowired
    private EmailAdminService emailService ;
    @Autowired
    private GroupeEmailAdminService groupeEmailService ;

    public EmailDetailGroupAdminServiceImpl(EmailDetailGroupDao dao) {
        super(dao);
    }

}
