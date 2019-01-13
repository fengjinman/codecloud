package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by fengjinman on 2019/1/13.
 */
@Controller
public class IndexController {

    @ResponseBody
    @RequestMapping("/loginPage")
    public String index(){
        return "index";
    }
}
