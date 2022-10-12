package com.transportsystem.pages;

import com.transportsystem.jdbc.DBConnection;
import com.transportsystem.model.Customer;
import com.transportsystem.model.Vehicle;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/home")
public class HomePage extends HttpServlet {
    ServletContext servletCtx = null;

    public void init(ServletConfig config) throws ServletException{
        super.init(config);

        servletCtx = config.getServletContext();

    }


    @SuppressWarnings("unchecked")
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        res.getWriter().print("<!DOCTYPE html>"
                + "<html> "
                + "<head> "
                + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./assets/CSS/style.css\"/>"
                + "</head>"
                + "<body>"
                +"<div class=\"bg-img\">"
                +"<div class=\"content\">"
                + "<h1>" + getServletContext().getAttribute("applicationLabel") + "</h1>"
                + "<br/>" +  vehicleTable(new Vehicle())
        +  "<p><a href='./logout'><button class=\"button\">Logout</button></a></p>"
                +"</div>"
                +"</div>"
                + "</body>"
                + "</html>");
    }

    @SuppressWarnings("unchecked")
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();

        res.getWriter().print("<!DOCTYPE html>"
                + "<html> "
                + "<head> "
                + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./assets/CSS/style.css\"/>"
                + "</head>"
                + "<body>"
                +"<div class=\"bg-img\">"
                +"<div class=\"content\">"
                + "<h1>" + getServletContext().getAttribute("applicationLabel") + "</h1>"
                + "<h2> Welcome: " + session.getAttribute("username") + "  Logged In At: " + session.getAttribute("loggedInTime") + "</h2>"
                + "<br/>" +  vehicleTable(new Vehicle())

        +  "<p><a href='./addvehicle'><button class=\"button\">Add Vehicle</button></a> <a href='./logout'><button class=\"button\">Logout</button></a></p>"
                +"</div>"
                +"</div>"
                + "</body>"
                + "</html>");
    }

    public String vehicleTable(Vehicle vehicleFilter) {
        List<Vehicle> vehicles1 = new ArrayList<Vehicle>();
        try {
            Connection connection = (Connection) servletCtx.getAttribute("dbConnection");
            Statement sqlStmt = connection.createStatement();

            ResultSet result = sqlStmt.executeQuery("select * from vehicle");
            while (result.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setType(result.getString("type"));
                vehicle.setPlateNo(result.getString("plateNo"));
                vehicle.setRoute(result.getString("route"));
                vehicle.setWeight(result.getString("weight"));

                vehicles1.add(vehicle);
            }

        }catch (Exception ex) {
            System.out.println(ex.getMessage());

        }

        String vehicleTable =

                 "<table >" +
                "<tr>" +
                        "<th>Vehicle Type</th>" +
                        "<th>Vehicle Number Plate</th>" +
                         "<th>Vehicle Weight</th>" +
                         "<th>Vehicle Route</th>" +

                         "<th></th>" +
                "</tr>";

        for (Vehicle vehicle:vehicles1)
            vehicleTable +=  "<tr>"
                    + "<td>" + vehicle.getType() + "</td>"
                    + "<td>" + vehicle.getPlateNo() + "</td>"
                    + "<td>" + vehicle.getWeight() + "</td>"
                    + "<td>" + vehicle.getRoute() + "</td>"

                    + "<td><a href=\"./updatevehicle?plateNo=" + vehicle.getPlateNo()+ "\">Edit</a>   | <a href=\"./deletevehicle?plateNo=" + vehicle.getPlateNo() +"\">Delete </td>"
                    + "</tr>";

        vehicleTable += "</table>" ;

        return vehicleTable;

    }
}

