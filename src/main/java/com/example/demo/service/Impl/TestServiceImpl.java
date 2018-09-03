package com.example.demo.service.Impl;

import com.example.demo.service.TestService;
import org.springframework.stereotype.Service;

/**
 * Created by fengjinman Administrator on 2018/8/23.
 */
@Service("test")
public class TestServiceImpl implements TestService {


    @Override
    public void dingshirenwu() {
        System.out.println("定时任务执行了！");
    }
}
