package com.transportsystem.pages;
import com.transportsystem.model.Vehicle;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


@WebServlet("/addvehicle")
public class VehiclePage extends HttpServlet {


    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        res.getWriter().print(this.addvehicle(null));
    }

    @SuppressWarnings("unchecked")
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        PrintWriter wr = res.getWriter();
        Vehicle vehicle = new Vehicle();
        try {
            BeanUtils.populate(vehicle, req.getParameterMap());

        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        if (StringUtils.isBlank(vehicle.getType())) {
            wr.print(this.addvehicle("Type is required<br/>"));
            return;
        }

        if (StringUtils.isBlank(vehicle.getPlateNo())) {
            wr.print(this.addvehicle("Number plate is required<br/>"));
            return;
        }

        HttpSession session = req.getSession();
        List<Vehicle> vehicles = (List<Vehicle>) session.getAttribute("vehicles");

        if (vehicles == null)
            vehicles = new ArrayList<>();

        vehicles.add(vehicle);
        session.setAttribute("vehicles", vehicles);

        RequestDispatcher dispatcher = req.getRequestDispatcher("./home");
        dispatcher.forward(req, res);

        }





    public String addvehicle(String actionError){
        return "<!DOCTYPE html>"
                + "<html> "
                + "<head> "
                + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./assets/CSS/style.css\"/>"
                + "</head>"
                + "<style> </style>"
                + "<body>"
                +"<div class=\"bg-img\">"
                +"<div class=\"content\">"
                + "<h1>" + getServletContext().getAttribute("applicationLabel") + "</h1>"
                + "<h2> Vehicle Form</h2>"
                + "<form action=\"./vehicle\" method=\"post\">"
                + "<table> "
                +"<input type=\"hidden\" name=\"action\" value=\"addvehicle\">"
                + "<tr> <td>Vehicle Type: </td> <td> <input type=\"text\" name=\"type\"> </td> </tr> "
                + "<tr> <td> Vehicle Plate Number: </td> <td> <input type=\"text\" name=\"plateNo\"> </td> </tr> "
                + "<tr> <td> <input class=\"button\" type=\"submit\" value=\"Submit\"></tr> "
                + "</table>"
                + "</form>"
                + "<span style=\"color:red\">" + (actionError != null? actionError : "") + "</span><br/>"
                + "<a href='./home'><button class=\"button\">Home</button></a>"
                + "</body>"
                +"</div>"
                +"</div>"
                + "</html>";
    }


}
