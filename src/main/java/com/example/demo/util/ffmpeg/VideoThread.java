package com.example.demo.util.ffmpeg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by fengjinman on 2019/1/21.
 */
public class VideoThread extends Thread {
    private static final Logger log = LoggerFactory.getLogger(VideoThread.class);
    private Process p;

    public VideoThread(Process p) {
        this.p = p;
    }

    public void run() {
        BufferedReader err = new BufferedReader(new InputStreamReader(this.p.getErrorStream()));
        String line = null;

        try {
            while((line = err.readLine()) != null) {
                log.info(line);
            }
        } catch (IOException var16) {
            var16.printStackTrace();
        } finally {
            try {
                err.close();

                try {
                    this.p.waitFor();
                    this.p.destroy();
                    log.info("video convert completed...");
                } catch (InterruptedException var14) {
                    var14.printStackTrace();
                }
            } catch (IOException var15) {
                var15.printStackTrace();
            }

        }

    }
}
