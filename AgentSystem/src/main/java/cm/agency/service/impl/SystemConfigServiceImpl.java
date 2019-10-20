package cm.agency.service.impl;

import cm.agency.dao.SystemConfigMapper;
import cm.agency.entity.SystemConfig;
import cm.agency.service.SystemConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("systemConfigService")
public class SystemConfigServiceImpl implements SystemConfigService {
	@Autowired
	private SystemConfigMapper systemConfigMapper;

	public void setMapper(SystemConfigMapper systemConfigMapper) {
		this.systemConfigMapper = systemConfigMapper;
	}

	@Override
	public List<SystemConfig> show_all_systemConfig() {
		return systemConfigMapper.getSelect_All_SystemConfig();
	}

}
