package com.transportsystem.bean;

import com.transportsystem.model.Address;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Remote
@Named("address")
public class AddressBean implements AddressBeanI {
    
    @PersistenceContext
    EntityManager em;


    public void add(Address address) throws Exception {

        em.merge(address);

    }

    public void update(Address address) throws Exception {

        em.merge(address);

    }





    public void delete(Address address) {
        em.remove(em.find(Address.class, address.getId()));
    }
    public List<Address> list() {
        return new ArrayList<Address>();
    }

    public List<Address> getList() {
        return em.createQuery("FROM Address a", Address.class).getResultList();
    }
}
