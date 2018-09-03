package com.example.demo.service.Impl;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.Result;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.util.MD5Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * Created by fengjinman Administrator on 2018/9/3.
 */
@Service
public class UserServiceImpl implements UserService {

    Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserDao dao;

    @Override
    public Result registOneUser(User user) {
        Result re = new Result();
        User db_user = dao.queryUser(user);
        if(db_user==null){
            log.info("------可以注册-----");
            re.setResult(true);
            String password = MD5Utils.getPwd(user.getPassword());
            log.info("------加密完成-----");
            user.setPassword(password);
            int num = dao.insertUser(user);
            if(num != 1){
                log.warn("### 插入数据库失败，返回结果："+num);
            }else{
                log.info("------注册成功！-----");
            }
        }else{
            log.info("### 不可以注册，已经存在此帐号：db_user = "+db_user);
            re.setResult(false);
            re.setReason("账户已经被注册！");
        }
        return re;
    }

    @Override
    public Result checkUser(User user) {
        log.info("------查询数据库-----");
        User db_user = dao.queryUser(user);
        log.info("返回结果：db_user = "+db_user);
        Result re = new Result();
        if(db_user!=null&&MD5Utils.getPwd(user.getPassword()).equals(db_user.getPassword())){
            log.info("-------登录成功------");
            re.setResult(true);
        }else{
            log.info("-------登录失败------");
            re.setResult(false);
            if(db_user==null){
                re.setReason("账号不存在！");
            }else if(!user.getPassword().equals(db_user.getPassword())){
                re.setReason("密码有误！");
            }
            log.info("失败原因："+re.getReason());
        }
        return re;
    }
}
