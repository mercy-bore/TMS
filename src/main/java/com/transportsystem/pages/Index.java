package com.transportsystem.pages;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/index")
public class Index extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.getWriter().print("<!DOCTYPE html>"
                + "<html> "
                + "<head>"
                + "<script type=\"text/javascript\" src=\"./js/sample.js\"></script>"+ "</head>"+
                "<style>"+
                        "*{color:#ececec; background-color: #142d4c}"+
                        "h2{text-align:center}"+
                        "h5{text-align:center}"+
                        ".button { background-color: #9fd3c7;  border: 5px; color: #142d4c; padding: 15px 32px; text-align: center; text-decoration: none; display: inline-block;font-size: 16px;}"+
                        "import url('https://fonts.googleapis.com/css?family=Montserrat:400,500,600,700|Poppins:400,500&display=swap');"+
                        "*{margin: 0;padding: 0;box-sizing: border-box;user-select: none;}"+
                        ".bg-img{background: url('bg.jpg');height: 100vh;background-size: cover;background-position: center;}"+
                        ".bg-img:after{position: absolute;content: '';top: 0;left: 0;height: 100%;width: 100%;background-color: #142d4c;}"+
                        ".content{position: absolute;top: 50%;left: 50%; z-index: 999; text-align: center; padding: 60px 32px;width: 700px;transform: translate(-50%,-50%); background: rgba(255,255,255,0.04);box-shadow: -1px 4px 28px 0px rgba(0,0,0,0.75);}"+
                        ".content header{color: white;font-size: 33px;font-weight: 600;margin: 0 0 35px 0;font-family: 'Montserrat',sans-serif;}"+
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
                + "<h1>" + getServletContext().getAttribute("applicationLabel") + "</h1>"

                + "<p><a href='./signup'><button class=\"button\">Signup</button></a>         <a href='./login'><button class=\"button\">Login</button></a></p>"
                + "</div>"
                + "</div>"
                + "</body>"
                + "</html>");
    }
}