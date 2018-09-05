package com.example.demo.service;

import com.example.demo.entity.Brand;
import com.example.demo.entity.Result;

/**
 * Created by fengjinman Administrator on 2018/9/5.
 */
public interface PublishService {

     Result addClass(String classname);

     Result addBrand(Brand brand);
//     Result addClass(String classname);


}
