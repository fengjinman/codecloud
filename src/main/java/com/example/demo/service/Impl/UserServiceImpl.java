package com.example.demo.service.Impl;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.Result;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
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
    public Result checkUser(User user) {
        log.info("------查询数据库-----");
        User db_user = dao.queryUser(user);
        log.info("返回结果：db_user = "+db_user);
        Result re = new Result();
        if(db_user!=null&&user.getPassword().equals(db_user.getPassword())){
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
