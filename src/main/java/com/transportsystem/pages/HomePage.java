package com.transportsystem.pages;

import com.transportsystem.model.Vehicle;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/home")
public class HomePage extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @SuppressWarnings("unchecked")
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        res.getWriter().print("<!DOCTYPE html>"
                + "<html> "
                + "<head> "
                + "</head>"
                + "<body>"
                + "<h1>" + getServletContext().getAttribute("applicationLabel") + "</h1>"
                + "<br/>" + vehicleTable((List<Vehicle>) session.getAttribute("vehicles"))
                + "<br/>Logout <a href='./logout'>Logout</a><br/>"
                + "</body>"
                + "</html>");
    }

    @SuppressWarnings("unchecked")
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session == null || session.getId() == null)
            res.sendRedirect("./index");


        res.getWriter().print("<!DOCTYPE html>"
                + "<html> "
                + "<head> "
                + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./assets/CSS/style.css\"/>"
                + "</head>"
                + "<body>"
                +"<div class=\"bg-img\">"
                +"<div class=\"content\">"
                + "<h1>" + getServletContext().getAttribute("applicationLabel") + "</h1>"
                + "<h2> Welcome " + req.getParameter("username") + "</h2>" + "<p> You Logged In At: " + session.getAttribute("loggedInTime") + "</p>"
                + "<br/>" + vehicleTable((List<Vehicle>) session.getAttribute("vehicles"))
                +  "<p><a href='./vehicle?action=addvehicle'><button class=\"button\">Add Vehicle</button></a>         <a href='./logout'><button class=\"button\">Logout</button></a></p>"
                +"</div>"
                +"</div>"
                + "</body>"
                + "</html>");
    }

    public String vehicleTable(List<Vehicle> vehicles) {

        if (vehicles == null)
            vehicles = new ArrayList<Vehicle>();

        String vehicleTable = "<table >" +
                "<tr>" +
                "<th>Vehicle Type</th>" +
                "<th>Vehicle Number Plate</th>" +
                "<th></th>" +
                "</tr>";

        for (Vehicle vehicle : vehicles)
            vehicleTable += "<tr>"
                    + "<td>" + vehicle.getType() + "</td>"
                    + "<td>" + vehicle.getPlateNo() + "</td>"
                    + "<td><a href='./vehicle?action=updatevehicle'><button class=\"button\">Edit</button></a>   | <a href='./vehicle?action=deletevehicle'><button class=\"button\">Delete</button></a> </td>"
                    + "</tr>";

        vehicleTable += "</table>";

        return vehicleTable;

    }
}

