package com.example.demo.controller;

import com.example.demo.entity.Brand;
import com.example.demo.entity.Result;
import com.example.demo.service.PublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by fengjinman Administrator on 2018/9/5.
 */
@Controller
@RequestMapping("/publish")
public class PublishController {

    @Autowired
    PublishService service;

    @RequestMapping("/class")
    public Result publishClass(String classname){
        Result re = service.addClass(classname);
        return re;
    }

    @RequestMapping("/brand")
    public Result publishClass(@RequestParam("classid")Integer classid,@RequestParam("brandname")String brandname){
        Brand brand = new Brand();
        brand.setClassid(classid);
        brand.setBrandname(brandname);
        Result re = service.addBrand(brand);
        return re;
    }
}
