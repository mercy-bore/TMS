package com.transportsystem.pages;

import com.transportsystem.controllers.VehicleController;
import com.transportsystem.jdbc.DBConnection;
import com.transportsystem.model.Customer;
import com.transportsystem.model.Vehicle;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;
import java.util.Objects;

@WebServlet("/updatevehicle")

public class UpdateVehicle extends HttpServlet {
    ServletContext servletCtx = null;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        servletCtx = config.getServletContext();

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setContentType("text/html");

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
            VehicleController vc = new VehicleController();
            vc.update((Connection) servletCtx.getAttribute("dbConnection"), e1);

            response.sendRedirect("./vehicles.jsp");

        }
}
