package com.transportsystem.restapi;


import com.transportsystem.bean.AddressBeanI;
import com.transportsystem.model.Address;
import com.transportsystem.rest.BaseRestApi;
import com.transportsystem.rest.ResponseWrapper;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/address")
public class AddressRestApi extends BaseRestApi {

    @EJB
    private AddressBeanI addressBeanI;

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(Address address) {
        try {
            addressBeanI.add(address);
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
        return Response.status(Response.Status.OK).entity(addressBeanI.list()).build();
    }

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list()throws Exception {
        return Response.status(Response.Status.OK).entity(addressBeanI.list()).build();
    }
}