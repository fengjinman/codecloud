package com.example.demo.service;

import com.example.demo.entity.Result;

import java.util.List;

/**
 * Created by fengjinman Administrator on 2018/8/24.
 */
public interface SendMessage {
    /**
     *  发送信息的预留接口
     */
    Result sendMessage(List<String> numberList, String message);
}
