package com.transportsystem.Soap;


import com.transportsystem.bean.VehicleBeanI;
import com.transportsystem.model.Vehicle;
import com.transportsystem.rest.ResponseWrapper;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.core.Response;


public class VehicleSoapApi{

    @EJB
    private VehicleBeanI vehicleBeanI;

    public void add(Vehicle vehicle) {
        try {
            vehicleBeanI.add(vehicle);

        } catch (Exception ex) {
            ex.getMessage();
    }

    }


    public List<Vehicle> list()throws Exception {
        return vehicleBeanI.list();
    }
}