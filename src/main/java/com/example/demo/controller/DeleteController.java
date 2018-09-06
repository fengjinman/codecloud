package com.example.demo.controller;
import com.example.demo.entity.Result;
import com.example.demo.service.DeleteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by fengjinman Administrator on 2018/9/6.
 */
@Slf4j
@RestController
@RequestMapping("/delete")
public class DeleteController {

    @Autowired
    DeleteService service;


    @RequestMapping("/class")
    public Result deleteClass(Integer classid){
        return service.deleteClass(classid);
    }
    @RequestMapping("/brand")
    public Result deleteBrand(Integer brandid){
        return service.deleteClass(brandid);
    }
    @RequestMapping("/spu")
    public Result deleteSpu(Integer spuid){
        return service.deleteClass(spuid);
    }
    @RequestMapping("/attr")
    public Result deleteAttr(Integer attrid){
        return service.deleteClass(attrid);
    }
    @RequestMapping("/sku")
    public Result deleteSku(Integer skuid){
        return service.deleteClass(skuid);
    }

    @RequestMapping("/class/list")
    public Result deleteClassByList(String ids){

        List<Integer> idList = getIds(ids);

        return service.deleteClassByList(idList);
    }
    @RequestMapping("/brand/list")
    public Result deleteBrandByList(String ids){

        List<Integer> idList = getIds(ids);

        return service.deleteBrandByList(idList);
    }
    @RequestMapping("/spu/list")
    public Result deleteSpuByList(String ids){

        List<Integer> idList = getIds(ids);

        return service.deleteSpuByList(idList);
    }
    @RequestMapping("/attr/list")
    public Result deleteAttrByList(String ids){

        List<Integer> idList = getIds(ids);

        return service.deleteAttrByList(idList);
    }
    @RequestMapping("/sku/list")
    public Result deleteSkuByList(String ids){

        List<Integer> idList = getIds(ids);

        return service.deleteSkuByList(idList);
    }

    public List<Integer> getIds(String ids){

        List<Integer> idList = new ArrayList<>();

        if(ids.indexOf(",")!=-1){
            String[] idArray = ids.split(",");
            for(int i =0;i<idArray.length;i++){
                try {
                    String idString = idArray[i];
                    int id = Integer.parseInt(idString);
                    idList.add(id);
                } catch (Exception e) {
                    log.error("",e);
                }
            }
        }else{
            try {
                int id = Integer.parseInt(ids);
                idList.add(id);
            } catch (Exception e) {
                log.error("",e);
            }
        }

        return idList;

    }

}
