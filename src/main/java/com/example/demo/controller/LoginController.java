package com.example.demo.controller;

import com.example.demo.entity.Result;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by fengjinman Administrator on 2018/8/24.
 */
@Controller
@Slf4j
public class LoginController {

    //    使用注解代替的传统方法
    //    Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    UserService service;

    @ResponseBody
    @RequestMapping(value="/login",method= RequestMethod.POST)
    public Result login(@RequestParam("username")String username, @RequestParam("password")String password, HttpSession se, HttpServletResponse response){
        log.info("------有人登录------");
        log.info("username = "+username);
        log.info("password = "+password);
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        Result re = service.checkUser(user);
        if(re.getResult()==true){
            se.setMaxInactiveInterval(3600*3);
            se.setAttribute("user",user);
//            Cookie cookie = new Cookie("user",user.toString());
//            cookie.setPath("/");
//            cookie.setMaxAge(365*24*60);
//            response.addCookie(cookie);
//            Cookie sessionId = new Cookie("JSESESSIONID",se.getId());
//            sessionId.setPath("/");
//            sessionId.setMaxAge(60*3);
//            response.addCookie(sessionId);
        }
        log.info("返回结果：re = "+re);
        return re;
    }

    @RequestMapping("/welcome")
    public String welcome(ModelMap map){
        map.addAttribute("username","fengjinman");
        return "welcome";
    }

    @RequestMapping("/index")
    public String index(){
        log.info("----有人访问了我写的网站----");
        return "index";
    }


    @RequestMapping("/loginPage")
    public String loginPage(){
        log.info("----前往登录页----");
        return "login";
    }
}
