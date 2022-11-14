package com.transportsystem.restapi;


import com.transportsystem.bean.DriverBeanI;
import com.transportsystem.model.Driver;
import com.transportsystem.rest.BaseRestApi;
import com.transportsystem.rest.ResponseWrapper;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/driver")
public class DriverRestApi extends BaseRestApi {

    @EJB
    private DriverBeanI driverBeanI;

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(Driver driver) {
        try {
            driverBeanI.add(driver);
            return Response.status(Response.Status.OK).entity(new ResponseWrapper()).build();

        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ResponseWrapper(false, ex.getMessage())).build();
        }

    }

    @Path("/list/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomer(@PathParam("id") Long id) throws Exception {
        return Response.status(Response.Status.OK).entity(driverBeanI.list()).build();
    }

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() throws Exception {
        return Response.status(Response.Status.OK).entity(driverBeanI.list()).build();
    }
}