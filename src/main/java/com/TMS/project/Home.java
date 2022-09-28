package com.TMS.project;
import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class Home implements Servlet{
    public void init(ServletConfig config) throws ServletException {

    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");

        PrintWriter wr = res.getWriter();
        wr.print("<html>");
        wr.print("<head>");
        wr.print("<title>TMS - Homepage</title>");
        wr.print("</head>");
        wr.print("<body>");
        wr.print("<p>A transportation management system (TMS) is a logistics platform that uses technology to help businesses plan, execute, and optimize the physical movement of goods, both incoming and outgoing, and making sure the shipment is compliant, proper documentation is available. This kind of system is often part of a larger supply chain management (SCM) system.\n" +
                "\n" +
                "Sometimes known as a transportation management solution or transportation management software, a TMS provides visibility into day-to-day transportation operations, trade compliance information and documentation, and ensuring the timely delivery of freight and goods. Transportation management systems also streamline the shipping process and make it easier for businesses to manage and optimize their transportation operations, whether they are by land, air, or sea.</p>");
        wr.print("</body>");
        wr.print("</html>");

    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
