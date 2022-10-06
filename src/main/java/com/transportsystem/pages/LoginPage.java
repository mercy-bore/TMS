package com.transportsystem.pages;


import com.transportsystem.model.Vehicle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/login")
public class LoginPage extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.getWriter().print(this.login(null));
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        PrintWriter wr = res.getWriter();

        String password = req.getParameter("password");
        String username = req.getParameter("username");

        if (username == null || username.equalsIgnoreCase("")) {
            wr.print(this.login("Username is required<br/>"));
            return;
        }

        if (password == null || password.equalsIgnoreCase("")) {
            wr.print(this.login("Password is required<br/>"));
            return;
        }

//        if (!username.equals(getServletConfig().getInitParameter("username")) && !password.equals(getServletConfig().getInitParameter("password"))) {
//            wr.print(this.login("Invalid email & password combination<br/>"));
//            return;
//        }

        HttpSession session = req.getSession(true);
        session.setAttribute("loggedInTime", "Logged In Time:" + new Date());

        List<Vehicle> vehicles  = new ArrayList<Vehicle>();
        session.setAttribute("vehicles", vehicles);



        RequestDispatcher dispatcher = req.getRequestDispatcher("./home");
        dispatcher.forward(req, res);

    }
    public String login(String actionError){
        return  "<!DOCTYPE html>"
                + "<html> "
                + "<head> "
                + "<title>TMS - Login Page</title>"
                + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./assets/CSS/style.css\"/>"
                + "</head>"
                + "<body>"
                +"<div class=\"bg-img\">"
                +"<div class=\"content\">"
                +"<header>Transport Management System</header>"
                +"<header>Login Form </header>"
                + "<form action=\"./login\" method=\"post\">"
                + "<input type=\"hidden\" name=\"action\" value=\"login\">"
                +"<div class=\"field space\">"
                + "<input type=\"text\" name=\"username\" placeholder=\"Username/Email\">"
                +"</div>"
                +"<div class=\"field space\">"
                + "<input type=\"Password\" name=\"password\" placeholder=\"Password\">"
                +"</div>"
                +"<div class=\"field space\">"
                + "<tr> <td> <input type=\"submit\" value=\"Login\"></tr> "
                +"</div>"
                + "</form>"
                + "<span style=\"color:yellow\">" + (actionError != null? actionError : "") + "</span>"
                +"</div>"
                +"</div>"
                + "</body>"
                + "</html>";
    }



}
