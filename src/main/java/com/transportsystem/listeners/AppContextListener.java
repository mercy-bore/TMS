package com.transportsystem.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

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

    }

    public void contextDestroyed(ServletContextEvent ctxe) {
        System.out.println();
        System.out.println();
        System.out.print("************      TMS Application stopped.      ************");
        System.out.println();
        System.out.println();
    }

}
