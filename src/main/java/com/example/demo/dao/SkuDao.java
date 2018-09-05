package com.example.demo.dao;

import com.example.demo.datasource.TargetDataSource;
import com.example.demo.entity.Sku;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by fengjinman Administrator on 2018/9/5.
 */
@Mapper
public interface SkuDao {

    @TargetDataSource("test2")
    int insertSku(Sku sku);
}
