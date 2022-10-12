package com.transportsystem.pages;


import com.transportsystem.model.User;
import com.transportsystem.model.Vehicle;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = "/login",initParams = {
        @WebInitParam(name = "username", value = "mercy"),
        @WebInitParam(name = "password", value = "chero")
})
public class LoginPage extends HttpServlet {


    ServletContext servletCtx = null;

    public void init(ServletConfig config) throws ServletException{
        super.init(config);

        servletCtx = config.getServletContext();
    }
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.getWriter().print(this.login(null));
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        PrintWriter wr = res.getWriter();

        String password = req.getParameter("password");
        String username = req.getParameter("username");
        System.out.println(username);
        if (username == null || username.equalsIgnoreCase("")) {
            wr.print(this.login("Username is required<br/>"));
            return;
        }

        if (password == null || password.equalsIgnoreCase("")) {
            wr.print(this.login("Password is required<br/>"));
            return;
        }

        User user = this.login(username, password);
        if (user == null ) {
            wr.print(this.login("Invalid username & password combination<br/>"));
            return;
        }


        HttpSession session = req.getSession(true);

        session.setAttribute("username", user.getUsername());
        session.setAttribute("profile", user.getProfile());
        session.setAttribute("loggedInTime", "Logged In Time:" + new Date());


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
    public User login(String username, String password) {

        User user = null;

        try {
            Connection connection = (Connection) servletCtx.getAttribute("dbConnection");
            Statement sqlStmt = connection.createStatement();
            ResultSet result = sqlStmt.executeQuery("select * from users where username='" + username + "' and " +
                    "password='" + password + "'");
            while (result.next()) {
                user = new User();
                user.setUsername(result.getString("username"));
                user.setPassword(result.getString("password"));
                System.out.println("username :: " + username);
                System.out.println("password ::  " + password);
                System.out.println("Hashed password :: " + DigestUtils.md5Hex(password));

            }

        }catch (Exception ex) {
            System.out.println("Log In Error: " + ex.getMessage());
        }

        return user;

    }


}
