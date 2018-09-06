package com.example.demo.service.Impl;

import com.example.demo.dao.PublishDao;
import com.example.demo.entity.Attr;
import com.example.demo.entity.Brand;
import com.example.demo.entity.Result;
import com.example.demo.entity.Spu;
import com.example.demo.service.PublishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by fengjinman Administrator on 2018/9/5.
 */
@Slf4j
@Service
public class PublishServiceImpl implements PublishService{
    @Autowired
    PublishDao dao;

    @Override
    public Result addAttr(Attr attr) {
        Result re = new Result();
        int count = dao.selectAttr(attr);
        if(count>0){
            log.warn("count = "+count);
            re.setResult(false);
            re.setReason("已经存在此属性！");
            log.info(re.toString());
        }else{
            int num = dao.insertAttr(attr);
            if(num==1){
                re.setResult(true);
            }else{
                re.setResult(false);
            }
        }
        return re;
    }

    @Override
    public Result addSpu(Spu spu) {
        Result re = new Result();
        int count = dao.selectSpu(spu);
        if(count>0){
            log.warn("count = "+count);
            re.setResult(false);
            re.setReason("已经存在此商品！");
            log.info(re.toString());
        }else{
            int num = dao.insertSpu(spu);
            if(num==1){
                re.setResult(true);
            }else{
                re.setResult(false);
            }
        }
        return re;
    }


    @Override
    public Result addBrand(Brand brand) {
        Result re = new Result();
        int count = dao.selectBrand(brand);
        if(count>0){
            log.warn("count = "+count);
            re.setResult(false);
            re.setReason("已经存在此品牌！");
            log.info(re.toString());
        }else{
            int num = dao.insertBrand(brand);
            if(num==1){
                re.setResult(true);
            }else{
                re.setResult(false);
            }
        }
        return re;
    }



    @Override
    public Result addClass(String classname) {
        Result re = new Result();
        int count = dao.selectClass(classname);
        if(count>0){
            log.warn("count = "+count);
           re.setResult(false);
           re.setReason("已经存在此分类！");
           log.info(re.toString());
        }else{
            int num = dao.insertClass(classname);
            if(num==1){
                re.setResult(true);
            }else{
                re.setResult(false);
            }
        }
        return re;
    }
}
