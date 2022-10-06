package com.transportsystem.pages;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/index")
public class IndexPage extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.getWriter().print("<!DOCTYPE html>"
                + "<html> "
                + "<head>"
                + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./assets/CSS/style.css\"/>"
                + "<body>"
                +"<div class=\"bg-img\">"
                +"<div class=\"content\">"
                + "<h1>" + getServletContext().getAttribute("applicationLabel") + "</h1>"
                + "<p><a href='./signup'><button class=\"button\">Signup</button></a>         <a href='./login'><button class=\"button\">Login</button></a></p>"
                + "</div>"
                + "</div>"
                + "</body>"
                + "</html>");
    }
}