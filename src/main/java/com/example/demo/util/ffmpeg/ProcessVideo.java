package com.example.demo.util.ffmpeg;

import lombok.extern.slf4j.Slf4j;

import java.io.File;


/**
 * Created by fengjinman on 2018/12/3.
 */
@Slf4j
public class ProcessVideo extends Thread {

    private String source;
    private String target;
    private String fileName;
    private String ffmpeg;
    private VideoConvert videoConvert;

    public ProcessVideo(String source, String target, String fileName, String ffmpeg){
        this.source = source;
        this.target = target;
        this.fileName = fileName;
        this.ffmpeg = ffmpeg;
    }

    @Override
    public void run() {
        VideoConvert convert = new VideoConvert(ffmpeg);
        String sourceFile = source + "/" +fileName;
        log.info("fileName============="+fileName);
        String nameStr = fileName;
        log.info("nameStr============="+nameStr);
        String[] split = nameStr.split("\\.");
        log.info("长度是=============="+split.length);
        log.info("资源路径================"+sourceFile);
        File file = new File(sourceFile);
        long length = file.length();
        log.info("length==="+length);
        long l = length / 1024 / 1024;
        log.info("此文件的大小是===="+l+"M");
        log.info("split======="+split);
        String name = split[0];
        String videoList = target + "/" + name + ".m3u8";
        log.info("目标路径================"+videoList);
        try {
            convert.start(sourceFile, videoList);
        }catch (Exception e){
            e.printStackTrace();
            log.error("",e);
        }
        videoConvert = convert;
        log.info("分割视频方法最后一行");
    }
}
