package com.transportsystem.model;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NamedQueries({
    @NamedQuery(name = Customer.FIND_ALL, query = "SELECT c FROM Customer c"),
    @NamedQuery(name = Customer.FIND_WITH_ID, query = "SELECT c FROM Customer c WHERE c.id=:Id"),
    @NamedQuery(name = Customer.FIND_WITH_FIRST_NAME, query = "SELECT c FROM Customer c WHERE c.firstName=:FirstName")
})
@Entity
@Table(name = "customers")
public class Customer extends BaseEntity {

    public static final String FIND_ALL = "Customer.findAll";
    public static final String FIND_WITH_ID = "Customer.findWithId";
    public static final String FIND_WITH_FIRST_NAME = "Customer.findWithFirstName";
    @Column
    String firstName;
    @Column
    String lastName;
    @Column
    String email;
    @Column
    String phone;

    @OneToMany(mappedBy = "customer", fetch =  FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();


    @JsonbTransient
    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
    @Override
    public String toString() {
        return "Customer{ firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", email='" + email + '\'' + ", phone=" + phone + '\'' + '}';
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
