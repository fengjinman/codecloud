package com.example.demo.controller;

import com.example.demo.entity.Attr;
import com.example.demo.entity.Brand;
import com.example.demo.entity.Result;
import com.example.demo.entity.Spu;
import com.example.demo.service.PublishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * Created by fengjinman Administrator on 2018/9/5.
 */
@Slf4j
@RestController
@RequestMapping("/publish")
public class PublishController {

    @Autowired
    PublishService service;

    /**
     *  上传到服务器上的存储路径  在配置文件中分为本地和线上两种 需要切换
     */
    @Value("${photoPath}")
    String photoPath;


    /**
     *  1 新加一个分类
     */
    @RequestMapping("/class")
    public Result publishClass(String classname){
        Result re = service.addClass(classname);
        return re;
    }

    /**
     *  2 新加一个品牌
     */
    @RequestMapping("/brand")
    public Result publishBrand(@RequestParam("classid")Integer classid,
                               @RequestParam("brandname")String brandname){
        Brand brand = new Brand();
        brand.setClassid(classid);
        brand.setBrandname(brandname);
        Result re = service.addBrand(brand);
        return re;
    }

    /**
     *  3 新加一个商品
     */
    @RequestMapping("/spu")
    public Result publishSpu(@RequestParam("brandid")Integer brandid,
                             @RequestParam("classid")Integer classid,
                             @RequestParam("spuname")String spuname,
                             @RequestParam("describtion")String describtion,
                             @RequestParam("price")String price,
                             @RequestParam("unit")String unit,
                             @RequestParam("img")MultipartFile img){
        String originalFilename = img.getOriginalFilename();
        String spu_img = System.currentTimeMillis()+"_spu_"+originalFilename;
        File file = new File(photoPath,spu_img);
        try {
            img.transferTo(file);
            log.info("-------商品图片上传成功！-------");
        } catch (Exception e) {
            log.error("",e);
        }
        Spu spu = new Spu();
        spu.setBrandid(brandid);
        spu.setClassid(classid);
        spu.setSpuname(spuname);
        spu.setDescribtion(describtion);
        spu.setPrice(price);
        spu.setUnit(unit);
        spu.setImg(spu_img);

        Result re = service.addSpu(spu);
        return re;
    }


    /**
     *  4 新加一个属性
     */
    @RequestMapping("/attr")
    public Result publishAttr(@RequestParam("spuid")Integer spuid,
                              @RequestParam("color")String color,
                              @RequestParam("size")String size,
                              @RequestParam("size_unit")String size_unit,
                              @RequestParam("img")MultipartFile img){
        String originalFilename = img.getOriginalFilename();
        String attr_img = System.currentTimeMillis()+"_attr_"+originalFilename;
        File file = new File(photoPath,attr_img);
        try {
            img.transferTo(file);
            log.info("-------属性图片上传成功！-------");
        } catch (Exception e) {
            log.error("",e);
        }
        Attr attr = new Attr();
        attr.setSpuid(spuid);
        attr.setColor(color);
        attr.setAttr_img(attr_img);
        attr.setSize(size);
        attr.setSize_unit(size_unit);

        return service.addAttr(attr);
    }
}
