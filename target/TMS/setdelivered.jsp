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
<h2> Set Delivered Form</h2>
<form action="./updateorder" method="post">
   <% Long a = Long.valueOf(Integer.parseInt(request.getParameter("id")));
        pageContext.setAttribute("id", a);
   %>
      <c:set var="order" value = "${orderBean.getOrder(id)}" />
 <div class="bg-light rounded h-100 col-sm-12 col-xl-6">
  <div class="form-floating mb-3">
                        <input type="text" class="form-control" id="floatingInput"placeholder="Id" name="id" value="${order.id}">
                        <label for="floatingInput">Id</label>
                   </div>
                  <div class="form-floating mb-3">
                       <input type="text" class="form-control" id="floatingInput" placeholder="Cargo" name="cargo" value="${order.cargo}">
                       <label for="floatingInput">Cargo</label>
                  </div>
                  <div class="form-floating mb-3">
                    <input type="text" class="form-control" id="floatingInput" placeholder="Start Location" name="startLocation" value="${order.startLocation}">
                    <label for="floatingInput">Start Location</label>
                  </div>
                  <div class="form-floating mb-3">
                     <input type="text" class="form-control" id="floatingInput" placeholder="Destination" name="destination" value="${order.destination}">
                     <label for="floatingInput">Destination</label>
                  </div>

                  <div class="form-floating mb-3">
                     <select class="form-control" name="status">
                         <option value="delivered" selected>Delivered</option>
                              </select>
                       <label for="floatingInput">Status</label>
                  </div>
                  <div class="form-floating mb-3">
                          <input type="text" class="form-control" id="floatingInput" placeholder="Customer" name="customerId" value="${order.customer.id}">
                             <option value="none" selected disabled hidden>Customer Id</option>
                         <label for="floatingInput">Customer</label>
                  </div>
                  <div class="form-floating mb-3">
                          <input type="text" class="form-control" id="floatingInput" placeholder="Driver" name="driverId" value="${order.driver.id}">
                        <option value="none" selected disabled hidden>Driver Id</option>
                         <label for="floatingInput">Driver</label>
                  </div>
                  <div class="form-floating mb-3">
                          <input type="text" class="form-control" id="floatingInput" placeholder="Vehicle" name="vehicleId" value="${order.vehicle.id}">
                         <option value="none" selected disabled hidden>Vehicle Id</option>
                           <label for="floatingInput">Vehicle</label>
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