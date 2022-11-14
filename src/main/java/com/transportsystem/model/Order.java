package com.transportsystem.model;

import javax.persistence.*;
@NamedQueries({
        @NamedQuery(name = Order.FIND_ALL, query = "SELECT o FROM Order o "),
        @NamedQuery(name = Order.FIND_WITH_ID, query = "SELECT o FROM Order o WHERE o.id=:Id"),
        @NamedQuery(name = Order.FIND_WITH_NAME, query = "SELECT o FROM Order o WHERE o.name=:Name")
})
@Entity
@Table(name = "orders")
public class Order extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    private Vehicle vehicle;
    @ManyToOne(fetch = FetchType.LAZY)
    private  Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    private Driver driver;
    @Column
    String name;
    @Column
    String startLocation;
    @Column
    String destination;
    @Column
    String cargo;

    public static final String FIND_ALL = "Order.findAll";
    public static final String FIND_WITH_ID = "Order.findWithId";
    public static final String FIND_WITH_NAME = "Order.findWithName";

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Order(Driver driver){
        this.driver = driver;
    }


    public Order(){}

    public Order(String name){
        this.name = name;
    }


    public Driver getDriver() {
        return driver;
    }

    public Order(Customer customer){
        this.customer = customer;
    }
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
