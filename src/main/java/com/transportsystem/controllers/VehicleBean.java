package com.transportsystem.controllers;

import com.transportsystem.model.Vehicle;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Stateless
@Remote
public class VehicleBean implements Serializable {
    @PersistenceContext
    EntityManager em;
    public void add(Vehicle vehicle) {
        if (vehicle == null || StringUtils.isBlank(vehicle.getPlateNo()) || StringUtils.isBlank(vehicle.getType()))
            return;
        em.merge(vehicle);

    }
   
    public void update(Vehicle vehicle) {
        em.merge(vehicle);

    }
    
    public void delete( Vehicle vehicle) {
        em.remove(vehicle);
    }
    
     public Vehicle getVehicle(Long id) throws SQLException {
        Vehicle vehicle = new Vehicle();
        
        Map<String, String> criteria = new HashMap<String,String>(){{
            put("Id", Long.toString(id));
        }};
        em.merge(vehicle);
        return vehicle;
    }
   
    public void getVehicleById(Vehicle vehicle) {
        em.contains(vehicle);
    }
   

    public List<Vehicle> getList() {
        return em.createQuery("FROM vehicle v", Vehicle.class).getResultList();
    }

    public void enroll(Vehicle vehicle) {

    }

}
