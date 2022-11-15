package com.transportsystem.model;

import javax.persistence.*;

@NamedQueries({@NamedQuery(name = Order.FIND_ALL, query = "SELECT o FROM Order o "), @NamedQuery(name = Order.FIND_WITH_ID, query = "SELECT o FROM Order o WHERE o.id=:Id"), @NamedQuery(name = Order.FIND_WITH_NAME, query = "SELECT o FROM Order o WHERE o.cargo=:Cargo")})
@Entity
@Table(name = "orders")
public class Order extends BaseEntity {
    public static final String FIND_ALL = "Order.findAll";
    public static final String FIND_WITH_ID = "Order.findWithId";
    public static final String FIND_WITH_NAME = "Order.findWithName";
    @Column
    String startLocation;
    @Column
    String destination;
    @Column
    String cargo;
    @ManyToOne(fetch = FetchType.EAGER)
    private Vehicle vehicle;
    @ManyToOne(fetch = FetchType.EAGER)
    private Customer customer;
    @ManyToOne(fetch = FetchType.EAGER)
    private Driver driver;
    @Transient
    private Long vehicleId;
    @Transient
    private Long customerId;
    @Transient
    private Long driverId;

    public Order(Driver driver) {
        this.driver = driver;
    }

    public Order() {
    }

    public Order(Customer customer) {
        this.customer = customer;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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
}


