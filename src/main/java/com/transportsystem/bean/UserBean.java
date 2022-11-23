package com.transportsystem.bean;


import com.transportsystem.model.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

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
        if(user == null)
        throw new Exception("Invalid details");
         if(StringUtils.isBlank(user.getUsername()))
        throw new Exception("Username is required");
        if(StringUtils.isBlank(user.getFirstName()))
        throw new Exception("First name is required");
        if(StringUtils.isBlank(user.getLastName()))
        throw new Exception("Last name is required");
        if(StringUtils.isBlank(user.getEmail()))
        throw new Exception("Email is required");
        if(StringUtils.isBlank(user.getPhone()))
            throw new Exception("Phone is required");
        if(StringUtils.isBlank(user.getPassword()))
            throw new Exception("Password is required");
        if(StringUtils.isBlank(user.getConfirmPassword()))
            throw new Exception("Confirm password is required");
        if(!user.getPassword().equals(user.getConfirmPassword()))
        throw new Exception("Password and confirm password do not match");

        return em.merge(user);

    }

    public User login(User user) throws Exception {
        if (StringUtils.isBlank(user.getUsername()) && StringUtils.isBlank(user.getPassword()))
            throw new Exception("Invalid credentials.");
        List<User> userList = em.createQuery("FROM User c where c.username =:username " +
                        "and c.password =:password", User.class)
                .setParameter("username", user.getUsername())
                .setParameter("password", user.getPassword())
                .getResultList();

        if (userList == null || userList.isEmpty() || userList.get(0) == null)
            throw new Exception("Invalid  credentials.Try again.");
        userList.get(0).setBearerToken(DigestUtils
                .md5Hex(user.getUsername() + " SALT=CH10 " + user.getPassword()));
        return userList.get(0);
    }
    public boolean authMd5(String md5Hash) {

        if (md5Hash == null)
            return false;

        List<User> auths = em.createQuery("FROM User a", User.class)
                .getResultList();

        if (auths == null || auths.isEmpty())
            return false;

        boolean authenticated = false;
        for (User auth : auths) {
            if (DigestUtils.md5Hex(auth.getUsername() + " SALT=CH10 " + auth.getPassword()).equals(md5Hash)) {
                authenticated = true;
                break;
            }
        }

        return authenticated;
    }
}
