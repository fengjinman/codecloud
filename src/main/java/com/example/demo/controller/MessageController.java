package com.example.demo.controller;
import com.example.demo.entity.Result;
import com.example.demo.service.SendMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fengjinman Administrator on 2018/8/24.
 * 短信群发的处理目前已经完成了大部分，差api的调用
 */
@Slf4j
@Controller
public class MessageController {


    @Resource
    private SendMessage sendMessage;

    /**
     * 1  跳转到短信信息填写页面
     */
    @RequestMapping("/message")
    public String message(){
        return "message";
    }

    /**
     * 2  发送短信
     */
    @ResponseBody
    @RequestMapping("/sendMessage")
    public Result sendMessage(@RequestParam("manlist")String manlist, @RequestParam("message")String message){

        log.info("-----短信发送------");
        log.info("电话号码列表："+manlist);
        log.info("短信内容："+message);
        List<String> numberList = new ArrayList<>();
        if(manlist.contains(",")){
            String[] phonenumbers = manlist.split(",");
            for(int i=0;i<phonenumbers.length;i++){
                String phonenumber = phonenumbers[i];
                numberList.add(phonenumber);
            }
        }else{
            numberList.add(manlist);
        }
        Result re = sendMessage.sendMessage(numberList, message);
        log.info("返回结果：re = "+re);
        return re;
    }




}