package cm.agency.dao;

import cm.agency.entity.as_Keywords;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AntistopAudit {
    /**
     * 查询所有的关键词
     * @return
     */
    public List<as_Keywords> GetKeyWordsAllDao();
    /**
     * 查询所有的关键词
     * 和根据条件查询关键词
     * @param keywords
     * @param before
     * @param after
     * @return
     */
    public List<as_Keywords> GetKeyWordsDao(@Param("keywords")String keywords, @Param("before") int before, @Param("after") int after);

    /**
     * 查询条数
     * @return
     * @throws Exception
     */
    public int counts()throws Exception;


    /**
     * 根据prices的值进行修改
     * @param id
     * @param prices
     * @return
     */
    public int updkeywordsConditionDao(@Param("id")int id,@Param("prices")int prices);

    /**
     * 修改到期日期
     * @param id
     * @param preRegDatetime
     * @return
     */
    public int updkeywordsrenew(@Param("id")int id,@Param("preRegDatetime")int preRegDatetime);

}
