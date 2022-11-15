package com.transportsystem.model;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = Driver.FIND_ALL, query = "SELECT d FROM Driver d"),
        @NamedQuery(name = Driver.FIND_WITH_ID, query = "SELECT d FROM Driver d WHERE d.id=:id"),
        @NamedQuery(name = Driver.FIND_WITH_FIRST_NAME, query = "SELECT d FROM Driver d WHERE d.firstName=:FirstNam")
})
@Entity
@Table(name = "drivers")
public class Driver extends  BaseEntity{
    public static final String FIND_ALL = "Driver.findAll";
    public static final String FIND_WITH_ID = "Driver.findWithId";
    public static final String FIND_WITH_FIRST_NAME = "Driver.findWithFirstName";
    @Column
    String firstName;
    @Column
    String lastName;
    @Column
    String email;
    @Column
    String phone;

    @OneToMany(mappedBy = "driver", fetch =  FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();


    @JsonbTransient
    public List<Order> getOrders() {
        return orders;
    }



    public void setOrders(List<Order> orders) {
        this.orders = orders;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
