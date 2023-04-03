package com.lynne.springsecurity.controller;

import com.lynne.springsecurity.model.AuthenticationRequest;
import com.lynne.springsecurity.model.User;
import com.lynne.springsecurity.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @Description //TODO
 * @Date 2023/3/31 21:52
 * @Author fengyongli
 **/
@RestController
public class LoginController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping(value = "/login",produces = "text/plain;charset=UTF-8")
    public String login(AuthenticationRequest authenticationRequest, HttpSession session){

        User user = authenticationService.authentication(authenticationRequest);

        session.setAttribute(User.SESSION_USER_KEY,user);
        return user.getFullname()+"登录成功！";
    }

    @GetMapping(value = "/r/r1",produces = "text/plain;charset=UTF-8")
    public String r1(HttpSession session){
        Object userObject = session.getAttribute(User.SESSION_USER_KEY);
        String fullname = null;
        if(userObject == null ){
            fullname =  "匿名";
        }else {
            fullname = ((User)userObject).getFullname();
        }
        return fullname+"访问r1";
    }

    @GetMapping(value = "/r/r2",produces = {"text/plain;charset=UTF-8"})
    public String r2(HttpSession session){
        String fullname = null;
        Object userObj = session.getAttribute(User.SESSION_USER_KEY);
        if(userObj != null){
            fullname = ((User)userObj).getFullname();
        }else{
            fullname = "匿名";
        }
        return fullname + " 访问r2";
    }
}
