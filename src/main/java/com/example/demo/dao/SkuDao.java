package com.example.demo.dao;

import com.example.demo.datasource.TargetDataSource;
import com.example.demo.entity.Attr;
import com.example.demo.entity.Sku;
import com.example.demo.entity.Spu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by fengjinman Administrator on 2018/9/5.
 */
@Mapper
public interface SkuDao {

    @TargetDataSource("test2")
    int insertSku(Sku sku);

    @TargetDataSource("test2")
    int selectSku(Sku sku);


    @TargetDataSource("test2")
    List<Spu> querySpuListByLook();

    @TargetDataSource("test2")
    List<Sku> querySkuListByInfo(Integer skuid);

    @TargetDataSource("test2")
    String getPhoto(Integer spuid);

    @TargetDataSource("test2")
    String getBrand(Integer brandid);


    @TargetDataSource("test2")
    Attr getAttr(Integer attrid);


}
