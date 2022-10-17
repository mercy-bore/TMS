package com.transportsystem.pages;

import com.transportsystem.jdbc.DBConnection;
import com.transportsystem.model.Customer;
import com.transportsystem.model.Vehicle;


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
    @SuppressWarnings("unchecked")
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        String plateNo=req.getParameter("plateNo");
        System.out.println("777777777777777777");
        System.out.println(plateNo);
        Vehicle vehicle= DBConnection.getVehicleById(plateNo);
        System.out.println(vehicle.getPlateNo());
        System.out.println("vehicle to be updated: " + vehicle);
        PrintWriter out=res.getWriter();
        out.println(
                "<!DOCTYPE html>"
                        + "<html> "
                        + "<head> "
                        + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./assets/CSS/style.css\"/>"
                        + "</head>"
                        + "<style> </style>"
                        + "<body>"
                        +"<div class=\"bg-img\">"
                        +"<div class=\"content\">"
                        + "<h1>" + getServletContext().getAttribute("applicationLabel") + "</h1>"
                        + "<h2> Update Vehicle Form</h2>"
                        + "<form action=\"./updatevehicle?plateNo=" + vehicle.getPlateNo() + "\" method=\"post\">"
                        + "<table> "
                        + "<tr> <td> Vehicle ID: </td> <td> <input type=\"text\" name=\"id\" value="+ vehicle.getId() + "> </td> </tr>"
                        + "<tr> <td> Vehicle Type: </td> <td> <input type=\"text\" name=\"type\" value="+ vehicle.getType() + "> </td> </tr>"
                        + "<tr> <td>Vehicle Plate Number: </td> <td> <input type=\"text\" name=\"plateNo\" value=" + vehicle.getPlateNo() + "> </td> </tr>"
                        + "<tr> <td>Vehicle Weight: </td> <td> <input type=\"text\" name=\"weight\" value=" + vehicle.getWeight() + "> </td> </tr>"
                        + "<tr> <td>Vehicle Route: </td> <td> <input type=\"text\" name=\"route\" value=" + vehicle.getRoute() + "> </td> </tr>"
                        + "<tr> <td> <input class=\"button\" type=\"submit\" value=\"Submit\"></tr>"
                        + "</table>"
                        + "</form>"
                        + "<a href='./home'><button class=\"button\">Home</button></a>"
                        + "</body>"
                        +"</div>"
                        +"</div>"
                        + "</html>");
    }



        public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setContentType("text/html");
            PrintWriter out=response.getWriter();

            Long id= Long.valueOf(request.getParameter("id"));
            String type=request.getParameter("type");
            String plateNo=request.getParameter("plateNo");
            String route=request.getParameter("route");
            String weight=request.getParameter("weight");

            Vehicle e1=new Vehicle();
            e1.setId(id);
            e1.setType(type);
            e1.setPlateNo(plateNo);
            e1.setRoute(route);
            e1.setWeight(weight);
            System.out.println("before...");
            System.out.println(e1);
            DBConnection.update(e1);
            System.out.println("updated....");
            System.out.println(e1);
            response.sendRedirect("./home");
            out.close();
        }
}
