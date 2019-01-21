package com.example.demo.controller;

import com.example.demo.util.ffmpeg.ProcessVideo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * Created by fengjinman on 2019/1/13.
 */
@Controller
public class IndexController {

    @RequestMapping("/videoPage")
    public String index(){
        return "video";
    }

    @RequestMapping("/updownload/upload")
    @ResponseBody
    public boolean upload(@RequestParam("myFile")MultipartFile file)throws Exception{
        String name = file.getOriginalFilename();
        System.out.println(name);
        file.transferTo(new File("F:\\e",name));
        System.out.println("上传到本地");
        ProcessVideo video = new ProcessVideo("F:\\e", "F:\\e", name, "C:\\Users\\Administrator\\Desktop\\fengjinman\\package\\ffmpeg\\bin\\ffmpeg.exe");
        System.out.println("开始解析！");
        video.run();
        return true;
    }
}
