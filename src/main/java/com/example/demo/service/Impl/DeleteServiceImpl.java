package com.example.demo.service.Impl;

import com.example.demo.dao.DeleteDao;
import com.example.demo.entity.Result;
import com.example.demo.service.DeleteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fengjinman Administrator on 2018/9/6.
 */
@Slf4j
@Service
public class DeleteServiceImpl implements DeleteService{


    @Autowired
    DeleteDao dao;


    @Override
    public Result deleteClass(Integer classid) {
        Result re = new Result();
        int num = dao.deleteClass(classid);
        if(num == 1){
            log.info("删除分类--"+classid+"--成功！");
            re.setResult(true);
        }else{
            log.warn("删除分类--"+classid+"--失败！");
            re.setResult(false);
        }
        return re;
    }

    @Override
    public Result deleteBrand(Integer brandid) {
        Result re = new Result();
        int num = dao.deleteBrand(brandid);
        if(num == 1){
            log.info("删除品牌--"+brandid+"--成功！");
            re.setResult(true);
        }else{
            log.warn("删除品牌--"+brandid+"--失败！");
            re.setResult(false);
        }
        return re;
    }

    @Override
    public Result deleteSpu(Integer spuid) {
        Result re = new Result();
        int num = dao.deleteSpu(spuid);
        if(num == 1){
            log.info("删除商品--"+spuid+"--成功！");
            re.setResult(true);
        }else{
            log.warn("删除商品--"+spuid+"--失败！");
            re.setResult(false);
        }
        return re;
    }

    @Override
    public Result deleteAttr(Integer attrid) {
        Result re = new Result();
        int num = dao.deleteAttr(attrid);
        if(num == 1){
            log.info("删除属性--"+attrid+"--成功！");
            re.setResult(true);
        }else{
            log.warn("删除属性--"+attrid+"--失败！");
            re.setResult(false);
        }
        return re;
    }

    @Override
    public Result deleteSku(Integer skuid) {
        Result re = new Result();
        int num = dao.deleteSku(skuid);
        if(num == 1){
            log.info("删除库存单元--"+skuid+"--成功！");
            re.setResult(true);
        }else{
            log.warn("删除库存单元--"+skuid+"--失败！");
            re.setResult(false);
        }
        return re;
    }

    @Override
    public Result deleteClassByList(List<Integer> classids) {
        Result re = new Result();
        int num = dao.deleteClassByList(classids);
        if(num == classids.size()){
            log.info("批量删除分类成功!");
            re.setResult(true);
        }else{
            log.warn("批量删除分类失败！");
            re.setResult(false);
        }
        return re;
    }

    @Override
    public Result deleteBrandByList(List<Integer> brandids) {
        Result re = new Result();
        int num = dao.deleteBrandByList(brandids);
        if(num == brandids.size()){
            log.info("批量删除品牌成功!");
            re.setResult(true);
        }else{
            log.warn("批量删除品牌失败！");
            re.setResult(false);
        }
        return re;
    }

    @Override
    public Result deleteSpuByList(List<Integer> spuids) {
        Result re = new Result();
        int num = dao.deleteSpuByList(spuids);
        if(num == spuids.size()){
            log.info("批量删除商品成功!");
            re.setResult(true);
        }else{
            log.warn("批量删除商品失败！");
            re.setResult(false);
        }
        return re;
    }

    @Override
    public Result deleteAttrByList(List<Integer> attrids) {
        Result re = new Result();
        int num = dao.deleteAttrByList(attrids);
        if(num == attrids.size()){
            log.info("批量删除属性成功!");
            re.setResult(true);
        }else{
            log.warn("批量删除属性失败！");
            re.setResult(false);
        }
        return re;
    }

    @Override
    public Result deleteSkuByList(List<Integer> skuids) {
        Result re = new Result();
        int num = dao.deleteSkuByList(skuids);
        if(num == skuids.size()){
            log.info("批量删除库存单元成功!");
            re.setResult(true);
        }else{
            log.warn("批量删除库存单元失败！");
            re.setResult(false);
        }
        return re;
    }
}
