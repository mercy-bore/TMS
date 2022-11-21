package com.transportsystem.bean;


import com.itextpdf.text.DocumentException;
import com.transportsystem.model.Vehicle;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Remote
@Named("vehicleBean")
public class VehicleBean implements VehicleBeanI {
    @PersistenceContext
    EntityManager em;

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
    public List<Vehicle> getVehicleListWithoutOrder() {
        List<Vehicle> vehicles= em.createQuery("select v from Vehicle v").getResultList();
        List<Vehicle> newList = new ArrayList<>();
        for (Vehicle vehicle : vehicles){
            if(vehicle.getOrders().size() < 1){
                newList.add(vehicle);
        }
    }   System.out.println(newList);
        return newList;
    }
    public List<Vehicle> idleVehiclesList() {
        return em.createQuery("From Vehicle v where v.status =: Status", Vehicle.class).setParameter("Status","").getResultList();
    }

    public List<Vehicle> ActiveVehiclesList() {
        return em.createQuery("From Vehicle v where v.status =: Status", Vehicle.class).setParameter("Status","active").getResultList();
    }
    public List<Vehicle> getVehicleList() throws FileNotFoundException, DocumentException {
        TypedQuery<Vehicle> query = em.createQuery("SELECT v FROM Vehicle as v left outer join Order as o where o.vehicle.id not in o", Vehicle.class);
        List<Vehicle> resultList = query.getResultList();
        System.out.println("\n\n" + resultList + "\n\n");
        return resultList;    }
}
