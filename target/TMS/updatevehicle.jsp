<%@ page isELIgnored="false" %>
<%@ page import="com.transportsystem.controllers.*" %>
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
<h2> Update Vehicle Form</h2>
<form action="./updatevehicle" method="post">
  <% Long a = Long.valueOf(Integer.parseInt(request.getParameter("id")));
       pageContext.setAttribute("id", a);
  %>
     <c:set var="vehicle" value = "${vehicleBean.getVehicle(id)}" />
 <div class="bg-light rounded h-100 col-sm-12 col-xl-6">
                 <div class="form-floating mb-3">
                       <input type="hidden" class="form-control" id="floatingInput"placeholder="Id" name="id" value="${vehicle.id}">
                       <label for="floatingInput">Id</label>
                 </div>
                 <div class="form-floating mb-3">
                      <input type="text" class="form-control" id="floatingInput"placeholder="Type" name="type" value="${vehicle.type}">
                      <label for="floatingInput">Type</label>
                 </div><tr>
                 <div class="form-floating mb-3">
                       <input type="text" class="form-control" id="floatingInput"placeholder="Plate No" name="plateNo" value="${vehicle.plateNo}">
                       <label for="floatingInput">Plate No</label>
                 </div>
                 <div class="form-floating mb-3">
                    <input type="text" class="form-control" id="floatingInput"placeholder="Weight" name="weight" value="${vehicle.weight}">
                    <label for="floatingInput">Weight</label>
                 </div>
                 <div class="form-floating mb-3">
                    <input type="text" class="form-control" id="floatingInput"placeholder="Route" name="route" value="${vehicle.route}">
                    <label for="floatingInput">Route</label>
                 </div>
 </div>
     <button type="submit" class="btn btn-success">Submit</button>

  </form>


 <%
     String customerError = (String) application.getAttribute("addVehicleError");
     if (customerError != null && !customerError.equals("")) {
 %>
     <span style="color:red"> ${applicationScope.addVehicleError} </span><br/>
 <% } %>
     </div>
 </div>
  </div>
 </div>
 </div>
 </div>
<cft:Footer> 
     </cft:Footer>