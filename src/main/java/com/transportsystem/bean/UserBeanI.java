package com.transportsystem.bean;


import com.transportsystem.model.User;

public interface UserBeanI {
    User register(User user) throws Exception;

    User login(User user) throws Exception;

    boolean authMd5(String md5Hash);

}