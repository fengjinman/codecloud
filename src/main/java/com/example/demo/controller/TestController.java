package com.example.demo.controller;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.*;
/**
 * Created by fengjinman Administrator on 2018/8/22.
 */
@Controller
public class TestController {
    @Autowired
    UserDao dao;

    @ResponseBody
    @RequestMapping("/mysql")
    public Object mysql(@RequestParam("country")String country, @RequestParam("city")String city)throws Exception{
        if("zhongguo".equals(country)&&"beijing".equals(city)){
            List<User> users = dao.queryAll();
            Iterator<User> iterator = users.iterator();
            Map map = new HashMap();
            while (iterator.hasNext()){
                User user = iterator.next();
//                map.put(user.getUid(),user);
            }
            return map;
        }
        return null;
    }
    @ResponseBody
    @RequestMapping("/test")
    public Object test(){
        Map map = new HashMap<>();
        map.put("message","success");
        map.put("name","jiuliudaoke");
        map.put("age","145645646");
        map.put("kkkkk","ddddd");
        return map;
    }
    @RequestMapping("/page")
    public String page(){
        System.out.println("进来了");
        return "index";
    }
}