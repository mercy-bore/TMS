package com.transportsystem.pages;
import com.transportsystem.controllers.VehicleBean;
import javax.inject.Inject;

import com.transportsystem.jdbc.DBConnection;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/deletevehicle")

public class DeleteVehicle extends HttpServlet{
    @Inject
    VehicleBean cc;
    
    ServletContext servletCtx = null;

    public void init(ServletConfig config) throws ServletException{
        super.init(config);

        servletCtx = config.getServletContext();

    }
    @SuppressWarnings("unchecked")
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String sid=req.getParameter("plateNo");
        DBConnection.delete(sid);
        res.sendRedirect("./vehicles.jsp");

    }
}


