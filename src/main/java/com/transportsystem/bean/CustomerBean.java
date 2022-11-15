package com.transportsystem.bean;

import com.transportsystem.model.Customer;
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
@Named("customerBean")
public class CustomerBean implements CustomerBeanI {
    @PersistenceContext
    EntityManager em;

    public void add(Customer customer) throws Exception {
        if (customer == null || StringUtils.isBlank(customer.getFirstName()) || StringUtils.isBlank(customer.getLastName()))
            return;

        if (StringUtils.isBlank(customer.getFirstName())) {
            throw new Exception(" First Name is required");

        }

        if (StringUtils.isBlank(customer.getLastName())) {
            throw new Exception("Last Name is required");

        }
        if (StringUtils.isBlank(customer.getEmail())) {
            throw new Exception(" Email is required");

        }
        if (StringUtils.isBlank(customer.getPhone())) {
            throw new Exception(" Phone is required");

        }

        em.merge(customer);

    }

    public void update(Customer customer) throws Exception {
        if (StringUtils.isBlank(customer.getFirstName())) {
            throw new Exception(" First Name is required");

        }

        if (StringUtils.isBlank(customer.getLastName())) {
            throw new Exception("Last Name is required");

        }
        if (StringUtils.isBlank(customer.getEmail())) {
            throw new Exception(" Email is required");

        }
        if (StringUtils.isBlank(customer.getPhone())) {
            throw new Exception(" Phone is required");

        }
        em.merge(customer);

    }

    public void delete(Customer customer) {
        em.remove(em.find(Customer.class, customer.getId()));
    }

    public Customer getCustomer(Long id) {
        return em.find(Customer.class, id);

    }


    public List<Customer> list() {
        return em.createNamedQuery(Customer.FIND_ALL, Customer.class).getResultList();

    }

    public void innerJoin() {
        String hql = "select c.firstName from TMS.customers c inner join TMS.orders o on o.customer_id=c.id;";
        Query query = em.createQuery(hql);
        List<Object[]> list = query.getResultList();
        list.forEach(System.out::println);


    }

    public void leftJoin() {
        String hql = "select c.firstName from TMS.customers c left join TMS.orders o on o.customerId=c.id;";
        Query query = em.createQuery(hql);
        List<Object[]> list = query.getResultList();
        list.forEach(System.out::println);
    }

    public void crossJoin() {
        String hql = "from Customer c, Vehicle v";
        Query query = em.createQuery(hql);
        List<Object[]> list = query.getResultList();
        list.forEach(System.out::println);

    }

    public void groupBy() {
        //HQL group by and like example
        String hql = "select firstName,  count(c) from Customer c group by c.firstName";
        Query query = em.createQuery(hql);
        List<Object[]> list = query.getResultList();
        list.forEach(System.out::println);

    }

    public void orderBy() {
        Query query = em.createQuery("SELECT c FROM Customer c ORDER BY c.firstName DESC");
        List<Customer> resultList = query.getResultList();
        resultList.forEach(System.out::println);
    }

    public void limit() {
        Query query = em.createQuery("SELECT c FROM Customer c ORDER BY c.id DESC ").setMaxResults(1);
        List<Customer> resultList = query.getResultList();
        resultList.forEach(System.out::println);
    }
}