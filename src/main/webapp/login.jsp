<!DOCTYPE html>
<html>
<head>
<title>TMS - Login Page</title>
<link rel="stylesheet" type="text/css" href="./assets/CSS/style.css"/>
</head>
<body>
<div class="bg-img">
<div class="content">
    <h1><%= application.getAttribute("applicationLabel") %></h1>
    <header>Login Form </header>
    <form action="./login" method="post">
    <div class="field space">
        <input type="text" name="username" placeholder="Username">
    </div>
    <div class="field space">
        <input type="Password" name="password" placeholder="Password">
    </div>
    <div class="field space">
    <tr> <td> <input type="submit" value="Login"></tr>
    </div>
    </form>
     <%
                        String loginError = (String) application.getAttribute("loginError");
                        if (loginError != null && !loginError.equals("")) {
                    %>
                        <span style="color:yellow"> <%= application.getAttribute("loginError") %> </span><br/>

                    <% } %>
</div>
</div>
</body>
</html>