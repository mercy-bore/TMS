<%@ page isELIgnored="false" %>
<%@ page import="com.transportsystem.model.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="cht" uri="WEB-INF/tlds/header.tld" %>
<%@ taglib prefix="cft" uri="WEB-INF/tlds/footer.tld" %>

<cht:Header applicationLabel="${applicationScope.applicationLabel}" />

<div class="container-fluid">
<div class="container-xxl position-relative bg-white d-flex p-0">
        <jsp:include page="sidebar.jsp"/>
        <!-- Content Start -->
        <div class="content">
            <!-- Navbar Start -->
                <jsp:include page="navbar.jsp"/>
            <!-- Navbar End -->
            <div class="container-fluid pt-4 px-4">
 <div class="col-sm-12 col-xl-12">
 <div class="bg-light rounded h-100 p-4">
<h2> Update Driver Details Form</h2>
<form action="./updatedriver" method="post">
<% Long a = Long.valueOf(Integer.parseInt(request.getParameter("id")));
     pageContext.setAttribute("id", a);
%>
   <c:set var="driver" value = "${driverBean.getDriver(id)}" />
 <div class="bg-light rounded h-100 col-sm-12 col-xl-6">
                  <div class="form-floating mb-3">
                       <input type="text" class="form-control" id="floatingInput"placeholder="Id" name="id" value="${driver.id}">
                       <label for="floatingInput">Id</label>
                  </div>
                 <div class="form-floating mb-3">
                      <input type="text"  maxlength="10" class="form-control" id="floatingInput"placeholder="First Name" name="firstName" value="${driver.firstName}">
                      <label for="floatingInput">First Name</label>
                 </div>
                 <div class="form-floating mb-3">
                       <input type="text" maxlength="10" class="form-control" id="floatingInput"placeholder="Last Name" name="lastName" value="${driver.lastName}">
                       <label for="floatingInput">Last Name</label>
                 </div>
                 <div class="form-floating mb-3">
                        <input type="email" maxlength="40" class="form-control" id="floatingInput"placeholder="Email" name="email" value="${driver.email}">
                        <label for="floatingInput">Email</label>
                 </div>
                 <div class="form-floating mb-3">
                         <input type="tel" minlength="10"  maxlength="13" class="form-control" id="floatingInput"placeholder="Phone" name="phone" value="${driver.phone}">
                         <label for="floatingInput"> Phone</label>
                 </div>

 </div>
    <button type="submit" class="btn btn-success" onclick="return confirmAdd()">Submit</button>
 </form>


<%
    String customerError = (String) application.getAttribute("addCustomerError");
    if (customerError != null && !customerError.equals("")) {
%>
    <span style="color:red"> ${applicationScope.addCustomerError} </span><br/>

<% } %>

    </div>
</div>
</div>
</div>
</div>
</div>
<script>
    function confirmAdd(){
        return confirm("Do You Want To Update Driver Details!");
    }
</script>
</body>
</html>