package com.transportsystem.actions;

import com.transportsystem.bean.CustomerBeanI;
import com.transportsystem.model.Customer;
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

@WebServlet("/updatecustomer")
public class UpdateCustomer extends HttpServlet {
    @EJB
    CustomerBeanI customerBeanI;
    ServletContext servletCtx = null;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        servletCtx = config.getServletContext();

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customer customer = new Customer();
        try {
            BeanUtils.populate(customer, request.getParameterMap());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        customer.setId(customer.getId());
        customer.setFirstName(customer.getFirstName());
        customer.setLastName(customer.getLastName());
        customer.setPhone(customer.getPhone());
        customer.setEmail(customer.getEmail());
        try {
            customerBeanI.update(customer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("./clients.jsp");
    }

}