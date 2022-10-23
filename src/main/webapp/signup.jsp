<%@ page isELIgnored="false" %>
<jsp:include page="header.jsp" />
<div class="container-fluid">
            <div class="row h-100 align-items-center justify-content-center" style="min-height: 100vh;">
                <div class="col-12 col-sm-8 col-md-6 col-lg-5 col-xl-4">
                    <div class="bg-light rounded p-4 p-sm-5 my-4 mx-3">
                        <div class="d-flex align-items-center justify-content-between mb-3">
                            <a href="index.jsp" class="">

                                <h3 class="text-primary">TMS</h3>
                            </a>
                            <h3>Sign Up</h3>
                        </div>
        <form action="./signup" method="post">
        <div class="form-floating mb-3">
             <input type="text" class="form-control" id="floatingInput" name="username" placeholder="Username">
             <label for="floatingInput">Username</label>
        </div>
        <div class="form-floating mb-3">
                     <input type="text" class="form-control" id="floatingInput" name="fname" placeholder="First Name">
                     <label for="floatingInput">First Name</label>
        </div>
        <div class="form-floating mb-3">
                     <input type="text" class="form-control" id="floatingInput" name="lame" placeholder="Last Name">
                     <label for="floatingInput">Last Name</label>
                </div>
        <div class="form-floating mb-3">
                     <input type="text" class="form-control" id="floatingInput" name="phone" placeholder="Phone Number">
                     <label for="floatingInput">Phone Number</label>
                </div>
        <div class="form-floating mb-3">
                     <input type="email" class="form-control" id="floatingInput" name="email" placeholder="email">
                     <label for="floatingInput">Email</label>
                </div>
        <div class="form-floating mb-3">
                     <input type="password" class="form-control" id="floatingInput" name="password" placeholder="Password">
                     <label for="floatingInput">Password</label>
                </div>
        <div class="form-floating mb-3">
                     <input type="password" class="form-control" id="floatingInput" name="confirmPassword" placeholder="Confirm Password">
                     <label for="floatingInput">Confirm password</label>
                </div>
        <button type="submit" class="btn btn-primary py-3 w-100 mb-4">Sign Up</button>

        </form>

         <%
                    String registerError = (String) application.getAttribute("registerError");
                    if (registerError != null && !registerError.equals("")) {
                %>
                    <span style="color:red"> ${applicationScope.registerError}</span><br/>

                <% } %>
                </div>
                </div>
                </div>

                </body>
                </html>