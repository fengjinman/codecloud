package com.example.demo.service;

import com.example.demo.entity.Result;
import com.example.demo.entity.User;

/**
 * Created by fengjinman Administrator on 2018/9/3.
 */
public interface UserService {

    Result checkUser(User user);

    Result registOneUser(User user);
}
