package com.example.demo.service.Impl;

import com.example.demo.service.SendMessage;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by fengjinman Administrator on 2018/8/24.
 */
@Service
public class SendMessageImpl implements SendMessage {

    @Override
    public String sendMessage(List<String> numberList, String message) {

        return "您的短信服务暂未开通，请联系云服务！";
    }
}
