package com.transportsystem.model;

public class Vehicle extends  BaseEntity {
    private Long id;
    private String type;
    private String plateNo;
    private String route;
    private String weight;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
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
