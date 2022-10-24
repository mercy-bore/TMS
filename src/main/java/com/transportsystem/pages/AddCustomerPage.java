package com.transportsystem.pages;

import com.transportsystem.controllers.CustomerController;
import com.transportsystem.controllers.VehicleController;
import com.transportsystem.model.Customer;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/addcustomer")
public class AddCustomerPage extends HttpServlet {
    ServletContext servletCtx = null;

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

        if (StringUtils.isBlank(customer.getCargo())) {
            servletCtx.setAttribute("addCustomerError" , "Cargo is required<br/>");
            res.sendRedirect("./addcustomer.jsp");
            return;
        }
        if (StringUtils.isBlank(customer.getDeliveryType())) {
            servletCtx.setAttribute("addCustomerError" , "Delivery Type is required<br/>");
            res.sendRedirect("./addcustomer.jsp");
            return;
        }
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&");
        CustomerController cc = new CustomerController();
        System.out.println("^^^^^^^^^^^^^^^^^^");
        cc.add((Connection) servletCtx.getAttribute("dbConnection"), customer);
        System.out.println(customer + " added!");
        res.sendRedirect("./clients.jsp");

    }
}
