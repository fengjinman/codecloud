package com.example.demo.dao;

import com.example.demo.datasource.TargetDataSource;
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

    int insertUser(User user);

    /**
     * 从test1数据源中获取用户信息
     */
    User selectByOddUserId(Integer id);
    /**
     * 从test2数据源中获取用户信息
     */
    @TargetDataSource("test2")
    User selectByEvenUserId(Integer id);


    @TargetDataSource("test3")
    User queryUserById(Integer id);

}
