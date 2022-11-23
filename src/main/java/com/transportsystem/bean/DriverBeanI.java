package com.transportsystem.bean;

import com.transportsystem.model.Driver;

import java.util.List;

public interface DriverBeanI {
    void add(Driver driver) throws Exception;

    void delete(Driver driver) throws Exception;

    void update(Driver driver) throws Exception;

    List<Driver> list() throws  Exception;
    List<Driver> getDriverCrossJoinedList();
    List<Driver> getDriverListWithoutOrder();
    boolean checkIfDriverhasOrder(Driver driver);
    Driver getDriver(Long id) ;
    List<Driver> DriversWithOrderList();
    List<Driver> getDriverList();
    List<Driver> DriversWithDeliveredOrderList();
    List<Driver> ActiveDriversList();

    


}
