package com.example.demo.timetask;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
/**
 异步多线程注解
 */
@Async
@Slf4j
@Component
public class ScheduledService {
    /**
     * 三种不同的定时任务
     */
//    @Scheduled(cron = "0/5 * * * * *")
//    public void scheduled(){
//        log.info("=====>>>>>使用cron  {}",System.currentTimeMillis());
//    }
//    @Scheduled(fixedRate = 5000)
//    public void scheduled1() {
//        log.info("=====>>>>>使用fixedRate{}", System.currentTimeMillis());
//    }

    /**
     * initialDelay 延迟执行
     * fixedDelay   执行间隔
     */
//    @Scheduled(fixedDelay = 5000,initialDelay = 5000)
//    public void scheduled2() {
//        log.info("=====>>>>>fixedDelay{}",System.currentTimeMillis());
//    }
}