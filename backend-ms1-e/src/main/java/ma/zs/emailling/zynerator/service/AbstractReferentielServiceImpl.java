package ma.zs.emailling.zynerator.service;

import ma.zs.emailling.zynerator.audit.AuditBusinessObjectEnhanced;
import ma.zs.emailling.zynerator.criteria.BaseCriteria;
import ma.zs.emailling.zynerator.repository.AbstractRepository;

public abstract class AbstractReferentielServiceImpl<T extends AuditBusinessObjectEnhanced, CRITERIA extends BaseCriteria, REPO extends AbstractRepository<T, Long>> extends AbstractServiceImpl<T, CRITERIA, REPO> {

    public AbstractReferentielServiceImpl(REPO dao) {
        super(dao);
    }

}
