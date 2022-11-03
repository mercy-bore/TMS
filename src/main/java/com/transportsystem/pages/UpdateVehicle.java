package com.transportsystem.pages;

import com.transportsystem.controllers.VehicleBean;
import com.transportsystem.model.Vehicle;
import org.apache.commons.beanutils.BeanUtils;

import javax.inject.Inject;
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
    @Inject
    VehicleBean vc;

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
            vc.update(vehicle);
            response.sendRedirect("./vehicles.jsp");

        }
}
