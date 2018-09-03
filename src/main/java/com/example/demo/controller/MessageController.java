package com.example.demo.controller;
import com.example.demo.service.SendMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Created by fengjinman Administrator on 2018/8/24.
 * 短信群发的处理目前已经完成了大部分，差api的调用
 */
@Controller
public class MessageController {
    @Resource
    private SendMessage sendMessage;
//    @RequestMapping("/sendMessage")
//    public ModelAndView sendMessage(@RequestParam("manlist")String manlist, @RequestParam("message")String message){
//        List<String> numberList = new ArrayList<>();
//        if(manlist.contains(",")){
//            String[] phonenumbers = manlist.split(",");
//            for(int i=0;i<phonenumbers.length;i++){
//                String phonenumber = phonenumbers[i];
//                numberList.add(phonenumber);
//            }
//        }else{
//            numberList.add(manlist);
//        }
//        String result = sendMessage.sendMessage(numberList, message);
//        ModelAndView modelAndView = new ModelAndView();
//        if("success".equals(result)){
//            modelAndView.setViewName("success");
//        }else{
//            modelAndView.getModel().put("reason",result);
//            modelAndView.setViewName("fail");
//        }
//        return modelAndView;
//    }
    @RequestMapping("/sendMessage")
    public String sendMessage(@RequestParam("manlist")String manlist, @RequestParam("message")String message, HttpSession session){
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
        String result = sendMessage.sendMessage(numberList, message);
//        ModelAndView modelAndView = new ModelAndView();
        if("success".equals(result)){
//            modelAndView.setViewName("success");
            return "success";
        }else{
//            modelAndView.getModel().put("reason",result);
//            modelAndView.setViewName("fail");
            session.setAttribute("reason",result);
            return "fail";
        }
    }
    @RequestMapping("/message")
    public String message(){
        return "message";
    }
    @ResponseBody
    @RequestMapping("/yy")
    public Object getReason(){
        Map result = new HashMap<>();
        result.put("result","success");
        result.put("reason","服务暂未开启！");
        System.out.println("数据返回");
        return result;
    }
}