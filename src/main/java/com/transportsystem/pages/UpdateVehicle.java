package com.transportsystem.pages;

import com.transportsystem.controllers.VehicleController;
import com.transportsystem.jdbc.DBConnection;
import com.transportsystem.model.Customer;
import com.transportsystem.model.Vehicle;
import org.apache.commons.beanutils.BeanUtils;


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
        Vehicle vehicle = new Vehicle();
    try {
            BeanUtils.populate(vehicle, request.getParameterMap());

        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        response.setContentType("text/html");
            VehicleController vc = new VehicleController();
            Connection connection = (Connection) servletCtx.getAttribute("dbConnection");
            vc.update(connection,vehicle);
            response.sendRedirect("./vehicles.jsp");

        }
}
