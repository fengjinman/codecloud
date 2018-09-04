package com.example.demo.service.Impl;

import com.example.demo.entity.Result;
import com.example.demo.service.SendEmail;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fengjinman Administrator on 2018/9/4.
 */
@Service
public class SendEmailImpl implements SendEmail {

    @Override
    public Result SendEmail(List<String> peopleList, String EmailInfo) {
        Result re = new Result();
        re.setResult(false);
        re.setReason("您的邮件服务暂未开通，请联系云服务！");
        return null;
    }
}
