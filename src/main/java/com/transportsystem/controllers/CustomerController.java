package com.transportsystem.controllers;

import com.transportsystem.model.Customer;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerController implements Serializable {
    public void add(Connection connection, Customer customer) {
        if (customer == null || StringUtils.isBlank(customer.getFirstName()) || StringUtils.isBlank(customer.getLastName()))
            return;
        System.out.println("customer db connected!!!! " + customer.getFirstName());
        try {
            Statement sqlStmt = connection.createStatement();
            sqlStmt.executeUpdate("insert into customer(firstName, lastName, email, phone, location, cargo, deliveryType) " +
                    "values('" + customer.getFirstName() + "','" + customer.getLastName() + "','"  + customer.getEmail() + "','" + customer.getPhone() + "','" + customer.getLocation() + "','" + customer.getCargo() + "','" + customer.getDeliveryType() + "')");
            System.out.println(customer);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        System.out.println("customer db connected!!!! "+customer.getFirstName());
    }

    public void update(Connection connection, Customer customer) {
        System.out.println("customer db connected!!!! ###############"+customer.getFirstName());

        try{
            Statement sqlStmt = connection.createStatement();
            sqlStmt.executeUpdate(
                    "update customer set firstName='" + customer.getFirstName() +
                            "', lastName='" + customer.getLastName() + "', email='" + customer.getEmail() + "', phone='"
                            + customer.getPhone() + "',  cargo='" + customer.getCargo() + "',   location='" + customer.getLocation() +
                            "' ,  deliveryType='" + customer.getDeliveryType() + "' where email='" + customer.getEmail()+ "'");

        }
        catch(Exception ex1)
        {ex1.printStackTrace();
            System.out.println(ex1.getMessage());
        }

    }

    public void delete(Connection connection, Customer customer) {
        try{
            Statement sqlStmt = connection.createStatement();
            sqlStmt.executeUpdate("delete from  customer  where email='" + customer.getEmail() + "'");
            System.out.println(customer.getEmail());
        }
        catch(Exception ex1)
        {ex1.printStackTrace();}

    }

    public List<Customer> list(Connection connection, Customer filter) {
        List<Customer> customers = new ArrayList<Customer>();

        try {
            Statement sqlStmt = connection.createStatement();

            ResultSet result = sqlStmt.executeQuery("select * from customer");
            while (result.next()) {
                Customer customer = new Customer();
                customer.setFirstName(result.getString("firstName"));
                customer.setLastName(result.getString("lastName"));
                customer.setLocation(result.getString("location"));
                customer.setEmail(result.getString("email"));
                customer.setPhone(result.getString("phone"));
                customer.setCargo(result.getString("cargo"));
                customer.setDeliveryType(result.getString("deliveryType"));


                customers.add(customer);
            }

        }catch (Exception ex) {
            System.out.println(ex.getMessage());

        }

        return customers;

    }
}
