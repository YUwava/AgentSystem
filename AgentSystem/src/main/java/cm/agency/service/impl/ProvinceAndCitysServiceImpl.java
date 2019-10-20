package cm.agency.service.impl;

import cm.agency.dao.ProvinceAndCitysMapper;
import cm.agency.entity.Area;
import cm.agency.entity.City;
import cm.agency.entity.Province;
import cm.agency.service.ProvinceAndCitysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("provinceandCitysservice")
public class ProvinceAndCitysServiceImpl implements ProvinceAndCitysService {

	@Autowired
	private ProvinceAndCitysMapper mapper;
	
	@Override
	public List<Province> getProvinceList()  throws Exception{
		// TODO Auto-generated method stub
		return mapper.getProvinceList();
	}

	@Override
	public List<City> getCitys(Province province)  throws Exception{
		// TODO Auto-generated method stub
		return mapper.getCitys(province);
	}

	@Override
	public List<Area> getAreas(City city)  throws Exception{
		// TODO Auto-generated method stub
		return mapper.getAreas(city);
	}

}
