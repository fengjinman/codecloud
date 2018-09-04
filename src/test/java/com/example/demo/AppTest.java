package com.example.demo;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class AppTest {
    @Autowired
    private UserDao dao;

    @Test
    public void testDynamicDatasource() {
        System.out.println(dao);
        User user = dao.selectByOddUserId(48);
        System.out.println(user);
        User user1 = dao.selectByEvenUserId(1);
        User user2 = dao.selectByEvenUserId(2);
        User user3 = dao.selectByEvenUserId(3);
        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);
        User user4 = dao.queryUserById(3);
        System.out.println(user4);
    }
}

