package com.transportsystem.controllers;


import com.transportsystem.model.User;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
@Remote
@TransactionManagement(TransactionManagementType.CONTAINER)

public class UserBean implements UserBeanI {

    @PersistenceContext
    EntityManager em;
    @TransactionAttribute(TransactionAttributeType.REQUIRED)

    public User register(User user) throws Exception {
        if (user == null)
            throw new Exception("Invalid details");
        if (user.getFirstName() == null)
            throw new Exception("First name is required");
        if (user.getLastName() == null)
            throw new Exception("Last name is required");
        if (user.getEmail() == null)
            throw new Exception("Email is required");
        if (user.getPhone() == null)
            throw new Exception("Phone is required");
        if (user.getPassword() == null)
            throw new Exception("Password is required");

        if (user.getConfirmPassword() == null)
            throw new Exception("/Confirm password is required");

        return em.merge(user);

    }

    public User login(User user) throws Exception {
        if (user.getUsername() == null && user.getPassword() == null)
            throw new Exception("invalid credentials");
        List<User> userList = em.createQuery("FROM User c where c.username =:username " +
                        "and c.password =:password", User.class)
                .setParameter("username", user.getUsername())
                .setParameter("password", user.getPassword())
                .getResultList();

        if (userList == null || userList.isEmpty() || userList.get(0) == null)
            throw new Exception("invalid  credentials");

        return userList.get(0);
    }
}
