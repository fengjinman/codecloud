package com.example.demo.dao;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by fengjinman Administrator on 2018/8/16.
 */
@Mapper
public interface UserDao {

    List<User> queryAll();

    User queryUser(User user);
}
