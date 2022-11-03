package com.transportsystem.controllers;

import com.transportsystem.model.User;

import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@Stateless
@Remote
@TransactionManagement(TransactionManagementType.CONTAINER)
public class AuthBean {

    @Resource(lookup = "java:jboss/datasources/TMS")
    DataSource dataSource;

    public User login(String username, String password) {

        User user = null;
        try {
            Connection connection = dataSource.getConnection();
            Statement sqlStmt = connection.createStatement();
             ResultSet result = sqlStmt.executeQuery("select * from users where username='" + username + "' and " +
                    "password='" + password + "'");
            while (result.next()) {
                user = new User();
                user.setUsername(result.getString("username"));
                user.setPassword(result.getString("password"));
                System.out.println("username :: " + username);
                System.out.println("password ::  " + password);
            }

        }catch (Exception ex) {
            System.out.println("Log In Error: " + ex.getMessage());
        }

        return user;

    }
    
}
