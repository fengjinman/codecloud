package com.example.demo.service;

import com.example.demo.entity.Result;
import com.example.demo.entity.Sku;

import java.util.List;
import java.util.Map;

/**
 * Created by fengjinman Administrator on 2018/9/5.
 */
public interface SkuService {

    Result addSku(Sku sku);

    List<Map<String,Object>> querySpuListByLook();

    List<Map<String,Object>> querySkuListByInfo(Integer spuid);
}
