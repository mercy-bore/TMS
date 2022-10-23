package com.transportsystem.jdbc;

import com.transportsystem.model.Customer;
import com.transportsystem.model.Vehicle;

import java.awt.*;
import java.sql.*;

// This class can be used to initialize the database connection
public class DBConnection {
    public static Connection getConnection() throws ClassNotFoundException {

        Connection con = null;
        try {
            // Initialize all the information regarding
            // Database Connection

            con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/TMS",
                    "root", "@root123");
            System.out.println("****************** CONNECTED******************");
        } catch (SQLException e) {
            System.out.println(e);
        }
        return con;
    }

    public static int save(Vehicle vehicle){
        int status=0;
        try{
            Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(
                    "insert into vehicle (id, type, plateNo, route, weight) values (?,?,?,?,?)");
            ps.setLong(1,vehicle.getId());
            ps.setString(2,vehicle.getType());
            ps.setString(3,vehicle.getPlateNo());
            ps.setString(4,vehicle.getRoute());
            ps.setString(5,vehicle.getWeight());

            status=ps.executeUpdate();

            con.close();
        }
        catch(Exception ex1)
        {
            ex1.printStackTrace();
        }

        return status;
    }
    public static void update(Vehicle vehicle){
        try{
            Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(
                    "update vehicle set id=?, type=?, plateNo=?, route=?, weight=? where plateNo=?");
            String plateNo= vehicle.getPlateNo();
            ps.setLong(2,vehicle.getId());
            ps.setString(3,vehicle.getType());
            ps.setString(4,vehicle.getPlateNo());
            ps.setString(5,vehicle.getRoute());
            ps.setString(6,vehicle.getWeight());


            ps.executeUpdate();
            System.out.println(ps.executeUpdate());
            con.close();
            System.out.println("vehicle has been updated");
        }
        catch(Exception ex1)
        {ex1.printStackTrace();}

    }
    public static int delete(String plateNo){
        int status=0;
        try{
            Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement("delete from vehicle where plateNo=?");
            ps.setString(1,plateNo);
            status=ps.executeUpdate();

            con.close();
        }catch(Exception e1){e1.printStackTrace();}

        return status;
    }
    public static Vehicle getVehicleById(String plateNo){
        Vehicle vehicle = new Vehicle();

        try{
            Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement("select * from vehicle where plateNo=?");
            ps.setString(1,plateNo);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                vehicle.setId(rs.getLong(1));
                vehicle.setType(rs.getString(2));
                vehicle.setPlateNo(rs.getString(3));
                vehicle.setRoute(rs.getString(4));
                vehicle.setWeight(rs.getString(5));
            }
            con.close();
        }catch(Exception ex1){ex1.printStackTrace();}

        return vehicle;
    }
    public static Customer getCustomerbyEmail(String email){
Customer customer = new Customer();
        try{
            Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement("select * from customer where email=?");
            ps.setString(1,email);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                customer.setId(rs.getLong(1));
                customer.setFirstName(rs.getString(2));
                customer.setLastName(rs.getString(3));
                customer.setEmail(rs.getString(3));
                customer.setPhone(rs.getString(3));
                customer.setLocation(rs.getString(3));
                customer.setCargo(rs.getString(3));
                customer.setDeliveryType(rs.getString(3));
            }
            con.close();
        }catch(Exception ex1){ex1.printStackTrace();}

        return customer;
    }
    public static List getAllVehicles(List vehicles){
        List list= new List();

        try{
            Connection con1=DBConnection.getConnection();
            PreparedStatement ps1=con1.prepareStatement("select * from vehicle");
            ResultSet rs1=ps1.executeQuery();
            while(rs1.next()){
                Vehicle e1=new Vehicle();
                e1.setType(rs1.getString(1));
                e1.setPlateNo(rs1.getString(2));
                e1.setRoute(rs1.getString(3));
                e1.setWeight(rs1.getString(4));
                list.add(String.valueOf(e1));
            }
            con1.close();
        }catch(Exception e1){e1.printStackTrace();}

        return list;
    }
}
