package com.transportsystem.pages;

import com.transportsystem.jdbc.DBConnection;

import javax.servlet.RequestDispatcher;
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

    ServletContext servletCtx = null;

    public void init(ServletConfig config) throws ServletException{
        super.init(config);

        servletCtx = config.getServletContext();

    }
    @SuppressWarnings("unchecked")
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        Long sid= Long.valueOf(req.getParameter("id"));
        DBConnection.delete(String.valueOf(sid));
        res.sendRedirect("./clients.jsp");

    }
}


