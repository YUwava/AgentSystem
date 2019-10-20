package cm.agency.service;

import cm.agency.entity.as_Keywords;

import java.util.List;

public interface AntistopAuditService {
    public List<as_Keywords> GetKeyWordsAllDao();

    public List<as_Keywords> GetKeyWordsDao(String keywords,  int before,  int after);


    public int counts()throws Exception;

    public int updkeywordsConditionDao(int id,int prices);

    public int updkeywordsrenew(int id,int preRegDatetime);
}
