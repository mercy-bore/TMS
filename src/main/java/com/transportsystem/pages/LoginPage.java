package com.transportsystem.pages;


import com.transportsystem.model.User;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

@WebServlet(urlPatterns = "/login")
public class LoginPage extends HttpServlet {
    ServletContext servletCtx = null;
    public void init(ServletConfig config) throws ServletException{
        super.init(config);
        servletCtx = config.getServletContext();
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String password = req.getParameter("password");
        String username = req.getParameter("username");
        if (username == null || username.equalsIgnoreCase("")) {
            servletCtx.setAttribute("loginError" , "Username is required<br/>");
            res.sendRedirect("./login.jsp");
            return;
        }

        if (password == null || password.equalsIgnoreCase("")) {
            servletCtx.setAttribute("loginError" , "Password is required<br/>");
            res.sendRedirect("./login.jsp");
            return;
        }

        User user = this.login(username, password);
        if (user == null) {
            servletCtx.setAttribute("loginError" , "Invalid  username & password combination<br/>");
            res.sendRedirect("./login.jsp");
            return;
        }


        HttpSession session = req.getSession(true);

        session.setAttribute("username", user.getUsername());
        session.setAttribute("loggedInTime", "You Logged in At:" + new Date());


        RequestDispatcher dispatcher = req.getRequestDispatcher("./home.jsp");
        dispatcher.forward(req, res);

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
