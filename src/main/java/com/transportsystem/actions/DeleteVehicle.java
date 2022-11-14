package com.transportsystem.actions;

import com.transportsystem.bean.VehicleBeanI;
import com.transportsystem.model.Vehicle;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/deletevehicle")

public class DeleteVehicle extends HttpServlet {
    @EJB
    VehicleBeanI vehicleBeanI;

    ServletContext servletCtx = null;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        servletCtx = config.getServletContext();

    }

    @SuppressWarnings("unchecked")
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        Vehicle vehicle = new Vehicle();
        vehicle.setId(Long.parseLong(req.getParameter("id")));
        try {
            vehicleBeanI.delete(vehicle);
            res.sendRedirect("./vehicles.jsp");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}


