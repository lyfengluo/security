package com.lynne.springsecurity.service;

import com.lynne.springsecurity.model.AuthenticationRequest;
import com.lynne.springsecurity.model.User;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Description //TODO
 * @Date 2023/3/31 20:06
 * @Author fengyongli
 **/
@Service
public class AuthenticationServiceImpl implements AuthenticationService{
    @Override
    public User authentication(AuthenticationRequest authenticationRequest) {
        if(authenticationRequest == null ||
                StringUtils.isEmpty(authenticationRequest.getUsername())||
        StringUtils.isEmpty(authenticationRequest.getPassword())){

           throw  new RuntimeException("账号或密码不能为空");
        }
        User user = getUser(authenticationRequest.getUsername());
        if(user==null){
            throw new RuntimeException("用户不存在");
        }
        if(!authenticationRequest.getPassword().equals(user.getPassword())){
            throw new RuntimeException("账号或密码错误");
        }
        return user;
    }

    public User getUser(String username){
        return userMap.get(username);
    }

    //用户信息
    private Map<String,User> userMap = new HashMap<>();
    {
        Set<String> authority1 = new HashSet<>();
        authority1.add("p1");
        userMap.put("zhangsan",new User("1010","zhangsan","123","张三","133443",authority1));
        Set<String> authority2 = new HashSet<>();
        authority2.add("p2");
        userMap.put("lisi",new User("1011","lisi","456","李四","144553",authority2));
    }

}
