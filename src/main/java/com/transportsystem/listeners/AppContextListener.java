package com.transportsystem.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;

@WebListener
public class AppContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent ctxe){
        System.out.println();
        System.out.println();
        System.out.print("Transport Management System ..... Firing up");
        System.out.println();
        System.out.println();
        ServletContext ctx = ctxe.getServletContext();
        ctx.setAttribute("applicationLabel", "Transport Management System");

        try {
            System.out.print("Establishing connections....");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/TMS",
                    "root", "@root123");
            ctx.setAttribute("dbConnection", connection);
            System.out.print("Connection Established....");
        } catch (Exception ex) {
            System.out.println("Sorry, Connection Not Established....: " + ex.getMessage());

        }

    }

    public void contextDestroyed(ServletContextEvent ctxe) {
        try {
            ServletContext ctx = ctxe.getServletContext();
            Connection connection = (Connection) ctx.getAttribute("dbConnection");
            connection.close();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println();
        System.out.println();
        System.out.print("************      TMS Application stopped.      ************");
        System.out.println();
        System.out.println();
    }

}
