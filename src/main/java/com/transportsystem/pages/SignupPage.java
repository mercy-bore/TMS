package com.transportsystem.pages;

import com.transportsystem.model.User;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
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

        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");
        String email = req.getParameter("email");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String username = req.getParameter("username");
        String phone = req.getParameter("phone");


        String actionError = "";
        if (email == null || email.equalsIgnoreCase(""))
            actionError = "Email is required<br/>";

        if (password == null || password.equalsIgnoreCase(""))
            actionError += "Password is required<br/>";

        if (confirmPassword == null || confirmPassword.equalsIgnoreCase(""))
            actionError += "Confirm password is required<br/>";

        if (password != null && confirmPassword != null && !password.equals(confirmPassword))
            actionError += "Password & confirm password do not match<br/>";

        if((password != null && confirmPassword != null) && password.equals(confirmPassword)) {
            User user = new User();

            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setUsername(username);
            user.setEmail(email);
            user.setPhone(phone);
            user.setPassword(password);
            user.setConfirmPassword(confirmPassword);

            this.insertUsers(firstName, lastName, username, email, phone, password, confirmPassword);

            User newuser = new User();
            System.out.println("===============++++++++++++++");
            newuser.setUsername(username);
        }
        
        servletCtx.setAttribute("registerError" , actionError);
        if (actionError.equals("")) {
            this.insertUsers(firstName, lastName, username, email, phone,  password, confirmPassword);
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
        public void insertUsers(String firstName, String lastName, String username, String email, String phone, String password, String confirmPassword){
            try {
                Connection connection = (Connection) servletCtx.getAttribute("dbConnection");
                Statement statement = connection.createStatement();
                statement.executeUpdate("insert into users(firstName, lastName,username, email, phone, password, confirmPassword) " +
                        "values('" + firstName + "','" + lastName + "','" + username + "','" + email + "' ,'" + phone + "' ,'" + password + "' ,'" + confirmPassword + "')");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

}
