package com.transportsystem.pages;

import com.transportsystem.controllers.CustomerBean;
import com.transportsystem.model.Customer;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import javax.inject.Inject;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addcustomer")
public class AddCustomerPage extends HttpServlet {
    @Inject
    CustomerBean cc;
    ServletContext servletCtx = null;
    @Inject
    public AddCustomerPage(CustomerBean cc){
        this.cc = cc;
    }
    public void init(ServletConfig config) throws ServletException{
        super.init(config);

        servletCtx = config.getServletContext();

    }

    @SuppressWarnings("unchecked")
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        Customer customer = new Customer();
        try {
            BeanUtils.populate(customer, req.getParameterMap());

        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        res.setContentType("text/html");


        if (StringUtils.isBlank(customer.getFirstName())) {
            servletCtx.setAttribute("addCustomerError" , "First Name is required<br/>");
            res.sendRedirect("./addcustomer.jsp");
            return;
        }

        if (StringUtils.isBlank(customer.getLastName())) {
            servletCtx.setAttribute("addCustomerError" , "Last Name is required<br/>");
            res.sendRedirect("./addcustomer.jsp");
            return;
        }
        if (StringUtils.isBlank(customer.getEmail())) {
            servletCtx.setAttribute("addCustomerError" , "Email is required<br/>");
            res.sendRedirect("./addcustomer.jsp");
            return;
        }
        if (StringUtils.isBlank(customer.getPhone())) {
            servletCtx.setAttribute("addCustomerError" , "Phone Number is required<br/>");
            res.sendRedirect("./addcustomer.jsp");
            return;
        }

       
        cc.add(customer);
        res.sendRedirect("./clients.jsp");

    }
}
