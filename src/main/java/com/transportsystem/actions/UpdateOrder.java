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

@WebServlet("/updateorder")

public class UpdateOrder extends HttpServlet {
    @EJB
    OrderBeanI orderBeanI;

    ServletContext servletCtx = null;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        servletCtx = config.getServletContext();

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Order order = new Order();
        try {
            BeanUtils.populate(order, request.getParameterMap());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        order.setId(order.getId());
        order.setCargo(order.getCargo());
        order.setStartLocation(order.getStartLocation());
        order.setDestination(order.getDestination());
        order.setDriver(order.getDriver());
        try {
            orderBeanI.update(order);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("./orders.jsp");
    }
}
