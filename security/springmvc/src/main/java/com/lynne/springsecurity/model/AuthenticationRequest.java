package com.lynne.springsecurity.model;

import lombok.Data;

/**
 * @Description //TODO
 * @Date 2023/3/31 19:57
 * @Author fengyongli
 **/
@Data
public class AuthenticationRequest {

    private String username;
    private String password;
}

