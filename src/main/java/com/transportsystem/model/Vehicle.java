package com.transportsystem.model;

import javax.inject.Inject;

public class Vehicle extends  BaseEntity {
    static public Long id;
    static public String type;
    static  public String plateNo;
    static public String route;
    static public String weight;
    @Inject
    public Vehicle() {
        
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        Vehicle.id = id;
    }


    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", plateNo='" + plateNo + '\'' +
                ", route='" + route + '\'' +
                ", weight='" + weight + '\'' +
                '}';
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        Vehicle.plateNo = plateNo;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        Vehicle.route = route;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        Vehicle.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        Vehicle.type = type;
    }
}
