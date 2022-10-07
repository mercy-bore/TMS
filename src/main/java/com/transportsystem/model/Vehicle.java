package com.transportsystem.model;

import java.io.Serializable;

public class Vehicle implements Serializable {
    static int maxId = 0;
    private int id;
    private String plateNo;
    private String route;
    private String weight;
    private String type;

    public Vehicle() {
        maxId = maxId + 1;
        id = maxId;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", plateNo='" + plateNo + '\'' +
                ", route='" + route + '\'' +
                ", weight='" + weight + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
