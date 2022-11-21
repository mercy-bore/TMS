package com.transportsystem.restapi;


import com.transportsystem.bean.UserBeanI;
import com.transportsystem.model.User;
import com.transportsystem.rest.BaseRestApi;
import com.transportsystem.rest.ResponseWrapper;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/user")
public class UserRestApi extends BaseRestApi {

    @EJB
    private UserBeanI authBean;

    @PermitAll
    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(RestLoginWrapper loginWrapper) {

        User auth = new User();
        auth.setUsername(loginWrapper.getUsername());
        auth.setPassword(loginWrapper.getPassword());
        try {
            User user = authBean.login(auth);
            return Response.status(Response.Status.OK)
                    .entity(new ResponseWrapper("authorized", user.getBearerToken())).build();

        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ResponseWrapper(false, ex.getMessage())).build();
        }
    }
}