package com.lynne.springsecurity.service;

import com.lynne.springsecurity.model.AuthenticationRequest;
import com.lynne.springsecurity.model.User;

public interface AuthenticationService {

    public User authentication(AuthenticationRequest authenticationRequest);
}
