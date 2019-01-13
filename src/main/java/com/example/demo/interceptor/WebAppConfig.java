package com.example.demo.interceptor;

/**
 * Created by fengjinman on 2019/1/13.
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletResponse;

/**
 *
 * 注册拦截器
 * Created by SYSTEM on 2017/8/16.
 */
@Slf4j
@Component
public class WebAppConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new XxxInterceptor()).addPathPatterns("/loginPage");
    }

}

