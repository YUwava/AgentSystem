
package cm.agency.service;

import cm.agency.entity.as_systemconfigEntity;

import java.util.List;


public interface As_systemconfigSevricee {
    /**
     * 显示所有数据
     * @return
     */
    public List<as_systemconfigEntity> FinanceShow();

    /**
     * 添加操作
     */
    public  boolean FinanceAdds(Integer configType, String configTypeName, Integer isStart);

    /**
     * 修改操作
     * @param configTypeName
     * @param isStart
     * @param id
     * @return
     */
    public  boolean updatFinace(String configTypeName, Integer isStart, Integer id);

    /**
     * 根据id删除指定数据
     * @param id
     * @return
     */
    public  boolean delteFiance(Integer id);
}
