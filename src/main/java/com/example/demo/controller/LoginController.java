package com.example.demo.controller;

import com.example.demo.entity.Result;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * Created by fengjinman Administrator on 2018/8/24.
 */
@Controller
@Slf4j
public class LoginController {

//    Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    UserService service;

    @RequestMapping("/login")
    public String login(@RequestParam("username")String username, @RequestParam("password")String password, ModelMap map){

        log.info("------有人登录------");
        log.info("username = "+username);
        log.info("password = "+password);
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        Result re = service.checkUser(user);
        log.info("返回结果：re = "+re);
        if(re.getResult().equals(true)){
            map.put("user",user);
            return "welcome";
        }else{
            return "index";
        }
    }
}
