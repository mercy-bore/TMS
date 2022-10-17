package com.transportsystem.pages;

import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class SignupPage extends HttpServlet {
    ServletContext servletCtx = null;

    public void init(ServletConfig config) throws ServletException{
        super.init(config);

        servletCtx = config.getServletContext();
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter wr = res.getWriter();

        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");
        String email = req.getParameter("email");

        String actionError = "";
        if (email == null || email.equalsIgnoreCase(""))
            actionError = "Email is required<br/>";

        if (password == null || password.equalsIgnoreCase(""))
            actionError += "Password is required<br/>";

        if (confirmPassword == null || confirmPassword.equalsIgnoreCase(""))
            actionError += "Confirm password is required<br/>";

        if (password != null && confirmPassword != null && !password.equals(confirmPassword))
            actionError += "Password & confirm password do not match<br/>";

        servletCtx.setAttribute("registerError" , actionError);
        if (actionError.equals("")) {
            this.insert(email, password);
            res.sendRedirect("./login.jsp");
        } else
            res.sendRedirect("./signup.jsp");
    }


    public void insert(String username, String password) {
        try {
            Connection connection = (Connection) servletCtx.getAttribute("dbConnection");
            System.out.println("creating new user ");
            Statement sqlStmt = connection.createStatement();
            sqlStmt.executeUpdate("insert into users(username,password) " +
                    "values('" + username.trim() + "','" + password + "')");
            System.out.println("username :: " + username);
            System.out.println("password :: " + password);
            System.out.println("hashed password :: " + DigestUtils.md5Hex(password));
            System.out.println("**************** SIGNING UP *****************");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }

    }
}
