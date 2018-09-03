package com.example.demo.controller;

import com.example.demo.entity.Result;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by fengjinman Administrator on 2018/9/3.
 */
@Controller
public class RegistController {

    Logger log = LoggerFactory.getLogger(RegistController.class);

    @Autowired
    UserService service;


    @RequestMapping("/regist")
    public String regist(@RequestParam("username")String username,@RequestParam("password")String password){
        log.info("-------用户注册-------");
        log.info("username = "+username);
        log.info("password = "+password);
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        Result re = service.registOneUser(user);
        log.info("返回结果：re = "+re);
        if(re.getResult().equals(true)){
            return "success";
        }
        return "fail";
    }
}