package com.transportsystem.actions;


import com.transportsystem.bean.OrderBeanI;
import com.transportsystem.model.Order;
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

@WebServlet("/addorder")
public class AddOrderPage extends HttpServlet {
    @EJB
    OrderBeanI orderBeanI;

    ServletContext servletCtx = null;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        servletCtx = config.getServletContext();
    }


    @SuppressWarnings("unchecked")
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Order order = new Order();
        try {
            BeanUtils.populate(order, req.getParameterMap());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        try {
            orderBeanI.add(order);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        res.sendRedirect("./vehicles.jsp");

    }
}
