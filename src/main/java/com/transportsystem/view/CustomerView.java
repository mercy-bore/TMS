package com.transportsystem.view;

import com.transportsystem.controllers.CustomerBeanI;
import com.transportsystem.model.Customer;

import javax.ejb.EJB;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("CustomerView")
public class CustomerView implements Serializable {

    @EJB
    private CustomerBeanI customerBeanI;

    public List<Customer> getList() throws Exception {
        return customerBeanI.list();
    }

}