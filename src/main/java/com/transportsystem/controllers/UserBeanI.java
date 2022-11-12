package com.transportsystem.controllers;


import com.transportsystem.model.User;

public interface UserBeanI {
    User register(User user) throws Exception;

    User login(User user) throws Exception;


}