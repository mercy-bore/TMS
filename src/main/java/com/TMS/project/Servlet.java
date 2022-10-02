package com.TMS.project;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
public class Servlet extends HttpServlet{


    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String action = req.getParameter("action");

        PrintWriter wr = res.getWriter();
        if (action != null && action.equalsIgnoreCase("signup"))
            wr.print(this.signup(null));
        else if (action != null && action.equalsIgnoreCase("login"))
            wr.print(this.login(null));
        else if(action != null && action.equalsIgnoreCase("inquiry"))
            wr.print(this.inquiry(null));
        else
            wr.print(this.home());
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter wr = res.getWriter();

        String action = req.getParameter("action");
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String fname = req.getParameter("fname");
        String lname = req.getParameter("lname");
        String phone = req.getParameter("phone");
        String location = req.getParameter("location");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");


        boolean signup = action != null && action.equalsIgnoreCase("signup");
        boolean login = action != null && action.equalsIgnoreCase("login");
        boolean inquiry = action != null && action.equalsIgnoreCase("inquiry");
        boolean inquirySent = action != null && action.equalsIgnoreCase("inquirySent");
        boolean signin = action != null && action.equalsIgnoreCase("signin");




        String actionError = "";
        if (signup) {
            System.out.println("Email: " + email);
            System.out.println("Password: " + password);
            System.out.println("Confirm Password: " + confirmPassword);

            if (email == null || email.equalsIgnoreCase(""))
                actionError = "Email is required<br/>";

            if (username == null || username.equalsIgnoreCase(""))
                actionError = "Username is required<br/>";

            if (password == null || password.equalsIgnoreCase(""))
                actionError += "Password is required<br/>";

            if (confirmPassword == null || confirmPassword.equalsIgnoreCase(""))
                actionError += "Confirm password is required<br/>";

            if (password != null && confirmPassword != null && !password.equals(confirmPassword))
                actionError += "Password & confirm password do not match<br/>";



            if (actionError.equals(""))
                wr.print(this.home());
            else
                wr.print(this.signup(actionError));

        } else if (login) {
            System.out.println("username: " + username);
            System.out.println("Password: " + password);

            if (username == null || username.equalsIgnoreCase(""))
                actionError = "Username is required<br/>";

            if (password == null || password.equalsIgnoreCase(""))
                actionError += "Password is required<br/>";

            if (actionError.equals(""))
                wr.print(this.loggedIn());
            else
                wr.print(this.login(actionError));

        }else if(inquiry){
            System.out.println("Location: " + location);
            if (location == null || location.equalsIgnoreCase(""))
                actionError += "Your Location is required.<br/>";

            if (actionError.equals(""))
                wr.print(this.inquirySent());
            else
                wr.print(this.inquiry(actionError));

        }
        else if (inquirySent) {
            System.out.println("Inquiry received.");

        }
    }

    public String home(){
        return
                "<html>" + "<head>"+
        "<title>TMS - Homepage</title>" +
        "<link rel=\"stylesheet\" href=\"webapp/WEB-INF/assets/CSS/style.css\">"+
        "</head>" +
        "<style>"+
       "*{color:#ececec; background-color: #142d4c}"+
        "h2{text-align:center}"+
        "h5{text-align:center}"+
        "import url('https://fonts.googleapis.com/css?family=Montserrat:400,500,600,700|Poppins:400,500&display=swap');"+
        "*{margin: 0;padding: 0;box-sizing: border-box;user-select: none;}"+
        ".bg-img{background: url('bg.jpg');height: 100vh;background-size: cover;background-position: center;}"+
        ".bg-img:after{position: absolute;content: '';top: 0;left: 0;height: 100%;width: 100%;background-color: #142d4c;}"+
        ".content{position: absolute;top: 50%;left: 50%; z-index: 999; text-align: center; padding: 60px 32px;width: 370px;transform: translate(-50%,-50%); background: rgba(255,255,255,0.04);box-shadow: -1px 4px 28px 0px rgba(0,0,0,0.75);}"+
        "tt,.content header{color: white;font-size: 33px;font-weight: 600;margin: 0 0 35px 0;font-family: 'Montserrat',sans-serif;}"+
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
       "</style>"+
        "<body>"+
                        "<div class=\"content\">"+
                        "<h1>Welcome To Transport Management System.</h1>"+
                        "<h3>Moving with you.</h3>"+
                        "<div class=\"tt\">"+
                        "<a href='./project?action=signup' style=\"text-decoration: none;\">  REGISTER  </a><br/>"+
                        "<a href='./project?action=login' style=\"text-decoration: none;\">  LOGIN  </a><br/>"+
                        "</div>"+
                        "</div>"+
                        "</div>"+
                        "</body>"+
       "</html>";
    }

    public String signup(String actionError){
        return "<!DOCTYPE html>"
                + "<html> "
                + "<head> "
                + "<title>TMS - Signup Page</title>"
                + "</head>"+
                "<style>"+
                "*{color:#ececec; background-color: #142d4c}"+
                "h2{text-align:center}"+
                "h5{text-align:center}"+
                "import url('https://fonts.googleapis.com/css?family=Montserrat:400,500,600,700|Poppins:400,500&display=swap');"+
                "*{margin: 0;padding: 0;box-sizing: border-box;user-select: none;}"+
                ".bg-img{background: url('bg.jpg');height: 100vh;background-size: cover;background-position: center;}"+
                ".bg-img:after{position: absolute;content: '';top: 0;left: 0;height: 100%;width: 100%;background-color: #142d4c;}"+
                ".content{position: absolute;top: 50%;left: 50%; z-index: 999; text-align: center; padding: 60px 32px;width: 370px;transform: translate(-50%,-50%); background: rgba(255,255,255,0.04);box-shadow: -1px 4px 28px 0px rgba(0,0,0,0.75);}"+
                "tt,.content header{color: white;font-size: 33px;font-weight: 600;margin: 0 0 35px 0;font-family: 'Montserrat',sans-serif;}"+
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
                +"<header>Transport Management System</header>"
                +"<header>Login Form </header>"
                + "<form action=\"./project\" method=\"post\">"
                +"<input type=\"hidden\" name=\"action\" value=\"signup\">"
                +"<div class=\"field space\">"
                + "<input type=\"text\" name=\"username\" placeholder=\"Username\">"
                +"</div>"
                +"<div class=\"field space\">"
                + "<input type=\"text\" name=\"fname\" required placeholder=\"First Name\">"
                +"</div>"
                +"<div class=\"field space\">"
                + "<input type=\"text\" name=\"lname\" required placeholder=\"Last Name\">"
                +"</div>"
                +"<div class=\"field space\">"
                + "<input type=\"text\" name=\"phone\" required placeholder=\"Phone No\">"
                +"</div>"
                +"<div class=\"field space\">"
                + "<input type=\"email\" name=\"email\" placeholder=\"Email\">"
                +"</div>"
                +"<div class=\"field space\">"
                + "<input type=\"password\" name=\"password\"  placeholder=\"Password\">"
                +"</div>"
                +"<div class=\"field space\">"
                + "<input type=\"password\" name=\"confirmPassword\"  placeholder=\"Confirm Password\">"
                +"</div>"
                +"<div class=\"field space\">"
                + "<tr> <td> <input type=\"submit\" value=\"Signup\"></tr> "
                +"</div>"
                + "</form>"
                + "<span style=\"color:yellow\">" + (actionError != null? actionError : "") + "</span>"
                +"</div>"
                +"</div>"
                + "</body>"
                + "</html>";
    }
