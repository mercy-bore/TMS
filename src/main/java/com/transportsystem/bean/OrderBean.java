package com.transportsystem.bean;

import com.transportsystem.model.Order;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
@Remote
@Named("orderBean")
public class OrderBean implements OrderBeanI{
    @PersistenceContext
    EntityManager em;


        public void add(Order order) throws Exception {
            if (order == null || StringUtils.isBlank(order.getName()) || StringUtils.isBlank(order.getDestination()))

            if (StringUtils.isBlank(order.getDestination())) {
                throw new Exception("Destination is required");

            }
            if (StringUtils.isBlank(order.getCargo())) {
                throw new Exception("Cargo is required");

            }
            if (StringUtils.isBlank(order.getStartLocation())) {
                throw new Exception("Start location is required");

            }

            em.merge(order);

        }

        public void update(Order order) throws Exception {
            if(StringUtils.isBlank(order.getDestination())){
                throw new Exception ("Destination is required");
            }
            if (StringUtils.isBlank(order.getStartLocation())) {
                throw new Exception("Start Location is required");

            }
            if (StringUtils.isBlank(order.getCargo())) {
                throw new Exception("Cargo is required");

            }

            em.merge(order);
        }

        public void delete(Order order) {
            em.remove(em.find(Order.class, order.getId()));

        }
    public Order getOrder(Long id) {
        return em.find(Order.class, id);

    }

        public List<Order> list() {
            return  em.createNamedQuery(Order.FIND_ALL, Order.class).getResultList();

        }
    }
