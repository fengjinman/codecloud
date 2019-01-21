package com.example.demo.util.ffmpeg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by fengjinman on 2019/1/21.
 */
public class VideoConvert {
    private String ffmpeg = "ffmpeg";
    private List<String> cmdList;
    private static Process p;
    private String status;
    private String source;
    private String target;

    private VideoConvert() {
    }

    public VideoConvert(String ffmpegPath) {
        this.ffmpeg = ffmpegPath;
    }

    public void start(String source, String target) throws InterruptedException, FileNotFoundException {
        this.source = source;
        this.target = target;
        this.checkSource();
        this.processM3U8(source, target);
    }

    private void checkSource() throws FileNotFoundException {
        File fm = new File(this.source);
        if(!fm.exists()) {
            throw new FileNotFoundException("source不存在：" + this.source);
        }
    }

    private boolean processM3U8(String source, String target) {
        File targetFile = new File(target);
        File parentDir = targetFile.getParentFile();
        if(!parentDir.exists()) {
            parentDir.mkdirs();
        }

        List<String> commend = new ArrayList();
        commend.add(this.ffmpeg);
        commend.add("-i");
        commend.add(source);
        commend.add("-c:v");
        commend.add("libx264");
        commend.add("-hls_time");
        commend.add("60");
        commend.add("-hls_list_size");
        commend.add("0");
        commend.add("-c:a");
        commend.add("aac");
        commend.add("-strict");
        commend.add("-2");
        commend.add("-f");
        commend.add("hls");
        commend.add(target);
        this.cmdList = commend;
        runtimeBuilder(this.getCommand());
        return true;
    }

    private static boolean processBuilder(List<String> command) {
        try {
            final ProcessBuilder builder = new ProcessBuilder(command);
            builder.command(command);
            (new Thread() {
                public void run() {
                    try {
                        Process p = builder.start();
                        VideoConvert.p = p;
                    } catch (IOException var2) {
                        var2.printStackTrace();
                    }

                }
            }).start();
            return true;
        } catch (Exception var2) {
            var2.printStackTrace();
            return false;
        }
    }

    private void checkFfmpeg() throws FileNotFoundException {
        File fm = new File(this.ffmpeg);
        if(!fm.exists()) {
            throw new FileNotFoundException("ffmpeg 不存在：" + this.ffmpeg);
        }
    }

    public String getStatus() {
        if(p == null) {
            this.setStatus("no started");
        }

        if(p.isAlive()) {
            this.setStatus("processing");
        } else {
            this.setStatus("completed");
        }

        return this.status;
    }

    private static void runtimeBuilder(String cmdStr) {
        try {
            Process process = Runtime.getRuntime().exec(cmdStr);
            p = process;
            VideoThread myThread = new VideoThread(process);
            myThread.start();
        } catch (IOException var3) {
            var3.printStackTrace();
        }

    }

    private void setStatus(String status) {
        this.status = status;
    }

    public String getCommand() {
        StringBuffer bf = new StringBuffer();
        Iterator var2 = this.cmdList.iterator();

        while(var2.hasNext()) {
            String str = (String)var2.next();
            bf.append(" ").append(str);
        }

        return bf.toString();
    }

    public static class VideoStatus {
        public static final String COMPLETED = "completed";
        public static final String PROCESSING = "processing";
        public static final String NO_STARTED = "no started";

        public VideoStatus() {
        }
    }
}
