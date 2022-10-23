<%@ page isELIgnored="false" %>
<jsp:include page="header.jsp" />
<div class="container-fluid">

            <div class="row h-100 align-items-center justify-content-center" style="min-height: 100vh;">

                <div class="col-12 col-sm-8 col-md-6 col-lg-5 col-xl-4">
                    <div class="bg-light rounded p-4 p-sm-5 my-4 mx-3">
                                                    <h3 class="text-primary" style="text-align:center;">Transport Management System</h3>

                        <div class="d-flex align-items-center justify-content-between mb-3">
                            <a href='./signup.jsp'><button type="submit" class="btn btn-primary ">Sign Up</button></a>
                            <a href='./login.jsp'><button type="submit" class="btn btn-primary ">Sign In</button></a>
                        </div>


${param.invalidAccess}
${param.invalidAccessWarn}

</div>
</div>
</body>
</html>