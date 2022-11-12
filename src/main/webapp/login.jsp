<%@ page isELIgnored="false" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="cht" uri="WEB-INF/tlds/header.tld" %>
<%@ taglib prefix="cft" uri="WEB-INF/tlds/footer.tld" %>
<cht:Header applicationLabel="${applicationScope.applicationLabel}" />
<div class="container-fluid">
            <div class="row h-100 align-items-center justify-content-center" style="min-height: 100vh;">
                <div class="col-12 col-sm-8 col-md-6 col-lg-5 col-xl-4">
                    <div class="bg-light rounded p-4 p-sm-5 my-4 mx-3">
                        <div class="d-flex align-items-center justify-content-between mb-3">
                            <a href="index.jsp" class="">

                                <h3 class="text-primary">TMS</h3>
                            </a>
                            <h3>Sign In</h3>
                        </div>
    <form action="./login" method="post">
   <div class="form-floating mb-3">
                               <input type="text" class="form-control" id="floatingInput" name="username" placeholder="Username">
                               <label for="floatingInput">Username </label>
                           </div>
                           <div class="form-floating mb-4">
                               <input type="password" class="form-control" id="floatingPassword" name="password" placeholder="Password">
                               <label for="floatingPassword">Password</label>
                           </div>

                           <button type="submit" class="btn btn-primary py-3 w-100 mb-4">Sign In</button>
    </form>
     <%
                        String loginError = (String) application.getAttribute("loginError");
                        if (loginError != null && !loginError.equals("")) {
                    %>
                        <span style="color:red"> ${applicationScope.loginError}> </span><br/>

                    <% } %>
</div>
</div>
</div>

</body>
</html>