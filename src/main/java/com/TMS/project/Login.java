package com.TMS.project;
import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class Login implements Servlet {
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setContentType("text/html");

        PrintWriter wr = servletResponse.getWriter();
        wr.print("<html>");
        wr.print("<head>");
        wr.print("<title>TMS - Login Page</title>");
        wr.print("</head>");
        wr.print("<body>");
        wr.print("<p>Login Form</p>");
        wr.print("</body>");
        wr.print("</html>");

    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
