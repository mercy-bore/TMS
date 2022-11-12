package com.transportsystem.actions;

import com.transportsystem.controllers.VehicleBeanI;
import com.transportsystem.model.Vehicle;
import org.apache.commons.beanutils.BeanUtils;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updatevehicle")

public class UpdateVehicle extends HttpServlet {
    @EJB
    VehicleBeanI vehicleBeanI;

    ServletContext servletCtx = null;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        servletCtx = config.getServletContext();

    }

   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Vehicle vehicle = new Vehicle();
        try {
            BeanUtils.populate(vehicle, request.getParameterMap());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        vehicle.setId(vehicle.getId());
        vehicle.setType(vehicle.getType());
        vehicle.setPlateNo(vehicle.getPlateNo());
        vehicle.setWeight(vehicle.getWeight());
        vehicle.setRoute(vehicle.getRoute());
        try {
            vehicleBeanI.update(vehicle);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("./vehicles.jsp");
    }
}
