package com.transportsystem.controllers;

import com.transportsystem.model.Vehicle;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VehicleController implements Serializable {
    public void add(Connection connection, Vehicle vehicle) {
        if (vehicle == null || StringUtils.isBlank(vehicle.getPlateNo()) || StringUtils.isBlank(vehicle.getType()))
            return;

        try {

            Statement sqlStmt = connection.createStatement();
            sqlStmt.executeUpdate("insert into vehicle(type, plateNo, route, weight) " +
                    "values('" + vehicle.getType() + "','" + vehicle.getPlateNo() + "'," +
                    "'" + vehicle.getRoute() + "','" + vehicle.getWeight() + "')");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }

    }

    public void update(Connection connection,Vehicle vehicle) {
        try{
            Statement sqlStmt = connection.createStatement();
            sqlStmt.executeUpdate(
                    "update vehicle set  type='" + vehicle.getType() +
                            "', plateNo='" + vehicle.getPlateNo() + "',  weight='"
                            + vehicle.getWeight() + "', route='" + vehicle.getRoute() + "' where plateNo='" + vehicle.getPlateNo() + "'");

        }
        catch(Exception ex1)
        {ex1.printStackTrace();}

    }

    public void delete(Connection connection, Vehicle vehicle) {
        try{
            Statement sqlStmt = connection.createStatement();
            sqlStmt.executeUpdate("delete from  vehicle  where plateNo='" + vehicle.getPlateNo() + "'");
        }
        catch(Exception ex1)
        {ex1.printStackTrace();}

    }
    public void getVehicleById(Connection connection, Vehicle vehicle) {
        try{
            Statement sqlStmt = connection.createStatement();
            sqlStmt.executeUpdate("select * from  vehicle  where id='" + vehicle.getId() + "'");
        }
        catch(Exception ex1)
        {ex1.printStackTrace();}
    }



    public List<Vehicle> list(Connection connection, Vehicle filter) {
        List<Vehicle> vehicles = new ArrayList<Vehicle>();

        try {
            Statement sqlStmt = connection.createStatement();

            ResultSet result = sqlStmt.executeQuery("select * from vehicle");
            while (result.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setId(result.getLong("id"));
                vehicle.setType(result.getString("type"));
                vehicle.setPlateNo(result.getString("plateNo"));
                vehicle.setRoute(result.getString("route"));
                vehicle.setWeight(result.getString("weight"));

                vehicles.add(vehicle);
            }

        }catch (Exception ex) {
            System.out.println(ex.getMessage());

        }

        return vehicles;

    }


}
