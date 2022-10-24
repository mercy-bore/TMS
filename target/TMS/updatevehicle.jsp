<%@ page isELIgnored="false" %>
<%@ page import="com.transportsystem.controllers.*" %>
<%@ page import="com.transportsystem.model.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%! VehicleController vc = new VehicleController(); %>
<%! CustomerController cc = new CustomerController(); %>

<%
    List<Vehicle> vehicles = vc.list((Connection) application.getAttribute("dbConnection"), new Vehicle());
            pageContext.setAttribute("vehicles", vehicles);
%>


<jsp:include page="header.jsp" />
<div class="container-fluid">
<h2> Update Vehicle Form</h2>



request.getParameter("plateNo");
<p><%=request.getParameter("plateNo")%></p>

<c:forEach items="${vehicles}" var="vehicle">
<form action="./updatevehicle?plateNo=${vehicle.plateNo}" method="post">
 <div class="bg-light rounded h-100 col-sm-12 col-xl-6">
                 <div class="form-floating mb-3">
                       <input type="hidden" class="form-control" id="floatingInput"placeholder="Id" name="id" value="${vehicle.id}">
                       <label for="floatingInput">Id</label>
                 </div>
                 <div class="form-floating mb-3">
                      <input type="text" class="form-control" id="floatingInput"placeholder="Type" name="type" value=${vehicle.type}>
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
</c:forEach>


 <%
     String customerError = (String) application.getAttribute("addVehicleError");
     if (customerError != null && !customerError.equals("")) {
 %>
     <span style="color:red"> ${applicationScope.addVehicleError} </span><br/>
 <% } %>
     </div>
 </div>
 </body>
 </html>