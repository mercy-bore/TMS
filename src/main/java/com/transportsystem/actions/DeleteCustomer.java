package com.transportsystem.actions;

import com.transportsystem.controllers.CustomerBeanI;
import com.transportsystem.model.Customer;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deletecustomer")

public class DeleteCustomer extends HttpServlet {
    @EJB
    CustomerBeanI customerBeanI;
    ServletContext servletCtx = null;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        servletCtx = config.getServletContext();

    }

    @SuppressWarnings("unchecked")
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Customer customer = new Customer();
        customer.setId(Long.parseLong(req.getParameter("id")));

        try {
            customerBeanI.delete(customer);
            res.sendRedirect("./clients.jsp");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}


