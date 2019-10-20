package cm.agency.dao;

import cm.agency.entity.SystemConfig;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SystemConfigMapper {
	/**
	 * 查询全部系统配置信息
	 * @return 系统配置信息
	 */
	List<SystemConfig> getSelect_All_SystemConfig();

}
