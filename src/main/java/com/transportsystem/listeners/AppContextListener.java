package com.transportsystem.listeners;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;
import java.sql.Connection;

@WebListener
public class AppContextListener implements ServletContextListener {

// @Resource(lookup = "java:jboss/datasources/TMS")
// DataSource datasource;


    public void contextInitialized(ServletContextEvent ctxe){
        System.out.println();
        System.out.println();
        System.out.print("Transport Management System ..... Firing up");
        System.out.println();
        System.out.println();
        ServletContext ctx = ctxe.getServletContext();
        ctx.setAttribute("applicationLabel", "Transport Management System");

        // try {
        //      System.out.print("Establishing connection....");
        //     Connection connection = datasource.getConnection();
        //     ctx.setAttribute("dbConnection", connection);
        //     System.out.println("****************** CONNECTED TO DB ******************");
        // } catch (Exception ex) {
        //     System.out.println("Sorry, Connection Not Established....: " + ex.getMessage());

        // }

    }

    public void contextDestroyed(ServletContextEvent ctxe) {
        // try {
        //     ServletContext ctx = ctxe.getServletContext();
        //     Connection connection = (Connection) ctx.getAttribute("dbConnection");
        //     connection.close();

        // } catch (Exception ex) {
        //     System.out.println(ex.getMessage());
        // }
        // System.out.println();
        // System.out.println();
        // System.out.print("************      TMS Application stopped.      ************");
        // System.out.println();
        // System.out.println();
    }

}
