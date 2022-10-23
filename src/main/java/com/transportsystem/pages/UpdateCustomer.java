package com.transportsystem.pages;

import com.transportsystem.controllers.CustomerController;
import com.transportsystem.controllers.VehicleController;
import com.transportsystem.jdbc.DBConnection;
import com.transportsystem.model.Customer;
import com.transportsystem.model.Vehicle;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

@WebServlet("/updatecustomer")
public class UpdateCustomer extends HttpServlet {

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
        response.setContentType("text/html");
        CustomerController cc = new CustomerController();
        Connection connection = (Connection) servletCtx.getAttribute("dbConnection");
        cc.update(connection,customer);
        response.sendRedirect("./clients.jsp");
    }

    }

