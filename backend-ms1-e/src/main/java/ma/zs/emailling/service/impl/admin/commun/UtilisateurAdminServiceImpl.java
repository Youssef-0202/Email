package ma.zs.emailling.service.impl.admin.commun;


import ma.zs.emailling.bean.core.commun.Utilisateur;
import ma.zs.emailling.dao.criteria.core.commun.UtilisateurCriteria;
import ma.zs.emailling.dao.facade.core.commun.ContactDao;
import ma.zs.emailling.dao.facade.core.commun.UtilisateurDao;
import ma.zs.emailling.dao.specification.core.commun.UtilisateurSpecification;
import ma.zs.emailling.service.facade.admin.commun.UtilisateurAdminService;
import ma.zs.emailling.zynerator.service.AbstractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurAdminServiceImpl extends AbstractServiceImpl<Utilisateur, UtilisateurCriteria, UtilisateurDao> implements UtilisateurAdminService {

    @Override
    public Utilisateur findByUsername(String username) {
        return dao.findByUsername(username);
    }
    @Override
    public Utilisateur findByEmail(String email) {
        return dao.findByEmail(email);
    }

    public Utilisateur findByReferenceEntity(Utilisateur t){
        return t==null? null : dao.findByUsername(t.getUsername());
    }


    public List<Utilisateur> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Utilisateur.class, UtilisateurSpecification.class);
    }



    public UtilisateurAdminServiceImpl(UtilisateurDao dao) {
        super(dao);
    }

    @Override
    public Utilisateur save(Utilisateur utilisateur) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String hashedPassword = encoder.encode(utilisateur.getPassword());
        utilisateur.setPassword(hashedPassword);
        return dao.save(utilisateur);
    }




    @Autowired
    private ContactDao contactDao;







}
