package com.transportsystem.pages;

import com.transportsystem.model.Vehicle;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;

@WebServlet("/updatevehicle")

public class UpdateVehicle extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        res.getWriter().print(this.updatevehicle(null));
    }

        public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
            PrintWriter wr = res.getWriter();
            Vehicle vehicle = new Vehicle();
        try {
            BeanUtils.getArrayProperty(vehicle, req.getParameter("vehicle"));

        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        HttpSession session = req.getSession();
        List<Vehicle> vehicles = (List<Vehicle>) session.getAttribute("vehicles");
        for (Vehicle e : vehicles) {
            if (Objects.equals(e.getType(), req.getParameter("type"))) {
                vehicle.setPlateNo("plateNo");
                vehicle.setType("type");
                session.setAttribute("vehicles", vehicles);
            }
            RequestDispatcher dispatcher = req.getRequestDispatcher("./home");
            dispatcher.forward(req, res);
        }
    }

    public String updatevehicle(String actionError){
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
                +"<input type=\"hidden\" name=\"action\" value=\"updatevehicle\">"
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
