package com.transportsystem.pages;
import com.transportsystem.controllers.VehicleBean;
import com.transportsystem.model.Vehicle;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import javax.inject.Inject;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/addvehicle")
public class AddVehiclePage extends HttpServlet {
    VehicleBean vehicleBean;
    Vehicle vehicle = new Vehicle();

    ServletContext servletCtx = null;

    public void init(ServletConfig config) throws ServletException{
        super.init(config);
        servletCtx = config.getServletContext();
    }


    @SuppressWarnings("unchecked")
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        try {
            BeanUtils.populate(vehicle, req.getParameterMap());

        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }


        if (StringUtils.isBlank(vehicle.getType())) {
            servletCtx.setAttribute("addVehicleError" , "Type is required<br/>");
            res.sendRedirect("./addvehicle.jsp");
            return;
        }

        if (StringUtils.isBlank(vehicle.getPlateNo())) {
            servletCtx.setAttribute("addVehicleError" , "Plate No is required<br/>");
            res.sendRedirect("./addvehicle.jsp");
            return;
        }
        if (StringUtils.isBlank(vehicle.getWeight())) {
            servletCtx.setAttribute("addVehicleError" , "Weight is required<br/>");
            res.sendRedirect("./addvehicle.jsp");
            return;
        }
        if (StringUtils.isBlank(vehicle.getRoute())) {
            servletCtx.setAttribute("addVehicleError" , "Route is required<br/>");
            res.sendRedirect("./addvehicle.jsp");
            return;
        }
        addVehicle(vehicleBean);
        res.sendRedirect("./vehicles.jsp");

        }
    @Inject
    public void addVehicle(VehicleBean vehicleBean){
        vehicleBean.add(vehicle);


}

}
