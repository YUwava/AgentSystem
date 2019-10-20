package cm.agency.service;


import cm.agency.entity.Area;
import cm.agency.entity.City;
import cm.agency.entity.Province;

import java.util.List;


public interface ProvinceAndCitysService {

	/**
	 * getProvinceList
	 * @return
	 */
	public List<Province> getProvinceList() throws Exception;
	/**
	 * getCitys
	 * @param province
	 * @return
	 */
	public List<City> getCitys(Province province) throws Exception;
	/**
	 * getAreas
	 * @param city
	 * @return
	 */
	public List<Area> getAreas(City city) throws Exception;
}
