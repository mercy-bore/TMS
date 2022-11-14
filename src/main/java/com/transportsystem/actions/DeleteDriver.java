package com.transportsystem.actions;

import com.transportsystem.bean.DriverBeanI;
import com.transportsystem.model.Driver;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deletedriver")

public class DeleteDriver extends HttpServlet {
    @EJB
    DriverBeanI driverBeanI;

    ServletContext servletCtx = null;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        servletCtx = config.getServletContext();

    }

    @SuppressWarnings("unchecked")
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Driver driver = new Driver();
        driver.setId(Long.parseLong(req.getParameter("id")));
        try {
            driverBeanI.delete(driver);
            res.sendRedirect("./drivers.jsp");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}

