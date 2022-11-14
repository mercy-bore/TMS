package com.transportsystem.view;


import com.transportsystem.bean.DriverBeanI;
import com.transportsystem.model.Driver;

import javax.ejb.EJB;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("DriverView")
public class DriverView implements Serializable {

    @EJB
    private DriverBeanI driverBeanI;

    public List<Driver> getList() throws Exception {
        return driverBeanI.list();
    }
    public Driver getDriver(Long id) throws Exception {
        return driverBeanI.getDriver(id);

    }
}