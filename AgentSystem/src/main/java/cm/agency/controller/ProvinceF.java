package cm.agency.controller;


import cm.agency.entity.Area;
import cm.agency.entity.City;
import cm.agency.entity.Province;
import cm.agency.service.ProvinceAndCitysService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("pro")
public class ProvinceF {
    @Resource
    ProvinceAndCitysService service;

    //得到省
    @RequestMapping("get_province")
    @ResponseBody
    public List<Province> get_province(){
        List<Province> list=null;
        try {
            list= service.getProvinceList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //得到城市
    @RequestMapping("get_City")
    @ResponseBody
    public List<City> get_City(){
        List<City> list=null;
        try {
            list= service.getCitys(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //得到区
    @RequestMapping("get_Area")
    @ResponseBody
    public List<Area> get_Area(){
        List<Area> list=null;
        try {
            list= service.getAreas(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
