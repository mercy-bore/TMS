package com.transportsystem.controllers;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Remote
@Named("orderBean")
public class OrderBean implements OrderBeanI{
    @PersistenceContext
    EntityManager em;
}
