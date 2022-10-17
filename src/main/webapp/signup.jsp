<!DOCTYPE html>
    <html>
    <head>
    <title>TMS - Signup Page</title>
    <link rel="stylesheet" type="text/css" href="./assets/CSS/style.css"/>
    </head>
    <body>
        <div class="bg-img">
        <div class="content">
        <header>Transport Management System</header>
        <header>Signup Form </header>
        <form action="./signup" method="post">
        <input type="hidden" name="action" value="signup">
        <div class="field space">
             <input type="text" name="username" placeholder="Username">
        </div>
        <div class="field space">
            <input type="text" name="fname" required placeholder="First Name">
        </div>
        <div class="field space">
        <input type="text" name="lname" required placeholder="Last Name">
        </div>
        <div class="field space">
        <input type="text" name="phone" required placeholder="Phone No">
        </div>
        <div class="field space">
        <input type="email" name="email" placeholder="Email">
        </div>
        <div class="field space">
        <input type="password" name="password"  placeholder="Password">
        </div>
        <div class="field space">
        <input type="password" name="confirmPassword"  placeholder="Confirm Password">
        </div>
        <div class="field space">
        <tr> <td> <input type="submit" value="Signup"></tr>
        </div>
        </form>

         <%
                    String registerError = (String) application.getAttribute("registerError");
                    if (registerError != null && !registerError.equals("")) {
                %>
                    <span style="color:yellow"> <%= application.getAttribute("registerError") %> </span><br/>

                <% } %>
        </div>
        </div>
</body>
</html>