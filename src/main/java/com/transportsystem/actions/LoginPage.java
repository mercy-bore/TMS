package com.transportsystem.actions;


import com.transportsystem.controllers.UserBeanI;
import com.transportsystem.model.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet(urlPatterns = "/login")
public class LoginPage extends HttpServlet {
    @EJB
    UserBeanI userBeanI;
    ServletContext servletCtx = null;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        servletCtx = config.getServletContext();
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        User user = new User();
        user.setUsername("username");
        user.setPassword("password");
        try {
            BeanUtils.populate(user, req.getParameterMap());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {

            User users = userBeanI.login(user);
            HttpSession session = req.getSession(true);

            session.setAttribute("username", user.getUsername());
            session.setAttribute("loggedInTime", "You Logged in On: " + new Date());
            res.sendRedirect("./home.jsp");

        } catch (Exception e) {
            servletCtx.setAttribute("loginError", e.getMessage());
            res.sendRedirect("./login.jsp");

        }


    }
}