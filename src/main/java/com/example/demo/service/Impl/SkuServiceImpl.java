package com.example.demo.service.Impl;

import com.example.demo.dao.SkuDao;
import com.example.demo.entity.Attr;
import com.example.demo.entity.Result;
import com.example.demo.entity.Sku;
import com.example.demo.entity.Spu;
import com.example.demo.service.SkuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Created by fengjinman Administrator on 2018/9/5.
 */
@Slf4j
@Service
public class SkuServiceImpl implements SkuService {

    @Autowired
    SkuDao dao;


    /**
     * 颜色和尺码列出 加选后可以查询
     */

    /**
     * 查询sku
     */
    @Override
    public List<Map<String, Object>> querySkuListByInfo(Integer spuid) {
        log.info("-------进行详细信息的数据查询(详情)------");
        List<Map<String,Object>> list = new ArrayList<>();
        List<Sku> skuList = dao.querySkuListByInfo(spuid);
        Iterator<Sku> it = skuList.iterator();
        while (it.hasNext()){
            Map<String,Object> map = new HashMap<>();
            Sku sku = it.next();
            String brand = dao.getBrand(sku.getBrandid());
            Attr attr = dao.getAttr(sku.getAttrid());
            map.put("skuname",sku.getSkuname());
            map.put("price",sku.getPrice());
            map.put("unit",sku.getUnit());
            map.put("describtion",sku.getDescribtion());
            map.put("stock_count",sku.getStock_count());
            map.put("photo",attr.getAttr_img());
            map.put("brand",brand);
            map.put("skuid",sku.getId());
            map.put("color",attr.getColor());
            map.put("size",attr.getSize());
            map.put("size_unit",attr.getSize());
            list.add(map);
        }
        log.info("-------查询结束------");
        return list;
    }

    /**
     * 查询spu
     */
    @Override
    public List<Map<String, Object>> querySpuListByLook() {
        log.info("-------查询spu(商品展示)--------");
        List<Spu> spuList = dao.querySpuListByLook();
        List<Map<String,Object>> list = new ArrayList<>();
        Iterator<Spu> it = spuList.iterator();
        while(it.hasNext()){
            Map<String,Object> map = new HashMap<>();
            Spu spu = it.next();
            String brand = dao.getBrand(spu.getBrandid());
            map.put("spuname",spu.getSpuname());
            map.put("price",spu.getPrice());
            map.put("unit",spu.getUnit());
            map.put("describtion",spu.getDescribtion());
            map.put("photo",spu.getImg());
            map.put("brand",brand);
            map.put("spuid",spu.getId());
            list.add(map);
        }
        log.info("-------查询结束--------");
        return list;
    }

    /**
     *  添加库存单元
     */
    @Override
    public Result addSku(Sku sku) {

        Result re = new Result();
        int count = dao.selectSku(sku);
        if(count>0){
            log.warn("count = "+count);
            re.setResult(false);
            re.setReason("已经存在此库存单元！");
            log.info(re.toString());
        }else{
            int num = dao.insertSku(sku);
            if(num==1){
                re.setResult(true);
            }else{
                re.setResult(false);
            }
        }
        return re;
    }
}
