package com.example.demo.datasource;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 数据源AOP切面定义
 */
@Component
@Aspect
@Slf4j
public class DataSourceAspect {


    /**
     * 切换放在mapper接口的方法上，所以这里要配置AOP切面的切入点
     * 定义了数据源切换在dao层的方法上
     * "execution( * com.example.demo.dao.*.*(..))"
     * 切入点表达式  代表匹配com.example.demo.dao包下的所有类下的所有方法
     */
    @Pointcut("execution( * com.example.demo.dao.*.*(..))")
    public void dataSourcePointCut() {
    }

    /**
     * 在dao层接口内的方法执行之前，根据方法上的注解，切换数据源
     * @param joinPoint
     */
    @Before("dataSourcePointCut()")
    public void before(JoinPoint joinPoint) {
        Object target = joinPoint.getTarget();
        //获取方法名
        String method = joinPoint.getSignature().getName();
        //获取目标类所实现的所有接口
        Class<?>[] clazz = target.getClass().getInterfaces();
        //获取目标方法的参数类型
        Class<?>[] parameterTypes = ((MethodSignature) joinPoint.getSignature()).getMethod().getParameterTypes();
        try {
            //利用反射得到真正的方法
            Method m = clazz[0].getMethod(method, parameterTypes);
            //如果方法上存在切换数据源的注解，则根据注解内容进行数据源切换
            //isAnnotationPresent 判断方法上方是否有此注解
            if (m != null && m.isAnnotationPresent(TargetDataSource.class)) {
                //获取自定义的注解
                TargetDataSource data = m.getAnnotation(TargetDataSource.class);
                //在注解中得到已经定义的值
                String dataSourceName = data.value();
                DynamicDataSourceHolder.putDataSource(dataSourceName);
                log.debug("当前线程：" + Thread.currentThread().getName() + " 添加数据源 " + dataSourceName + " to ThreadLocal");
            } else {
                log.debug("使用默认数据源");
            }
            //这是切入点前的方法，在数据库操作之前  这里执行之后就是dao层方法执行
            //获取数据源的时候，得到的就是我们想要的（刚刚定义好的）数据源了
        } catch (Exception e) {
            log.error("当前线程 " + Thread.currentThread().getName() + " 添加数据源失败，异常信息：", e);
        }
    }

    /**
     * 执行完切面后，将线程共享中的数据源名称清空
     * @param joinPoint
     */
    @After("dataSourcePointCut()")
    public void after(JoinPoint joinPoint){
        DynamicDataSourceHolder.removeDataSource();
    }
}

