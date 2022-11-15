package com.transportsystem.bean;

import com.transportsystem.model.Vehicle;

import java.util.List;

public interface VehicleBeanI {
    void add(Vehicle vehicle) throws Exception;

    void delete(Vehicle vehicle) throws Exception;

    void update(Vehicle vehicle) throws Exception;


    List<Vehicle> list() throws Exception;
    List<Vehicle> getVehicleCrossJoinedList();
    List<Vehicle> getVehicleList();

    Vehicle getVehicle(Long id) throws  Exception;

}
