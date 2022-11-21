package com.transportsystem.model;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NamedQueries({@NamedQuery(name = Vehicle.FIND_ALL, query = "SELECT v FROM Vehicle v"), @NamedQuery(name = Vehicle.FIND_WITH_ID, query = "SELECT v FROM Vehicle v WHERE v.id=:Id"), @NamedQuery(name = Vehicle.FIND_WITH_PLATE_NO, query = "SELECT v FROM Vehicle v WHERE v.plateNo=:PlateNo")})

@Entity
@Table(name = "vehicles")
public class Vehicle extends BaseEntity {
    public static final String FIND_ALL = "Vehicle.findAll";
    public static final String FIND_WITH_ID = "Vehicle.findWithId";
    public static final String FIND_WITH_PLATE_NO = "Vehicle.findWithPlateNo";

    @Column
    private String type;
    @Column
    private String plateNo;
    @Column
    private String route;
    @Column
    private String weight;
    @Column
    private String status;
    @OneToMany(mappedBy = "vehicle", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();

    @Override
    public String toString() {
        return "Vehicle{type='" + type + '\'' + ", plateNo='" + plateNo + '\'' + ", route='" + route + '\'' + ", weight='" + weight + '\'' + '}';
    }

    @JsonbTransient
    public List<Order> getOrders() {
        return orders;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
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
