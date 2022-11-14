package com.transportsystem.restapi;


import com.transportsystem.bean.OrderBeanI;
import com.transportsystem.model.Order;
import com.transportsystem.rest.BaseRestApi;
import com.transportsystem.rest.ResponseWrapper;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/order")
public class OrderRestApi extends BaseRestApi {

    @EJB
    private OrderBeanI orderBeanI;

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(Order order) {
        try {
            orderBeanI.add(order);
            return Response.status(Response.Status.OK).entity(new ResponseWrapper()).build();

        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ResponseWrapper(false, ex.getMessage())).build();
        }

    }

    @Path("/list/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomer(@PathParam("id") Long id)   throws Exception {
        return Response.status(Response.Status.OK).entity(orderBeanI.list()).build();
    }

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list()throws Exception {
        return Response.status(Response.Status.OK).entity(orderBeanI.list()).build();
    }
}
