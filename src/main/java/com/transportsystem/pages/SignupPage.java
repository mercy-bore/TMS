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
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.getWriter().print(this.signup(null));
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter wr = res.getWriter();

        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");
        String email = req.getParameter("email");
        String username = req.getParameter("username");

        String actionError = "";
        if (email == null || email.equalsIgnoreCase(""))
            actionError = "Email is required<br/>";

        if (password == null || password.equalsIgnoreCase(""))
            actionError += "Password is required<br/>";

        if (confirmPassword == null || confirmPassword.equalsIgnoreCase(""))
            actionError += "Confirm password is required<br/>";

        if (password != null && confirmPassword != null && !password.equals(confirmPassword))
            actionError += "Password & confirm password do not match<br/>";

        if (actionError.equals("")) {
            this.insert(email, password);
            res.sendRedirect("./login");
        } else
            wr.print(this.signup(actionError));
    }
    public String signup(String actionError){
        return "<!DOCTYPE html>"
                + "<html> "
                + "<head> "
                + "<title>TMS - Signup Page</title>"
                + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./assets/CSS/style.css\"/>"
                + "</head>"
                + "<body>"
                +"<div class=\"bg-img\">"
                +"<div class=\"content\">"
                +"<header>Transport Management System</header>"
                +"<header>Signup Form </header>"
                + "<form action=\"./signup\" method=\"post\">"
                +"<input type=\"hidden\" name=\"action\" value=\"signup\">"
                +"<div class=\"field space\">"
                + "<input type=\"text\" name=\"username\" placeholder=\"Username\">"
                +"</div>"
                +"<div class=\"field space\">"
                + "<input type=\"text\" name=\"fname\" required placeholder=\"First Name\">"
                +"</div>"
                +"<div class=\"field space\">"
                + "<input type=\"text\" name=\"lname\" required placeholder=\"Last Name\">"
                +"</div>"
                +"<div class=\"field space\">"
                + "<input type=\"text\" name=\"phone\" required placeholder=\"Phone No\">"
                +"</div>"
                +"<div class=\"field space\">"
                + "<input type=\"email\" name=\"email\" placeholder=\"Email\">"
                +"</div>"
                +"<div class=\"field space\">"
                + "<input type=\"password\" name=\"password\"  placeholder=\"Password\">"
                +"</div>"
                +"<div class=\"field space\">"
                + "<input type=\"password\" name=\"confirmPassword\"  placeholder=\"Confirm Password\">"
                +"</div>"
                +"<div class=\"field space\">"
                + "<tr> <td> <input type=\"submit\" value=\"Signup\"></tr> "
                +"</div>"
                + "</form>"
                + "<span style=\"color:yellow\">" + (actionError != null? actionError : "") + "</span>"
                +"</div>"
                +"</div>"
                + "</body>"
                + "</html>";
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

        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }

    }
}
