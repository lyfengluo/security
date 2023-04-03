package com.lynne.springsecurity.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @Description //TODO
 * @Date 2023/3/31 9:53
 * @Author fengyongli
 **/
@Configuration//相当于applicationContext.xml
@ComponentScan(basePackages = "com.lynne.springsecurity",excludeFilters = {
        @ComponentScan.Filter( type =FilterType.ANNOTATION,value = Controller.class)
})
public class ApplicationConfiguration {
    //在此配置除了Controller的其它bean，比如：数据库链接池、事务管理器、业务bean等。
}
