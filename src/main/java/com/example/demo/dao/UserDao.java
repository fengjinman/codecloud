package com.example.demo.dao;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;


/**
 * Created by fengjinman Administrator on 2018/8/16.
 */
@Mapper
public interface UserDao {



    User queryUser(User user);

    int insertUser(User user);

    /**
     * 向用户表添加详细信息
     */
    int updateInfoByUser(User user);


}
