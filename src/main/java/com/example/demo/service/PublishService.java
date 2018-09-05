package com.example.demo.service;

import com.example.demo.entity.Brand;
import com.example.demo.entity.Result;
import com.example.demo.entity.Spu;

/**
 * Created by fengjinman Administrator on 2018/9/5.
 */
public interface PublishService {

     Result addClass(String classname);

     Result addBrand(Brand brand);

     Result addSpu(Spu spu);


}
