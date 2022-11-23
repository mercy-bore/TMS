package com.transportsystem.bean;

import com.itextpdf.text.DocumentException;
import com.transportsystem.model.Vehicle;

import java.io.FileNotFoundException;
import java.util.List;

public interface VehicleBeanI {
    void add(Vehicle vehicle) throws Exception;
    void delete(Vehicle vehicle) throws Exception;
    void update(Vehicle vehicle) throws Exception;
    List<Vehicle> list() throws Exception;
    boolean checkIfVehiclehasOrder(Vehicle vehicle) ;
    List<Vehicle> removeVehicleWithOrder() throws Exception;
    List<Vehicle> TryWithoutOrderList() throws Exception;
    List<Vehicle> getVehicleListWithoutOrder();
    List<Vehicle> VehicleWithOrderList();
    List<Vehicle> VehiclesWithDeliveredOrderList();
    List<Vehicle> getVehicleList() throws FileNotFoundException, DocumentException;
    Vehicle getVehicle(Long id) throws  Exception;
    List<Vehicle> idleVehiclesList();
    List<Vehicle> ActiveVehiclesList();


}
