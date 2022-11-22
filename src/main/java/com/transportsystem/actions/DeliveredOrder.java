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
import java.io.PrintWriter;
@WebServlet("/deliverorder")

public class DeliveredOrder extends HttpServlet {
    @EJB
    OrderBeanI loanBean;

    ServletContext servletCtx = null;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        servletCtx = config.getServletContext();

    }



    @SuppressWarnings("unchecked")
    @Override

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter wr = resp.getWriter();
        Order order = new Order();
        try {
            BeanUtils.populate(order, req.getParameterMap());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }


        order.setStatus("delivered");

        try {
            loanBean.update(order);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        resp.sendRedirect("./orders.jsp");
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter wr = resp.getWriter();
        Order order = new Order();
        try {
            BeanUtils.populate(order, req.getParameterMap());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }


        order.setStatus("delivered");

        try {
            loanBean.update(order);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        resp.sendRedirect("./orders.jsp");
    }
}
