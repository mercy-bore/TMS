package com.TMS.project;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.*;

public class ResponseExample extends HttpServlet{
//    Methods	Description
//    String getCharacterEncoding()	This method returns the character encoding for the response.
//    Locale getLocale()	This method returns the preferred Locale of response.
//    String getContentType()	This method returns the MIME type of the response body.
//    int getBufferSize()	This method gets the buffer size for the response body.
//    void setCharacterEncoding(String )	This method sets the character encoding of the response.
//    void setLocale(Locale)	This method sets the preferred locale of response.
//    void setContentType(String )	This method returns the MIME type of the body of request.
//    void setBufferSize(int )	This method set the buffer size for the body of response.
//    PrintWriter getWriter()	This method returns the PrintWriter object to be able to write back to the user.
ServletConfig config = null;

    public void init(ServletConfig config) throws ServletException{
        this.config = config;
    }

    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {

        //Using response object to create a PrintWriter object to write back to client.
        PrintWriter out = response.getWriter();
        String n = request.getParameter("name");
        HttpSession session=request.getSession();
        session.setAttribute("uname",n);



        if(!Objects.equals(n, "Mercy")){
            RequestDispatcher rd=request.getRequestDispatcher("./project");
            rd.forward(request, response);
        }
        else{
            RequestDispatcher rd=request.getRequestDispatcher("./index.html");
            rd.include(request, response);}


    //Using response object to set character encoding
    response.setCharacterEncoding("UTF-8");


    //Using response object to set the ContentType.
    response.setContentType("text/html");

    //Using response object to set the Locale
    response.setLocale(new Locale("English", "Kenya"));

    //Using response object to set the status in this case OK
    response.setStatus(HttpServletResponse.SC_OK);

    //Using response object to set character encoding
    response.setHeader("Connection", "Keep-Alive");

    //Using response object to set the buffer size of response body
//    response.setBufferSize(30000);

    //Using response object to set a cookie that will expire in three months
    Cookie c = new Cookie("user", "mercy");
    c.setMaxAge(3 * 30 * 24 * 60 * 60); // 3 months
    c.setPath("/");
    response.addCookie(c);

    out.println("<!DOCTYPE html>"
            +"<html> "
            + "<head> "
            + "<title>TMS HttpServletResponse</title>"
            + "</head>"+
            "<style>"+
            "*{color:#ececec; background-color: #142d4c}"+
            "import url('https://fonts.googleapis.com/css?family=Montserrat:400,500,600,700|Poppins:400,500&display=swap');"+
            "*{margin: 0;padding: 0;box-sizing: border-box;user-select: none;}"+
            ".bg-img{background: url('bg.jpg');height: 100vh;background-size: cover;background-position: center;}"+
            ".bg-img:after{position: absolute;content: '';top: 0;left: 0;height: 100%;width: 100%;background-color: #142d4c;}"+
            ".content{position: absolute;top: 120%;left: 50%; z-index: 999;  padding: 60px 30px;width: 1200px;transform: translate(-50%,-50%); background: rgba(255,255,255,0.04);box-shadow: -1px 4px 28px 0px rgba(0,0,0,0.75);}"+
            ".content header{color: white;font-size: 20px;font-weight: 30;margin: 0 0 35px 0;font-family: 'Montserrat',sans-serif;}"+
            ".field{position: relative;height: 45px;width: 100%;display: flex;background: rgba(255,255,255,0.94);}"+
            ".field span{ color: #222;width: 40px;line-height: 45px;}"+
            ".field input{height: 100%; width: 100%;background: transparent; border: none;outline: none; color: #222;font-size: 16px; font-family: 'Poppins',sans-serif;}"+
            ".space{margin-top: 16px;}"+
            ".show{position: absolute;right: 13px;font-size: 13px;font-weight: 700;color: #222;display: none;cursor: pointer;font-family: 'Montserrat',sans-serif;}"+
            ".pass-key:valid ~ .show{display: block;}"+
            ".pass{text-align: left;margin: 10px 0;}"+
            ".pass a{color: white;text-decoration: none;font-family: 'Poppins',sans-serif;}"+
            ".pass:hover a{text-decoration: underline;}"+
            ".field input[type=\"submit\"]{background: #3498db;border: 1px solid #2691d9;color: white;font-size: 18px;letter-spacing: 1px;font-weight: 600;cursor: pointer;font-family: 'Montserrat',sans-serif;}"+
            ".field input[type=\"submit\"]:hover{background: #2691d9;}"+
            ".login{color: white;margin: 20px 0;font-family: 'Poppins',sans-serif;}"+
            ".links{display: flex;cursor: pointer;color: white;margin: 0 0 20px 0;}"+
            ".links i{font-size: 17px;}"+
            "i span{margin-left: 8px;font-weight: 500;letter-spacing: 1px;font-size: 16px;font-family: 'Poppins',sans-serif;}"+
            "</style>"
            + "<body>"
                    +"<div class=\"bg-img\">"
                    +"<div class=\"content\">"
                    +"<header> ");
            out.println("<h2>Using HttpServletResponse</h2>");

    //Using PrintWriter created by ServletResponse object to write back to the user
    out.println("Hey "  +"<span style=\"color:yellow\">" + request.getParameter("name") + ", " + "</span>"  + "<span style=\"color:yellow\">" + request.getParameter("lang") + "</span> " + " is a good choice." + "<br/>" + "<br/>");

    out.println("So you come from  " +"<span style=\"color:yellow\">" + request.getParameter("location")  + "</span> " + "?" + " That's great!" + "<br/>" + "<br/>");
    out.println("Response Locale :  " + "<span style=\"color:yellow\">" + response.getLocale()  + "</span> " +"<br/>" + "<br/>");
    out.println("Response  ContentType :  " + "<span style=\"color:yellow\">" + response.getContentType()  + "</span> " + "<br/>" + "<br/>");
    out.println("Response Character Encoding :  " + "<span style=\"color:yellow\">" + response.getCharacterEncoding()  + "</span> " + "<br/>" + "<br/>");
    out.println("Response Buffer Size :  " + "<span style=\"color:yellow\">" + response.getBufferSize()  + "</span> "+ "KB" + "<br/>" + "<br/>");
    out.println("Response Protocol:  " + "<span style=\"color:yellow\">" + request.getProtocol()  + "</span> "+ "<br/>" + "<br/>");
    out.println("Response Remote Address:  " + "<span style=\"color:yellow\">" + request.getRemoteAddr()  + "</span> " + "<br/>" + "<br/>");
    out.println("Response Context Path:  " + "<span style=\"color:yellow\">" + request.getContextPath()  + "</span> " + "<br/>" + "<br/>");
    out.println("Response Remote Host:  " + "<span style=\"color:yellow\">" + request.getRemoteHost()  + "</span> " + "<br/>" + "<br/>");
    out.println("Response Server Name:  " + "<span style=\"color:yellow\">" + request.getServerName()  + "</span> " + "<br/>" + "<br/>");
    out.println("Response Server Path:  " + "<span style=\"color:yellow\">" + request.getServletPath()  + "</span> " + "<br/>" + "<br/>");
    out.println("Response Status:  " + "<span style=\"color:yellow\">" + response.getStatus()  + "</span> " + "<br/>" + "<br/>");
    out.println("<TABLE BORDER=1 ALIGN=CENTER>\n" +
                "<TR BGCOLOR=\"#FFAD00\">\n" +
                "<TH>Header Name<TH>Header Value");
        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()) {
            String headerName = (String)headerNames.nextElement();
            out.println("<TR><TD>" + headerName);
            out.println("    <TD>" + request.getHeader(headerName));
        }
        out.println("</TABLE>");
        out.close();
        response.flushBuffer();
    out.println("</header>"+ "</div>"
            +"</div>"
            + "</body>"
            + "</html>");
}
}

