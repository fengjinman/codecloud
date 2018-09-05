package com.example.demo.controller;

import com.example.demo.entity.Result;
import com.example.demo.entity.Sku;
import com.example.demo.entity.User;
import com.example.demo.service.SkuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.text.DecimalFormat;

/**
 * Created by fengjinman Administrator on 2018/9/5.
 */
@Slf4j
@Controller
public class SkuController {

    @Autowired
    SkuService service;

    @RequestMapping("/makeSkuPage")
    public String makeSkuPage(){
        log.info("------前往商品发布页------");
        return "makeSku";
    }

    @Value("${photoPath}")
    String photoPath;


    @ResponseBody
    @RequestMapping(value="/upload",method = RequestMethod.POST)
    public Result upload(@RequestParam("skuname")String skuname,
                         @RequestParam("skuprice")String skuprice,
                         @RequestParam("unit")String unit,
                         @RequestParam("desc")String desc,
                         @RequestParam("img")MultipartFile img,
                         HttpSession se) throws Exception{
        log.info("------商品上传------");
        log.info("商品名称："+skuname);
        log.info("商品价格："+skuprice);
        log.info("价格单位："+unit);
        log.info("商品描述："+desc);
        log.info("图片对象："+img.toString());
        Result re = null;
        try {
            String originalFilename = img.getOriginalFilename();
            String newName = System.currentTimeMillis() + "_" + originalFilename;
            File localimg = new File(photoPath,newName);
            img.transferTo(localimg);
            log.info("-------上传完成!-----");
            User user = (User) se.getAttribute("user");
            if(user!=null){

                DecimalFormat d = new DecimalFormat("0.00");
                skuprice = d.format(Float.parseFloat(skuprice));
                Sku sku = new Sku();
//                sku.setUsername(user.getUsername());
//                sku.setSkuname(skuname);
//                sku.setSkuprice(skuprice);
//                sku.setUnit(unit);
//                sku.setDescribtion(desc);
//                sku.setImg(newName);
                re = service.addSku(sku);
            }else{
                re.setResult(false);
                re.setReason("请登录后再次操作！");
            }
        } catch (Exception e) {
            log.error("",e);
        }
        return re;
    }
}
