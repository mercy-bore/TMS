package com.transportsystem.model;

import javax.inject.Inject;

public class Vehicle extends  BaseEntity {
    private Long id;
    private String type;
    private String plateNo;
    private String route;
    private String weight;

    @Inject
    public Vehicle() {
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        id = id;
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
        plateNo = plateNo;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        route = route;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        type = type;
    }
}
