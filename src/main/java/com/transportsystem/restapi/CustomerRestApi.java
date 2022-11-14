package com.transportsystem.restapi;

import com.transportsystem.bean.CustomerBeanI;
import com.transportsystem.model.Customer;
import com.transportsystem.rest.BaseRestApi;
import com.transportsystem.rest.ResponseWrapper;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/customer")
public class CustomerRestApi extends BaseRestApi {

    @EJB
    private CustomerBeanI customerBeanI;
    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list()throws Exception {
        return Response.status(Response.Status.OK).entity(customerBeanI.list()).build();
    }
    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(Customer customer) {
        try {
            customerBeanI.add(customer);
            return Response.status(Response.Status.OK).entity(new ResponseWrapper()).build();

        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(new ResponseWrapper(false, ex.getMessage())).build();
        }

    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomer(@PathParam("id") Long id)   throws Exception {
        return Response.status(Response.Status.OK).entity(customerBeanI.getCustomer(id)).build();
    }


}