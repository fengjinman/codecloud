package com.example.demo.controller;

import com.example.demo.entity.Result;
import com.example.demo.entity.Sku;
import com.example.demo.service.SkuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
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

//    String skuname;
//    String userid;
//    String classid;
//    String brandid;
//    String spuid;
//    String attrid;
//    String price;
//    String unit;
//    String describtion;
//    String stock_count;

    /**
     * 商品展示页数据
     */
    @ResponseBody
    @RequestMapping("/spu/look")
    public Object querySkuListByLook(){
        List<Map<String,Object>> list = service.querySpuListByLook();
        return list;
    }

    /**
     *  商品展示页
     */
    @RequestMapping("/spulook")
    public String spulook(){
        return "spulook";
    }

    /**
     * 商品详情页数据
     */
    @ResponseBody
    @RequestMapping("/sku/info")
    public Object querySkuListByInfo(Integer spuid){
        List<Map<String,Object>> list = service.querySkuListByInfo(spuid);
        return list;
    }

    /**
     *  商品详情页
     */
    @RequestMapping("/skuinfo")
    public String skuinfo(){
        return "skuinfo";
    }


    /**
     * 新建一个库存单元
     */
    @ResponseBody
    @RequestMapping(value="/add/sku")
    public Result upload(@RequestParam("skuname")String skuname,
                         @RequestParam("userid")Integer userid,
                         @RequestParam("classid")Integer classid,
                         @RequestParam("brandid")Integer brandid,
                         @RequestParam("spuid")Integer spuid,
                         @RequestParam("attrid")Integer attrid,
                         @RequestParam("price")String price,
                         @RequestParam("unit")String unit,
                         @RequestParam("describtion")String describtion,
                         @RequestParam("stock_count")String stock_count,
                         @RequestParam("stock_address")String stock_address,
                         HttpSession se) throws Exception{
        log.info("------库存单元发布------");
        log.info("名称："+skuname);
        log.info("价格："+price);
        log.info("价格单位："+unit);
        log.info("描述："+describtion);
        log.info("商家id："+userid);
        log.info("分类id："+classid);
        log.info("品牌id："+brandid);
        log.info("商品id："+spuid);
        log.info("属性id："+attrid);
        log.info("库存数量："+stock_count);
        log.info("库存地址："+stock_address);


        Sku sku = new Sku();
        sku.setSkuname(skuname);
        sku.setUserid(userid);
        sku.setClassid(classid);
        sku.setBrandid(brandid);
        sku.setSpuid(spuid);
        sku.setAttrid(attrid);
        DecimalFormat d = new DecimalFormat("0.00");
        price = d.format(Float.parseFloat(price));
        sku.setPrice(price);
        sku.setUnit(unit);
        sku.setDescribtion(describtion);
        sku.setStock_count(stock_count);
        sku.setStock_address(stock_address);

        Result re = service.addSku(sku);

        return re;
    }
}