package com.transportsystem.view;

import com.transportsystem.controllers.VehicleBeanI;
import com.transportsystem.model.Vehicle;

import javax.ejb.EJB;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("VehicleView")
public class VehicleView implements Serializable {

    @EJB
    private VehicleBeanI vehicleBeanI;

    public List<Vehicle> getList() throws Exception {
        return vehicleBeanI.list();
    }

}