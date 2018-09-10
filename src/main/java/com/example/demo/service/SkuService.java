package com.example.demo.service;

import com.example.demo.entity.Result;
import com.example.demo.entity.Sku;

import java.util.List;
import java.util.Map;

/**
 * Created by fengjinman Administrator on 2018/9/5.
 */
public interface SkuService {

    /**
     *  添加一个库存单元
     */
    Result addSku(Sku sku);

    /**
     *  批量查询商品  用于商品展示页面预加载
     */
    List<Map<String,Object>> querySpuListByLook();

    /**
     *  批量查询sku  用于商品详情页面预加载
     */
    List<Map<String,Object>> querySkuListByInfo(Integer spuid);
}
