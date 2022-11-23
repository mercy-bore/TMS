package com.transportsystem.bean;


import com.itextpdf.text.DocumentException;
import com.transportsystem.model.Order;
import com.transportsystem.model.Vehicle;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Stateless
@Remote
@Named("vehicleBean")
public class VehicleBean implements VehicleBeanI {
    @PersistenceContext
    EntityManager em;


    @EJB
    OrderBeanI orderBean;
    public void add(Vehicle vehicle) throws Exception {
        if (vehicle == null || StringUtils.isBlank(vehicle.getPlateNo()) || StringUtils.isBlank(vehicle.getType()))
            return;
        if (StringUtils.isBlank(vehicle.getType())) {
            throw new Exception(" Type is required");

        }
        if (StringUtils.isBlank(vehicle.getPlateNo())) {
            throw new Exception("Plate No is required");

        }
        if (StringUtils.isBlank(vehicle.getWeight())) {
            throw new Exception("Weight is required");

        }
        if (StringUtils.isBlank(vehicle.getRoute())) {
            throw new Exception("Route is required");

        }

        em.merge(vehicle);

    }

    public void update(Vehicle vehicle) throws Exception {
        if (StringUtils.isBlank(vehicle.getType())) {
            throw new Exception("TYpe is required");
        }
        if (StringUtils.isBlank(vehicle.getPlateNo())) {
            throw new Exception("Plate No is required");

        }
        if (StringUtils.isBlank(vehicle.getWeight())) {
            throw new Exception("Weight is required");

        }
        if (StringUtils.isBlank(vehicle.getRoute())) {
            throw new Exception("Route is required");

        }
        em.merge(vehicle);
    }

    public void delete(Vehicle vehicle) {
        em.remove(em.find(Vehicle.class, vehicle.getId()));

    }

    public Vehicle getVehicle(Long id) {
        return em.find(Vehicle.class, id);

    }

    public List<Vehicle> list() {
        return em.createNamedQuery(Vehicle.FIND_ALL, Vehicle.class).getResultList();
    }

    public boolean checkIfVehiclehasOrder( Vehicle vehicle){
    List<Vehicle> vehicles =  this.VehicleWithOrderList();
    for (Vehicle vehicle1 : vehicles) {
        if (vehicle1.getId() == vehicle.getId()) {
        return true;
        }
    }

        return false;
}
    
    public List<Vehicle> removeVehicleWithOrder() {
        Order order = new Order();
        List<Vehicle> vehicles = em.createQuery("select v from Vehicle v").getResultList();
        List<Vehicle> newList = new ArrayList<>(); // store without order
        for (Vehicle vehicle : vehicles) {
            // if orders are less than 1 && order status is delivered;... add to without order list ..
            if (vehicle.getOrders().size() > 0) {
                newList.add(vehicle);
            }
        }

        System.out.println(newList);
        return newList;
    }
    public List<Vehicle> TryWithoutOrderList() {
        Order order = new Order();
        Vehicle vehicle = new Vehicle();
        List<Vehicle> vehicles = em.createQuery("select v from Vehicle v").getResultList();
        List<Vehicle> newList = new ArrayList<>(); // store with order
        Iterator<Vehicle> vehicles1 = vehicles.iterator();
        while (vehicles1.hasNext()){
            if (vehicle.getOrders().size() > 0 ) {
                newList.add(vehicle);

                if(Objects.equals(order.getStatus(), "delivered")){
                    newList.remove(vehicle);
                    vehicles.add(vehicle);
                }
            }

        }

        System.out.println(vehicles);
        return vehicles;
    }
    public List<Vehicle> getVehicleListWithoutOrder() {
        List<Vehicle> drivers = this.list();
        List<Vehicle> newList = new ArrayList<>();
        for (Vehicle driver : drivers) {
            if (!this.checkIfVehiclehasOrder(driver) ) {
                newList.add(driver);

        }
    }

        System.out.println(newList);
        return newList;
    }

    public List<Vehicle> VehicleWithOrderList() {
        // with order
        List<Vehicle> newList = new ArrayList<>();
        List<Order> orders = orderBean.ActiveOrderList();
        for(Order order: orders){
            newList.add(order.getVehicle());

        }
       

        System.out.println(newList);
        return newList;   
     }
    public List<Vehicle> VehiclesWithDeliveredOrderList() {
        // with order
        List<Vehicle> newList = new ArrayList<>();
        List<Order> orders = orderBean.DeliveredOrderList();
        for(Order order: orders){
            newList.add(order.getVehicle());

        }
    
        System.out.println(newList);
        return newList;   
     }
   
    public List<Vehicle> idleVehiclesList() {
        return em.createQuery("From Vehicle v where v.status =: Status", Vehicle.class).setParameter("Status", "").getResultList();
    }

    public List<Vehicle> ActiveVehiclesList() {
        return em.createQuery("From Vehicle v where v.status =: Status", Vehicle.class).setParameter("Status", "active").getResultList();
    }

    public List<Vehicle> getVehicleList() throws FileNotFoundException, DocumentException {
        TypedQuery<Vehicle> query = em.createQuery("SELECT v FROM Vehicle as v left outer join Order as o where o.vehicle.id not in o", Vehicle.class);
        List<Vehicle> resultList = query.getResultList();
        System.out.println("\n\n" + resultList + "\n\n");
        return resultList;
    }


}
