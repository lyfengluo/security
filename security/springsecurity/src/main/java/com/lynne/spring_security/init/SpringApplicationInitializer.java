package com.lynne.spring_security.init;

import com.lynne.spring_security.config.ApplicationConfig;
import com.lynne.spring_security.config.WebMvcConfig;
import com.lynne.spring_security.config.WebSecurityConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @Description //TODO
 * @Date 2023/4/1 10:05
 * @Author fengyongli
 **/
//
public class SpringApplicationInitializer
        extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ApplicationConfig.class, WebSecurityConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebMvcConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
