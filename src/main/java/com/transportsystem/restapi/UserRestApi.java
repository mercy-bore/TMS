package com.transportsystem.restapi;


import com.transportsystem.bean.UserBeanI;
import com.transportsystem.rest.BaseRestApi;

import javax.ejb.EJB;
import javax.ws.rs.Path;

@Path("/user")
public class UserRestApi extends BaseRestApi {

    @EJB
    private UserBeanI userBeanI;


}
