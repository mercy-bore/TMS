package com.transportsystem.actions;

import com.transportsystem.bean.CustomerBeanI;
import com.transportsystem.model.Customer;
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


@WebServlet("/addcustomer")
public class AddCustomerPage extends HttpServlet {
    @EJB
    CustomerBeanI customerBeanI;

    ServletContext servletCtx = null;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        servletCtx = config.getServletContext();

    }

    @SuppressWarnings("unchecked")
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Customer customer = new Customer();
        try {
            BeanUtils.populate(customer, req.getParameterMap());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {
            customerBeanI.innerJoin();
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            customerBeanI.leftJoin();
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            customerBeanI.crossJoin();
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            customerBeanI.orderBy();
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            customerBeanI.groupBy();
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            customerBeanI.limit();
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            customerBeanI.limit();
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }try {
            customerBeanI.limit();
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }try {
            customerBeanI.limit();
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }try {
            customerBeanI.limit();
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        try {
            customerBeanI.add(customer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        res.sendRedirect("./clients.jsp");

    }
}
