package com.transportsystem.bean;

import com.transportsystem.model.Customer;

import java.util.List;

public interface CustomerBeanI {
    void add(Customer customer) throws Exception;

    void delete(Customer customer) throws Exception;

    void update(Customer customer) throws Exception;


    void  innerJoin() throws Exception;

    void leftJoin() throws Exception;

    void  crossJoin() throws Exception;

    List<Customer> list() throws  Exception;

    Customer getCustomer(Long id) throws Exception;

    void groupBy() throws Exception;
    void orderBy() throws Exception;
    void limit();    



}
