package com.transportsystem.controllers;

import com.transportsystem.model.Customer;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.sql.DataSource;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestScoped
@Named("cc")
public class CustomerBean implements Serializable {
    @Resource(lookup = "java:jboss/datasources/TMS")
    DataSource dataSource;
    private List<Customer> list;

    public void add(Customer customer) {
        if (customer == null || StringUtils.isBlank(customer.getFirstName()) || StringUtils.isBlank(customer.getLastName()))
            return;

        System.out.println("customer db connected!!!! " + customer.getFirstName());
        try {
            // Statement sqlStmt = connection.createStatement();
            Statement sqlStmt = dataSource.getConnection().createStatement();
            sqlStmt.executeUpdate("insert into customer(firstName, lastName, email, phone) " +
                    "values('" + customer.getFirstName() + "','" + customer.getLastName() + "','"  + customer.getEmail() + "','" + customer.getPhone() + "')");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }

    public void update(Customer customer) {

        try{
            // Statement sqlStmt = connection.createStatement();
            Statement sqlStmt = dataSource.getConnection().createStatement();
            sqlStmt.executeUpdate(
                    "update customer set firstName='" + customer.getFirstName() +
                            "', lastName='" + customer.getLastName() + "', email='" + customer.getEmail() + "', phone='"
                            + customer.getPhone() +  "' where id='" + customer.getId()+ "'");

        }
        catch(Exception ex1)
        {ex1.printStackTrace();
            System.out.println(ex1.getMessage());
        }

    }

    public void delete(Customer customer) {
        try{
            // Statement sqlStmt = connection.createStatement();
            Statement sqlStmt = dataSource.getConnection().createStatement();
            sqlStmt.executeUpdate("delete from  customer  where id='" + customer.getId() + "'");
            System.out.println(customer.getEmail());
        }
        catch(Exception ex1)
        {ex1.printStackTrace();}

    }
    public void getCustomerById(Customer customer) {
        try{
            // Statement sqlStmt = connection.createStatement();
            Statement sqlStmt = dataSource.getConnection().createStatement();
            sqlStmt.executeUpdate("select *  from  customer  where id='" + customer.getId() + "'" );
            System.out.println(customer.getEmail());
        }
        catch(Exception ex1)
        {ex1.printStackTrace();}

    }
     public Customer getCustomer(Long id) throws SQLException {
        Customer customer = new Customer();
        Map<String, String> criteria = new HashMap<String,String>()
        {{
            put("Id", Long.toString(id));
        }};;
        //    Statement sqlStmt = connection.createStatement();
        Statement sqlStmt = dataSource.getConnection().createStatement();
        ResultSet result = sqlStmt.executeQuery("select * from customer");
        while (result.next()){
            customer.setId(result.getLong("id"));
            customer.setFirstName(result.getString("firstName"));
            customer.setLastName(result.getString("lastName"));
            customer.setPhone(result.getString("phone"));
            customer.setEmail(result.getString("email"));
        }
        return customer;
    }

    public List<Customer> getList() {
        List<Customer> customers = new ArrayList<Customer>();

        try {
            // Statement sqlStmt = connection.createStatement();
            Statement sqlStmt = dataSource.getConnection().createStatement();
            ResultSet result = sqlStmt.executeQuery("select * from customer");
            while (result.next()) {
                Customer customer = new Customer();
                customer.setId(result.getLong("id"));
                customer.setFirstName(result.getString("firstName"));
                customer.setLastName(result.getString("lastName"));
                customer.setEmail(result.getString("email"));
                customer.setPhone(result.getString("phone"));

                customers.add(customer);
            }

        }catch (Exception ex) {
            System.out.println(ex.getMessage());

        }

        return customers;

    }
     public void setList(List<Customer> list) {
        this.list = list;
    }

}