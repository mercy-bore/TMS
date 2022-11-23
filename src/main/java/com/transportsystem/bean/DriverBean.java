package com.transportsystem.bean;

import com.transportsystem.model.Driver;
import com.transportsystem.model.Order;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Remote
@Named("driverBean")

public class DriverBean implements DriverBeanI {
    @PersistenceContext
    EntityManager em;

    @EJB
    OrderBeanI orderBean;

    public void add(Driver driver) throws Exception  {
        if (driver == null || StringUtils.isBlank(driver.getFirstName()) || StringUtils.isBlank(driver.getLastName()))
            return;
        if (StringUtils.isBlank(driver.getFirstName())) {
            throw new Exception("First Name is required");

        }
        if (StringUtils.isBlank(driver.getLastName())) {
            throw new Exception("Last Name is required");

        }
        if (StringUtils.isBlank(driver.getEmail())) {
            throw new Exception("Email is required");

        }
        if (StringUtils.isBlank(driver.getPhone())) {
            throw new Exception("Phone is required");

        }

        em.merge(driver);

    }

    public void update(Driver driver) throws Exception {
        if (StringUtils.isBlank(driver.getFirstName())) {
            throw new Exception("First Name is required");
        }
        if (StringUtils.isBlank(driver.getLastName())) {
            throw new Exception("Last Name is required");

        }
        if (StringUtils.isBlank(driver.getEmail())) {
            throw new Exception("Email is required");

        }
        if (StringUtils.isBlank(driver.getPhone())) {
            throw new Exception("Phone is required");

        }
        em.merge(driver);
    }

    public void delete(Driver driver) {
        em.remove(em.find(Driver.class, driver.getId()));

    }

    public Driver getDriver(Long id) {
        return em.find(Driver.class, id);

    }

    public List<Driver> list() {
        return em.createNamedQuery(Driver.FIND_ALL, Driver.class).getResultList();

    }

    public List<Driver> getDriverCrossJoinedList() {
        TypedQuery<Driver> query = em.createQuery("select c.firstName from Driver c  inner join Order o on o.driverId=c.id", Driver.class);
        List<Driver> resultList = query.getResultList();
        System.out.println("\n\n" + resultList + "\n\n");

        return resultList;
    }
    public boolean checkIfDriverhasOrder( Driver driver){
    List<Driver> drivers =  this.DriversWithOrderList();
    for (Driver driver1 : drivers) {
        if (driver1.getId() == driver.getId()) {
        return true;
        }
    }

        return false;
}
    public List<Driver> getDriverList() {
        return em.createQuery("select c.firstName from Driver c  inner join Order o on o.driver_id=c.id", Driver.class).getResultList();
    }
    public List<Driver> getDriverListWithoutOrder() {
        List<Driver> drivers = this.list();
        List<Driver> newList = new ArrayList<>();
        for (Driver driver : drivers) {
            if (!this.checkIfDriverhasOrder(driver) ) {
                newList.add(driver);

        }
    }

        System.out.println(newList);
        return newList;
    }

    public List<Driver> DriversWithOrderList() {
        // with order
        List<Driver> newList = new ArrayList<>();
        List<Order> orders = orderBean.ActiveOrderList();
        for(Order order: orders){
            newList.add(order.getDriver());

        }
       

        System.out.println(newList);
        return newList;   
     }
        public List<Driver> DriversWithDeliveredOrderList() {
        // with order
        List<Driver> newList = new ArrayList<>();
        List<Order> orders = orderBean.DeliveredOrderList();
        for(Order order: orders){
            newList.add(order.getDriver());

        }
       

        System.out.println(newList);
        return newList;   
     }
    public List<Driver> ActiveDriversList() {
        return em.createQuery("From Driver d where d.status =: Status", Driver.class).setParameter("Status", "active").getResultList();
    }
}
