package com.transportsystem.controllers;

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
    public List<Address> list(Address filter) {
        return new ArrayList<Address>();
    }

    public List<Address> getList() {
        return em.createQuery("FROM Address a", Address.class).getResultList();
    }
}
