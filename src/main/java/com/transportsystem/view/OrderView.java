package com.transportsystem.view;


import com.transportsystem.bean.OrderBeanI;
import com.transportsystem.model.Order;

import javax.ejb.EJB;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("OrderView")
public class OrderView implements Serializable {

    @EJB
    private OrderBeanI orderBeanI;

    public List<Order> getList() throws Exception {
        return orderBeanI.list();
    }
    public Order getOrder(Long id) throws Exception {
        return orderBeanI.getOrder(id);

    }
}