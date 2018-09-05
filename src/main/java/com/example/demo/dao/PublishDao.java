package com.example.demo.dao;

import com.example.demo.datasource.TargetDataSource;
import com.example.demo.entity.Brand;
import com.example.demo.entity.Spu;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by fengjinman Administrator on 2018/9/5.
 */
@Mapper
public interface PublishDao {

    //分类
    @TargetDataSource("test2")
    int selectClass(String classname);

    @TargetDataSource("test2")
    int insertClass(String classname);

    //品牌
    @TargetDataSource("test2")
    int selectBrand(Brand brand);

    @TargetDataSource("test2")
    int insertBrand(Brand brand);

    //商品
    @TargetDataSource("test2")
    int selectSpu(Spu spu);

    @TargetDataSource("test2")
    int insertSpu(Spu spu);
}
