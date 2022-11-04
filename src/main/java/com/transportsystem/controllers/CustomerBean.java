package com.transportsystem.controllers;

import com.transportsystem.model.Customer;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Stateless
@Remote
public class CustomerBean implements Serializable {
    @PersistenceContext
    EntityManager em;

    public void add(Customer customer) {
        if (customer == null || StringUtils.isBlank(customer.getFirstName()) || StringUtils.isBlank(customer.getLastName()))
            return;
        em.merge(customer);

    }

    public void update(Customer customer) {
        em.merge(customer);

    }

    public void delete(Customer customer) {
        em.remove(customer);
    }
    public void getCustomerById(Customer customer) {


    }
     public Customer getCustomer(Long id) throws SQLException {
        Customer customer = new Customer();
        Map<String, String> criteria = new HashMap<String,String>()
        {{
            put("Id", Long.toString(id));
        }};
        em.contains(customer);
        return  customer;
    }

    public List<Customer> getList() {
        return em.createQuery("FROM customer s", Customer.class).getResultList();
    }
}