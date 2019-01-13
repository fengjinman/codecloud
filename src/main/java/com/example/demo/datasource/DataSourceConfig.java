package com.example.demo.datasource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 数据源配置
 *
 关于@EnableScheduling，其实就是用来使@Schedule注解功能可用的注解。
 在 Spring Boot 的配置类中，标注上这个注解，就可以对项目中的方法某些方法使用@Schedule注解，
 将其变为定时自动执行。
 但只有两种注解共同使用时，才能达到本注解应有的作用。、

 @Configuration
 相当于ssm中的xml文件中的beans标签

 @Bean
 相当于bean标签  可以通过这个注解得到一个对象  前提是这个类必须已经存在
 */
@Configuration
//不知道为什么要用这个注解  没有看到定时任务的存在
@EnableScheduling
@Slf4j
public class DataSourceConfig {

    @Autowired
    private DBProperties properties;

    //@Bean 用在方法上，告诉Spring容器，你可以从下面这个方法中拿到一个Bean
    //如果注解内没有写bean的id 那么默认取的就是方法名 这里两者一致
    @Bean(name = "dataSource")
    public DataSource dataSource() {
        //按照目标数据源名称和目标数据源对象的映射存放在Map中
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put("test1", properties.getTest1());
        targetDataSources.put("test2", properties.getTest2());
        targetDataSources.put("test3", properties.getTest3());
        //采用是想AbstractRoutingDataSource的对象包装多数据源
        DynamicDataSource dataSource = new DynamicDataSource();
        //set方法是父抽象类的
        dataSource.setTargetDataSources(targetDataSources);
        //设置默认的数据源，当拿不到数据源时，使用此配置
        dataSource.setDefaultTargetDataSource(properties.getTest3());
        return dataSource;
    }

    //事务相关的  暂时没用到
    @Bean
    public PlatformTransactionManager txManager() {
        return new DataSourceTransactionManager(dataSource());
    }

}

