package com.example.demo.dao;

import com.example.demo.datasource.TargetDataSource;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by fengjinman Administrator on 2018/9/6.
 */
@Mapper
public interface DeleteDao {

    @TargetDataSource("test2")
    int deleteClass(Integer classid);

    @TargetDataSource("test2")
    int deleteBrand(Integer brandid);

    @TargetDataSource("test2")
    int deleteSpu(Integer spuid);

    @TargetDataSource("test2")
    int deleteAttr(Integer attrid);

    @TargetDataSource("test2")
    int deleteSku(Integer skuid);



    //批量
    @TargetDataSource("test2")
    int deleteClassByList(List<Integer> classids);

    @TargetDataSource("test2")
    int deleteBrandByList(List<Integer> brandids);

    @TargetDataSource("test2")
    int deleteSpuByList(List<Integer> spuids);

    @TargetDataSource("test2")
    int deleteAttrByList(List<Integer> attrids);

    @TargetDataSource("test2")
    int deleteSkuByList(List<Integer> skuids);
}
