package com.TMS.project;
import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class Home extends Servlet {
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
        wr.print("<link rel=\"stylesheet\" href=\"webapp/WEB-INF/assets/CSS/style.css\">");
        wr.print("</head>");
        wr.print("<style>");
        wr.print("*{color:#ececec; background-color: #142d4c}");
        wr.print("h2{text-align:center}");
        wr.print("h5{text-align:center}");
        wr.print("import url('https://fonts.googleapis.com/css?family=Montserrat:400,500,600,700|Poppins:400,500&display=swap');");
        wr.print("*{margin: 0;padding: 0;box-sizing: border-box;user-select: none;}");
        wr.print(".bg-img{background: url('bg.jpg');height: 100vh;background-size: cover;background-position: center;}");
        wr.print(".bg-img:after{position: absolute;content: '';top: 0;left: 0;height: 100%;width: 100%;background-color: #142d4c;}");
        wr.print(".content{position: absolute;top: 50%;left: 50%; z-index: 999; text-align: center; padding: 60px 32px;width: 370px;transform: translate(-50%,-50%); background: rgba(255,255,255,0.04);box-shadow: -1px 4px 28px 0px rgba(0,0,0,0.75);}");
        wr.print(".content header{color: white;font-size: 33px;font-weight: 600;margin: 0 0 35px 0;font-family: 'Montserrat',sans-serif;}");
        wr.print(".field{position: relative;height: 45px;width: 100%;display: flex;background: rgba(255,255,255,0.94);}");
        wr.print(".field span{ color: #222;width: 40px;line-height: 45px;}");
        wr.print(".field input{height: 100%; width: 100%;background: transparent; border: none;outline: none; color: #222;font-size: 16px; font-family: 'Poppins',sans-serif;}");
        wr.print(".space{margin-top: 16px;}");
        wr.print(".show{position: absolute;right: 13px;font-size: 13px;font-weight: 700;color: #222;display: none;cursor: pointer;font-family: 'Montserrat',sans-serif;}");
        wr.print(".pass-key:valid ~ .show{display: block;}");
        wr.print(".pass{text-align: left;margin: 10px 0;}");
        wr.print(".pass a{color: white;text-decoration: none;font-family: 'Poppins',sans-serif;}");
        wr.print(".pass:hover a{text-decoration: underline;}");
        wr.print(".field input[type=\"submit\"]{background: #3498db;border: 1px solid #2691d9;color: white;font-size: 18px;letter-spacing: 1px;font-weight: 600;cursor: pointer;font-family: 'Montserrat',sans-serif;}");
        wr.print(".field input[type=\"submit\"]:hover{background: #2691d9;}");
        wr.print(".login{color: white;margin: 20px 0;font-family: 'Poppins',sans-serif;}");
        wr.print(".links{display: flex;cursor: pointer;color: white;margin: 0 0 20px 0;}");
        wr.print(".links i{font-size: 17px;}");
        wr.print("i span{margin-left: 8px;font-weight: 500;letter-spacing: 1px;font-size: 16px;font-family: 'Poppins',sans-serif;}");

        wr.print("</style>");
        wr.print("<body>");
        wr.print("<div class=\"content\">");

        wr.print("<h3>What is  a Transport Management System?</h3>");
        wr.print("<br>");
        wr.print("<p>A transportation management system (TMS) is a logistics platform that uses technology to help businesses plan, execute, and optimize the physical movement of goods, both incoming and outgoing, and making sure the shipment is compliant, proper documentation is available. This kind of system is often part of a larger supply chain management (SCM) system.\n" +
                "\n" +
                "Sometimes known as a transportation management solution or transportation management software, a TMS provides visibility into day-to-day transportation operations, trade compliance information and documentation, and ensuring the timely delivery of freight and goods. Transportation management systems also streamline the shipping process and make it easier for businesses to manage and optimize their transportation operations, whether they are by land, air, or sea.</p>");
        wr.print("</div>");

        wr.print("</body>");
        wr.print("</html>");

    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
