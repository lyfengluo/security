package com.lynne.springsecurity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Description //TODO
 * @Date 2023/3/31 19:55
 * @Author fengyongli
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    public static final String SESSION_USER_KEY = "_user";
    private String id;
    private String username;
    private String password;
    private String fullname;
    private String mobile;

    private Set<String> authorities;



}
