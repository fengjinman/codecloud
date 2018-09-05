package com.example.demo.service.Impl;

import com.example.demo.dao.SkuDao;
import com.example.demo.entity.Result;
import com.example.demo.entity.Sku;
import com.example.demo.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by fengjinman Administrator on 2018/9/5.
 */
@Service
public class SkuServiceImpl implements SkuService {

    @Autowired
    SkuDao dao;

    @Override
    public Result addSku(Sku sku) {

        Result re = new Result();
        int num = dao.insertSku(sku);
        if(num==1){
            re.setResult(true);
        }else{
            re.setResult(false);
        }
        return re;
    }
}
