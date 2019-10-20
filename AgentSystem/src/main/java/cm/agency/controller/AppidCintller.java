package cm.agency.controller;

import cm.agency.service.impl.Appidimpl;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.net.URI;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * url地址添加
 */
@Service
@RequestMapping("/App")
public class AppidCintller {
    @Autowired
    private Appidimpl appidimpl;

    public void setAppidimpl(Appidimpl appidimpl){
        this.appidimpl = appidimpl;
    }

    @RequestMapping("/appsele")
    public  String select(Model model){
        model.addAttribute("appl",appidimpl.appselect());
        return "AppId";
    }
    @RequestMapping("/appinset")
    public ModelAndView insert(@RequestParam("id") Integer id, @RequestParam("year") String year , ModelAndView modelAndView){
        Matcher matcher = Pattern.compile("(http://[^\\s]+)").matcher(year);
        if (matcher.find()){
        if (appidimpl.appids(year,id)){
            modelAndView.addObject("appl",appidimpl.appselect());
            modelAndView.addObject("dlet","地址保存成功");
            modelAndView.setViewName("AppId");
        }else {
            modelAndView.addObject("appl",appidimpl.appselect());
            modelAndView.addObject("dlet","地址保存失败");
            modelAndView.setViewName("AppId");
               }
        }else {
            modelAndView.addObject("appl",appidimpl.appselect());
            modelAndView.addObject("dlet","你输入的URL地址有误");
            modelAndView.setViewName("AppId");
        }
        return modelAndView;
    }
}
