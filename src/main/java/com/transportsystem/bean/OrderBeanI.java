package com.transportsystem.bean;

import com.transportsystem.model.Order;

import java.util.List;

public interface OrderBeanI {
    void add(Order order) throws Exception;

    void delete(Order order) throws Exception;

    void update(Order order) throws Exception;

    List<Order>test2() throws  Exception;

    List<Order> test3() throws  Exception;
    List<Order> list() throws Exception;

    Order getOrder(Long id) throws  Exception;
}
