package com.example.demo.service;

import com.example.demo.entity.Result;
import com.example.demo.entity.User;

/**
 * Created by fengjinman Administrator on 2018/9/3.
 */
public interface UserService {

    /**
     *   检查数据库中是否存在指定用户
     */
    Result checkUser(User user);

    /**
     *   注册一个用户
     */
    Result registOneUser(User user);


    /**
     *   为当前已经存在的用户添加个人信息
     */
    Result addSelfInfo(User user);
}
