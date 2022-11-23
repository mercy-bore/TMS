package com.transportsystem.actions;

import com.transportsystem.bean.UserBeanI;
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
import java.io.IOException;

@WebServlet("/signup")
public class SignupPage extends HttpServlet {

    @EJB
    UserBeanI userBean;

    ServletContext servletCtx = null;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        servletCtx = config.getServletContext();
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        User user = new User();

        try {
            BeanUtils.populate(user, req.getParameterMap());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        
    }
    System.out.println(user);


        try {
            userBean.register(user);
            res.sendRedirect("./login.jsp");

        } catch (Exception ex) {
            servletCtx.setAttribute("registerError", ex.getMessage());
            res.sendRedirect("./signup.jsp");
        }
    }


}
