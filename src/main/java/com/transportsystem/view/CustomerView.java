package com.transportsystem.view;

import com.transportsystem.bean.CustomerBeanI;
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
    public Customer getCustomer(Long id) throws Exception {
        return customerBeanI.getCustomer(id);

    }
}