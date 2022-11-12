package com.transportsystem.jdbc;

import com.transportsystem.model.Customer;
import com.transportsystem.model.Vehicle;

import java.sql.*;

// This class can be used to initialize the database connection
public class DBConnection {
    public static Connection getConnection() throws ClassNotFoundException {

        Connection con = null;
        try {
            // Initialize all the information regarding
            // Database Connection

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TMS",
                    "root", "@root123");
            System.out.println("****************** CONNECTED******************");
        } catch (SQLException e) {
            System.out.println(e);
        }
        return con;
    }




    public static int delete(String plateNo) {
        int status = 0;
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("delete from vehicle where plateNo=?");
            ps.setString(1, plateNo);
            status = ps.executeUpdate();

            con.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        return status;
    }

    public static Vehicle getVehicleById(String plateNo) {
        Vehicle vehicle = new Vehicle();

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from vehicle where plateNo=?");
            ps.setString(1, plateNo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                vehicle.setId(rs.getLong(1));
                vehicle.setType(rs.getString(2));
                vehicle.setPlateNo(rs.getString(3));
                vehicle.setRoute(rs.getString(4));
                vehicle.setWeight(rs.getString(5));
            }
            con.close();
        } catch (Exception ex1) {
            ex1.printStackTrace();
        }

        return vehicle;
    }

    public static Customer getCustomerbyEmail(String email) {
        Customer customer = new Customer();
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from customer where email=?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                customer.setId(rs.getLong(1));
                customer.setFirstName(rs.getString(2));
                customer.setLastName(rs.getString(3));
                customer.setEmail(rs.getString(3));
                customer.setPhone(rs.getString(3));
            }
            con.close();
        } catch (Exception ex1) {
            ex1.printStackTrace();
        }

        return customer;
    }
}
