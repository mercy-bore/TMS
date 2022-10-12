package com.transportsystem.model;

public class Customer  extends  BaseEntity{
    Long id;
    int pk =0;
    String firstName;
    String lastName;
    String  email;
    int phoneNo;
    String Location;
    String cargo;
    String deliveryType;

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", pk=" + pk +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNo=" + phoneNo +
                ", Location='" + Location + '\'' +
                ", cargo='" + cargo + '\'' +
                ", deliveryType='" + deliveryType + '\'' +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }



    public Customer() {
        pk = pk + 1;
        id = (long) pk;
    }

}
