package com.example.demo;

import com.example.demo.dao.UserMapper;
import com.example.demo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class AppTest {

    @Resource
    UserMapper dao;

    /**
     * springboot 使用事务配置@Transactional即可
     * 用法是添加在实现类上，添加在接口上也可以，但是必须是代理对象才能使事务生效
     * 因为注解是不能被继承的
     * 开启事务的注解没有添加也能使用事务，个人认为是由于springboot自动配置了事务的原因
     * 引入了springboot的jdbc和jpa包之后，事务是自动配置的
     * @throws Exception
     */
    @Test
    @Transactional
    public void test1() throws Exception{
        dao.insert(new User("aaa","123"));
        dao.insert(new User("bbb","123"));
        dao.insert(new User("ccc","123"));
        dao.insert(new User("ddd","123"));
        dao.insert(new User("eeeeeeeeeeeeeeeeeeeeeeeeeee","123"));
        dao.insert(new User("fff","123"));
        dao.insert(new User("ggg","123"));
    }

    //测试redis
    @Test
    public void test(){
//        dao.deleteById("2");
        User byId = dao.findById("3");
        System.out.println(byId);
    }
}

