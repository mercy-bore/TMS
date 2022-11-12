package com.transportsystem.controllers;

import com.transportsystem.model.Vehicle;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
     if(StringUtils.isBlank(vehicle.getType())){
        throw new Exception ("TYpe is required");
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
    public Vehicle getVehicle(Long id){
        return  em.createNamedQuery(Vehicle.FIND_WITH_ID, Vehicle.class).getSingleResult();

    }

    public List<Vehicle> list() {
        return  em.createNamedQuery(Vehicle.FIND_ALL, Vehicle.class).getResultList();

    } 

}
