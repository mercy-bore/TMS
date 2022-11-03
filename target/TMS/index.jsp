<%@ page isELIgnored="false" %>
<%@ taglib prefix="jc" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="cht" uri="WEB-INF/tlds/header.tld" %>
<%@ taglib prefix="cft" uri="WEB-INF/tlds/footer.tld" %>
<cht:Header applicationLabel="${applicationScope.applicationLabel}" />
<div class="container-fluid">

            <div class="row h-60 align-items-center justify-content-center" style="min-height: 60vh;">

                <div class="col-12 col-sm-8 col-md-6 col-lg-5 col-xl-4">
                    <div class="bg-light rounded p-4 p-sm-5 my-4 mx-3">
                        <h3 class="row h-10 text-primary" style="min-height: 10vh;text-align:center;">TMS - Moving With You</h3>

                        <div class="d-flex align-items-center justify-content-between mb-3">
                            <a href='./signup.jsp'><button type="submit" class="btn btn-primary ">Sign Up</button></a>
                            <a href='./login.jsp'><button type="submit" class="btn btn-primary ">Sign In</button></a>
                        </div>


${param.invalidAccess}
${param.invalidAccessWarn}

</div>
</div>
<cft:Footer> 
     </cft:Footer>
