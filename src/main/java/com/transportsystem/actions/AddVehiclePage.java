package com.transportsystem.actions;

import com.transportsystem.bean.VehicleBeanI;
import com.transportsystem.model.Vehicle;
import com.transportsystem.pdf.VehiclesList;
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


@WebServlet("/addvehicle")
public class AddVehiclePage extends HttpServlet {
    @EJB
    VehicleBeanI vehicleBeanI;

    ServletContext servletCtx = null;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        servletCtx = config.getServletContext();
    }


    @SuppressWarnings("unchecked")
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Vehicle vehicle = new Vehicle();
        try {
            BeanUtils.populate(vehicle, req.getParameterMap());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        try {
            System.out.println("generating report =============");
            VehiclesList.main(null);
            System.out.println("==================== generated");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            vehicleBeanI.add(vehicle);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        res.sendRedirect("./vehicles.jsp");

    }


}


