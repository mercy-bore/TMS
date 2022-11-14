package com.transportsystem.restapi;

import com.transportsystem.bean.VehicleBeanI;
import com.transportsystem.model.Vehicle;
import com.transportsystem.rest.BaseRestApi;
import com.transportsystem.rest.ResponseWrapper;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/vehicle")
public class VehicleRestApi extends BaseRestApi {

    @EJB
    private VehicleBeanI vehicleBeanI;

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(Vehicle vehicle) {
        try {
            vehicleBeanI.add(vehicle);
            return Response.status(Response.Status.OK).entity(new ResponseWrapper()).build();

        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ResponseWrapper(false, ex.getMessage())).build();
        }

    }

    @Path("/list/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVehicle(@PathParam("id") Long id) throws Exception {
        System.out.println(">>>>>>>>>>>>>>>>>                      The id is " + id);
        return Response.status(Response.Status.OK).entity(vehicleBeanI.list()).build();

    }

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list()throws Exception {
        return Response.status(Response.Status.OK).entity(vehicleBeanI.list()).build();
    }
}