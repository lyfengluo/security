package com.lynne.spring_security.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @Description //TODO
 * @Date 2023/4/1 9:45
 * @Author fengyongli
 **/
@Configuration
@ComponentScan(basePackages = "com.lynne.spring_security",
        excludeFilters = {
        @ComponentScan.Filter( type = FilterType.ANNOTATION,value = Controller.class
        )})
public class ApplicationConfig {
}
