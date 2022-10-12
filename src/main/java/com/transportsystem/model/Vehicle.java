package com.transportsystem.model;

public class Vehicle extends  BaseEntity {
    private String plateNo;
    private String route;
    private String weight;
    private String type;



    @Override
    public String toString() {
        return "Vehicle{" +
                ", plateNo='" + plateNo + '\'' +
                ", route='" + route + '\'' +
                ", weight='" + weight + '\'' +
                ", type='" + type + '\'' +
                '}';
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
