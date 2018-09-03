package com.example.demo.service.Impl;

import com.example.demo.entity.Result;
import com.example.demo.service.SendMessage;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by fengjinman Administrator on 2018/8/24.
 */
@Service
public class SendMessageImpl implements SendMessage {

    @Override
    public Result sendMessage(List<String> numberList, String message) {

        Result re = new Result();
        re.setResult(false);
        re.setReason("您的短信服务暂未开通，请联系云服务！");
        return re;
    }
}
