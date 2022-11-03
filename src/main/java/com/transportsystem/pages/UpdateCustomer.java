package com.transportsystem.pages;

import com.transportsystem.controllers.CustomerBean;
import com.transportsystem.model.Customer;
import org.apache.commons.beanutils.BeanUtils;

import javax.inject.Inject;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updatecustomer")
public class UpdateCustomer extends HttpServlet {
    @Inject
    CustomerBean cc;

    ServletContext servletCtx = null;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        servletCtx = config.getServletContext();

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customer customer = new Customer();
        try {
            BeanUtils.populate(customer, request.getParameterMap());

        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        cc.update(customer);
        response.sendRedirect("./clients.jsp");
    }

}