package cm.agency.service.impl;

import cm.agency.dao.AntistopAudit;
import cm.agency.entity.as_Keywords;
import cm.agency.service.AntistopAuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("antistopAuditService")
public class AntistopAuditServiceimpl implements AntistopAuditService {
    @Autowired
    private AntistopAudit antistopAudit;

    public AntistopAudit getAntistopAudit() {
        return antistopAudit;
    }

    public void setAntistopAudit(AntistopAudit antistopAudit) {
        this.antistopAudit = antistopAudit;
    }

    @Override
    public List<as_Keywords> GetKeyWordsAllDao() {
        return antistopAudit.GetKeyWordsAllDao();
    }

    @Override
    public List<as_Keywords> GetKeyWordsDao(String keywords, int before, int after) {
        return antistopAudit.GetKeyWordsDao(keywords,before,after);
    }

    @Override
    public int counts() throws Exception {
        return antistopAudit.counts();
    }

    @Override
    public int updkeywordsConditionDao(int id, int prices) {
        return antistopAudit.updkeywordsConditionDao(id,prices);
    }

    @Override
    public int updkeywordsrenew(int id, int preRegDatetime) {
        return antistopAudit.updkeywordsrenew(id,preRegDatetime);
    }
}
