package com.example.demo.service;

import com.example.demo.entity.Result;

import java.util.List;

/**
 * Created by fengjinman Administrator on 2018/9/4.
 */
public interface SendEmail {

    Result SendEmail(List<String> peopleList,String EmailInfo);
}
