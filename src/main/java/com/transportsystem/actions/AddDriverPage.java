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


@WebServlet("/adddriver")
public class AddDriverPage extends HttpServlet {
    @EJB
    DriverBeanI driverBean;

    ServletContext servletCtx = null;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        servletCtx = config.getServletContext();
    }


    @SuppressWarnings("unchecked")
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Driver driver = new Driver();
        try {
            BeanUtils.populate(driver, req.getParameterMap());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        try {
            driverBean.add(driver);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        res.sendRedirect("./drivers.jsp");

    }


}
