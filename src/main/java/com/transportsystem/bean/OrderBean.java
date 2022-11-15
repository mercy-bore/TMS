package com.transportsystem.bean;

import com.transportsystem.model.Customer;
import com.transportsystem.model.Driver;
import com.transportsystem.model.Order;
import com.transportsystem.model.Vehicle;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
@Remote
@Named("orderBean")
public class OrderBean implements OrderBeanI {
    @PersistenceContext
    EntityManager em;


    public void add(Order order) throws Exception {
        if (order == null || StringUtils.isBlank(order.getStartLocation()) || StringUtils.isBlank(order.getDestination())) {
            assert order != null;
            if (StringUtils.isBlank(order.getDestination())) {
                throw new Exception("Destination is required");

            }
            if (StringUtils.isBlank(order.getCargo())) {
                throw new Exception("Cargo is required");

            }
            if (StringUtils.isBlank(order.getStartLocation())) {
                throw new Exception("Start location is required");

            }
        }
        Vehicle vehicle = em.createQuery("FROM Vehicle v WHERE v.id = :vehicleId", Vehicle.class).setParameter("vehicleId", order.getVehicleId()).getSingleResult();
        order.setVehicle(vehicle);

        Customer customer = em.createQuery("FROM Customer c WHERE c.id = :customerId", Customer.class).setParameter("customerId", order.getCustomerId()).getSingleResult();
        order.setCustomer(customer);

        Driver driver = em.createQuery("FROM Driver d WHERE d.id = :driverId", Driver.class).setParameter("driverId", order.getDriverId()).getSingleResult();
        order.setDriver(driver);

        em.merge(order);

    }

    public void update(Order order) throws Exception {
        if (StringUtils.isBlank(order.getDestination())) {
            throw new Exception("Destination is required");
        }
        if (StringUtils.isBlank(order.getStartLocation())) {
            throw new Exception("Start Location is required");

        }
        if (StringUtils.isBlank(order.getCargo())) {
            throw new Exception("Cargo is required");

        }
        Vehicle vehicle = em.createQuery("FROM Vehicle v WHERE v.id = :vehicleId", Vehicle.class).setParameter("vehicleId", order.getVehicleId()).getSingleResult();
        order.setVehicle(vehicle);

        Customer customer = em.createQuery("FROM Customer c WHERE c.id = :customerId", Customer.class).setParameter("customerId", order.getCustomerId()).getSingleResult();
        order.setCustomer(customer);

        Driver driver = em.createQuery("FROM Driver d WHERE d.id = :driverId", Driver.class).setParameter("driverId", order.getDriverId()).getSingleResult();
        order.setDriver(driver);
        em.merge(order);
    }

    public void delete(Order order) {
        em.remove(em.find(Order.class, order.getId()));

    }

    public Order getOrder(Long id) {
        return em.find(Order.class, id);

    }

    public List<Order> list() {
        return em.createNamedQuery(Order.FIND_ALL, Order.class).getResultList();

    }

    public List<Order> getOrderList() {
        return em.createQuery("FROM Order o", Order.class).getResultList();
    }

    public List<Order> getVehicleList() {
        return em.createQuery("select e  from Order o inner join o.vehicle", Order.class).getResultList();
    }

    public void orderBy() {
        System.out.println("         test 1  ====================");
        Query query = em.createQuery("SELECT c FROM Order c right outer join c.vehicle");
        List<Customer> resultList = query.getResultList();
        resultList.forEach(System.out::println);
        System.out.println("         test 1  ====================");

    }

    public void test2() {
        System.out.println("   $$$$$$      test 2  ====================");
        Query query = em.createQuery("SELECT o FROM Order  inner join  o.vehicles where o.vehicles.id=o.id");
        List<Customer> resultList = query.getResultList();
        resultList.forEach(System.out::println);
        System.out.println("  $$$$$$$$       test 2  ====================");

    }

    public List<Order> test3() {
        return em.createQuery("SELECT o FROM Order o  right outer join Vehicle v", Order.class).getResultList();
    }
}