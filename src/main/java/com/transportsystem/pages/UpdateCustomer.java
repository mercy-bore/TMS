package com.transportsystem.pages;

import com.transportsystem.controllers.CustomerController;
import com.transportsystem.jdbc.DBConnection;
import com.transportsystem.model.Customer;
import com.transportsystem.model.Vehicle;

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
        response.setContentType("text/html");

        Long id= Long.valueOf(request.getParameter("id"));
        String firstName=request.getParameter("firstName");
        String lastName=request.getParameter("lastName");
        String email=request.getParameter("email");
        String phone=request.getParameter("phone");
        String location=request.getParameter("location");
        String cargo=request.getParameter("cargo");
        String deliveryType=request.getParameter("deliveryType");

        Customer e1 = new Customer();
        e1.setId(id);
        e1.setFirstName(firstName);
        e1.setLastName(lastName);
        e1.setEmail(email);
        e1.setPhone(phone);
        e1.setLocation(location);
        e1.setCargo(cargo);
        e1.setDeliveryType(deliveryType);

        CustomerController cc = new CustomerController();
        cc.update((Connection) servletCtx.getAttribute("dbConnection"), e1);
        System.out.println("updated customer " + e1);
        response.sendRedirect("./clients.jsp");

    }
}
