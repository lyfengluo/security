package com.lynne.springsecurity.interceptor;

import com.lynne.springsecurity.model.User;
import com.sun.deploy.net.HttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

/**
 * @Description //TODO
 * @Date 2023/4/1 8:14
 * @Author fengyongli
 **/
@Component
public class SimpleAuthenticationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Object userObject = request.getSession().getAttribute(User.SESSION_USER_KEY);
        if(userObject == null){
            writeContent(response,"请先登录");
        }
        User user = (User)userObject;
        if(user.getAuthorities().contains("p1")&&request.getRequestURI().contains("r1")){
            return true;
        }
        if(user.getAuthorities().contains("p2")&&request.getRequestURI().contains("r2")){
            return true;
        }
        writeContent(response,"权限不足，拒绝访问");
        return false;
    }

    private void writeContent(HttpServletResponse response,String msg) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.print(msg);
        writer.close();
        response.resetBuffer();

    }
}

