package com.transportsystem.actions;

import com.transportsystem.bean.OrderBeanI;
import com.transportsystem.model.Order;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteorder")

public class DeleteOrder extends HttpServlet {
    @EJB
    OrderBeanI orderBeanI;

    ServletContext servletCtx = null;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        servletCtx = config.getServletContext();

    }

    @SuppressWarnings("unchecked")
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        Order order = new Order();
        order.setId(Long.parseLong(req.getParameter("id")));
        try {
            orderBeanI.delete(order);
            res.sendRedirect("./orders.jsp");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}


