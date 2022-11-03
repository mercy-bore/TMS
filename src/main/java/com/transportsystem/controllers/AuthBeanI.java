package com.transportsystem.controllers;

import com.transportsystem.model.User;
import com.transportsystem.model.Auth;

public interface AuthBeanI {

    User login(Auth auth) throws Exception;

}