package com.transportsystem.actions;


import com.transportsystem.bean.DriverBeanI;
import com.transportsystem.model.Driver;
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

@WebServlet("/updatedriver")

public class UpdateDriver extends HttpServlet {
    @EJB
    DriverBeanI driverBeanI;

    ServletContext servletCtx = null;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        servletCtx = config.getServletContext();

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            Driver driver = new Driver();
            try {
            BeanUtils.populate(driver, request.getParameterMap());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        driver.setId(driver.getId());
        driver.setFirstName(driver.getFirstName());
        driver.setLastName(driver.getLastName());
        driver.setPhone(driver.getPhone());
        driver.setEmail(driver.getEmail());
        try {
            driverBeanI.update(driver);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("./drivers.jsp");
    }
}
