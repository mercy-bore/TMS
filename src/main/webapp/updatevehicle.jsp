<%@ page isELIgnored="false" %>
<%@ page import="com.transportsystem.controllers.*" %>
<%@ page import="com.transportsystem.model.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>

<%! VehicleController vc = new VehicleController(); %>
<%! CustomerController cc = new CustomerController(); %>

<jsp:include page="header.jsp" />
<div class="container-fluid">
<h2> Update Vehicle Form</h2>
 <%
     List<Vehicle> vehicles = vc.list((Connection) application.getAttribute("dbConnection"), new Vehicle());
    for (Vehicle vehicle : vehicles) {
  %>
<form action="./updatevehicle" method="post">
 <div class="bg-light rounded h-100 col-sm-12 col-xl-6">
                 <div class="form-floating mb-3">
                       <input type="hidden" class="form-control" id="floatingInput"placeholder="Id" name="id" value="<%=vehicle.getId()%>">
                       <label for="floatingInput">Id</label>
                 </div>
                 <div class="form-floating mb-3">
                      <input type="text" class="form-control" id="floatingInput"placeholder="Type" name="type" value="<%=vehicle.getType()%>">
                      <label for="floatingInput">Type</label>
                 </div><tr>
                 <div class="form-floating mb-3">
                       <input type="text" class="form-control" id="floatingInput"placeholder="Plate No" name="plateNo" value="<%= vehicle.getPlateNo() %>">
                       <label for="floatingInput">Plate No</label>
                 </div>
                 <div class="form-floating mb-3">
                    <input type="text" class="form-control" id="floatingInput"placeholder="Weight" name="weight" value="<%= vehicle.getWeight() %>">
                    <label for="floatingInput">Weight</label>
                 </div>
                 <div class="form-floating mb-3">
                    <input type="text" class="form-control" id="floatingInput"placeholder="Route" name="route" value="<%= vehicle.getRoute() %>">
                    <label for="floatingInput">Route</label>
                 </div>
 </div>
     <button type="submit" class="btn btn-success">Submit</button>
  </form>
<% } %>


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