public String inquiry(String actionError){
        return "<!DOCTYPE html>"
                + "<html> "
                + "<head> "
                + "<title>TMS - Inquiry Page</title>"
                + "</head>"+
                "<style>"+
                "*{color:#ececec; background-color: #142d4c}"+
                "h2{text-align:center}"+
                "h5{text-align:center}"+
                "import url('https://fonts.googleapis.com/css?family=Montserrat:400,500,600,700|Poppins:400,500&display=swap');"+
                "*{margin: 0;padding: 0;box-sizing: border-box;user-select: none;}"+
                ".bg-img{background: url('bg.jpg');height: 100vh;background-size: cover;background-position: center;}"+
                ".bg-img:after{position: absolute;content: '';top: 0;left: 0;height: 100%;width: 100%;background-color: #142d4c;}"+
                ".content{position: absolute;top: 50%;left: 50%; z-index: 999; text-align: center; padding: 60px 32px;width: 370px;transform: translate(-50%,-50%); background: rgba(255,255,255,0.04);box-shadow: -1px 4px 28px 0px rgba(0,0,0,0.75);}"+
                "tt,.content header{color: white;font-size: 33px;font-weight: 600;margin: 0 0 35px 0;font-family: 'Montserrat',sans-serif;}"+
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
                +"<header>Transport Management System</header>"
                +"<header>Inquiry Form </header>"
                + "<form action=\"./project\" method=\"post\">"
                +"<input type=\"hidden\" name=\"action\" value=\"inquiry\">"
                +"<div class=\"field space\">"
                + "<input type=\"text\" name=\"fname\" required placeholder=\"First Name\">"
                +"</div>"
                +"<div class=\"field space\">"
                + "<input type=\"text\" name=\"lname\" required placeholder=\"Last Name\">"
                +"</div>"
                +"<div class=\"field space\">"
                + "<input type=\"text\" name=\"phone\" required placeholder=\"Phone No\">"
                +"</div>"
                +"<div class=\"field space\">"
                + "<input type=\"text\" name=\"location\" placeholder=\"Location\">"
                +"</div>"

                +"<div class=\"field space\">"
                + "<tr> <td> <input type=\"submit\" value=\"Send \"></tr> "
                +"</div>"
                + "</form>"
                + "<span style=\"color:yellow\">" + (actionError != null? actionError : "") + "</span>"
                +"</div>"
                +"</div>"
                + "</body>"
                + "</html>";
}
    public String login(String actionError){
        return  "<!DOCTYPE html>"
                + "<html> "
                + "<head> "
                + "<title>TMS - Login Page</title>"
                + "</head>"+
                "<style>"+
                "*{color:#ececec; background-color: #142d4c}"+
                "h2{text-align:center}"+
                "h5{text-align:center}"+
                "import url('https://fonts.googleapis.com/css?family=Montserrat:400,500,600,700|Poppins:400,500&display=swap');"+
                "*{margin: 0;padding: 0;box-sizing: border-box;user-select: none;}"+
                ".bg-img{background: url('bg.jpg');height: 100vh;background-size: cover;background-position: center;}"+
                ".bg-img:after{position: absolute;content: '';top: 0;left: 0;height: 100%;width: 100%;background-color: #142d4c;}"+
                ".content{position: absolute;top: 50%;left: 50%; z-index: 999; text-align: center; padding: 60px 32px;width: 370px;transform: translate(-50%,-50%); background: rgba(255,255,255,0.04);box-shadow: -1px 4px 28px 0px rgba(0,0,0,0.75);}"+
                "tt,.content header{color: white;font-size: 33px;font-weight: 600;margin: 0 0 35px 0;font-family: 'Montserrat',sans-serif;}"+
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
                +"<header>Transport Management System</header>"
                +"<header>Login Form </header>"
                + "<form action=\"./project\" method=\"post\">"
                + "<input type=\"hidden\" name=\"action\" value=\"login\">"
                +"<div class=\"field space\">"
                + "<input type=\"text\" name=\"username\" placeholder=\"Username/Email\">"
                +"</div>"
                +"<div class=\"field space\">"
                + "<input type=\"Password\" name=\"password\" placeholder=\"Password\">"
                +"</div>"
                +"<div class=\"field space\">"
                + "<tr> <td> <input type=\"submit\" value=\"Login\"></tr> "
                +"</div>"
                + "</form>"
                + "<span style=\"color:yellow\">" + (actionError != null? actionError : "") + "</span>"
                +"</div>"
                +"</div>"
                + "</body>"
                + "</html>";
    }

    public String loggedIn(){
        return
                "<html>" +
                        "<head>"+
                        "<title>TMS - Looged In</title>" +
                        "<link rel=\"stylesheet\" href=\"webapp/WEB-INF/assets/CSS/style.css\">"+
                        "</head>" +
                        "<style>"+
                        "*{color:#ececec; background-color: #142d4c}"+
                        "h2{text-align:center}"+
                        "h5{text-align:center}"+
                        "import url('https://fonts.googleapis.com/css?family=Montserrat:400,500,600,700|Poppins:400,500&display=swap');"+
                        "*{margin: 0;padding: 0;box-sizing: border-box;user-select: none;}"+
                        ".bg-img{background: url('bg.jpg');height: 100vh;background-size: cover;background-position: center;}"+
                        ".bg-img:after{position: absolute;content: '';top: 0;left: 0;height: 100%;width: 100%;background-color: #142d4c;}"+
                        ".content{position: absolute;top: 50%;left: 50%; z-index: 999; text-align: center; padding: 60px 32px;width: 370px;transform: translate(-50%,-50%); background: rgba(255,255,255,0.04);box-shadow: -1px 4px 28px 0px rgba(0,0,0,0.75);}"+
                        "tt,.content header{color: white;font-size: 33px;font-weight: 600;margin: 0 0 35px 0;font-family: 'Montserrat',sans-serif;}"+
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
                        "</style>"+
                        "<body>"+
                        "<div class=\"content\">"+
                        "<h1>Welcome To Transport Management System.</h1>"+
                        "<h3>Moving with you.</h3>"+
                        "<h3>You have successfully logged in.</h3>"+
                        "Would you like to make an inquiry? Send a queue below."+
                        "<a href='./project?action=inquiry' style=\"text-decoration: none;\">  Make an inquiry  </a><br/>"+
                        "</div>"+
                        "</body>"+
                        "</html>";

    }
    public String inquirySent(){
        return
        "<html>" +
                "<head>"+
                "<title>TMS - Inquiry Sent</title>" +
                "<link rel=\"stylesheet\" href=\"webapp/WEB-INF/assets/CSS/style.css\">"+
                "</head>" +
                "<style>"+
                "*{color:#ececec; background-color: #142d4c}"+
                "h2{text-align:center}"+
                "h5{text-align:center}"+
                "import url('https://fonts.googleapis.com/css?family=Montserrat:400,500,600,700|Poppins:400,500&display=swap');"+
                "*{margin: 0;padding: 0;box-sizing: border-box;user-select: none;}"+
                ".bg-img{background: url('bg.jpg');height: 100vh;background-size: cover;background-position: center;}"+
                ".bg-img:after{position: absolute;content: '';top: 0;left: 0;height: 100%;width: 100%;background-color: #142d4c;}"+
                ".content{position: absolute;top: 50%;left: 50%; z-index: 999; text-align: center; padding: 60px 32px;width: 370px;transform: translate(-50%,-50%); background: rgba(255,255,255,0.04);box-shadow: -1px 4px 28px 0px rgba(0,0,0,0.75);}"+
                "h2,h1,.content header{color: white;font-size: 33px;font-weight: 600;margin: 0 0 35px 0;font-family: 'Montserrat',sans-serif;}"+
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
                "</style>"+
                "<body>"+
                "<div class=\"content\">"+
                "<h1> Transport Management System.</h1>"+
                "<h2>Your Inquiry  has been successfully sent.</h2>"+
                "</div>"+
                "</body>"+
                "</html>";
    }
}

