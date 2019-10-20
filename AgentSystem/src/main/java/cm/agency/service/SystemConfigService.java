package cm.agency.service;

import cm.agency.entity.SystemConfig;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface SystemConfigService {
	/**
	 * 显示全部系统配置信息
	 * @return 系统配置信息
	 */
	List<SystemConfig> show_all_systemConfig();
}
