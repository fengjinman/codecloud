package com.example.demo.service;

import com.example.demo.datasource.TargetDataSource;
import com.example.demo.entity.Result;

import java.util.List;

/**
 * Created by fengjinman Administrator on 2018/9/6.
 */
public interface DeleteService {

    Result deleteClass(Integer classid);

    Result deleteBrand(Integer brandid);

    Result deleteSpu(Integer spuid);

    Result deleteAttr(Integer attrid);

    Result deleteSku(Integer skuid);

    Result deleteClassByList(List<Integer> classids);

    Result deleteBrandByList(List<Integer> brandids);

    Result deleteSpuByList(List<Integer> spuids);

    Result deleteAttrByList(List<Integer> attrids);

    Result deleteSkuByList(List<Integer> skuids);
}
