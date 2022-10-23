<%@ page isELIgnored="false" %>
<%@ page import="com.transportsystem.controllers.*" %>
<%@ page import="com.transportsystem.model.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<jsp:include page="header.jsp" />

<jsp:useBean id="vc" class="com.transportsystem.controllers.VehicleController" />
<%!
    Long id;
    String type;
    String plate;
    String weight;
    String route;
%>
<div class="container-fluid">
<div class="container-xxl position-relative bg-white d-flex p-0">
        <jsp:include page="sidebar.jsp"/>
        <!-- Content Start -->
        <div class="content">
            <!-- Navbar Start -->
                <jsp:include page="navbar.jsp"/>
            <!-- Navbar End -->
            <div class="container-fluid pt-4 px-4">
<br/>
 <div class="col-sm-12 col-xl-12">
 <div class="bg-light rounded h-100 p-4">
<div class="d-flex align-items-center justify-content-between mb-2 col-sm-12 col-xl-12">
       <h1 class="mb-0">Vehicles</h1>
       <p><a href='./addvehicle.jsp'><button type="submit" class="btn btn-primary ">Add Vehicle</button></a></p>
</div>
<table class="table">
    <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Type</th>
            <th scope="col">Plate No</th>
            <th scope="col">Weight in KG</th>
            <th scope="col">Route</th>
            <th scope="col"></th>

        </tr>
    </thead>
    <tbody>
      <tr>
<%
    List<Vehicle> vehicles = vc.list((Connection) application.getAttribute("dbConnection"), new Vehicle());
    for (Vehicle vehicle : vehicles) {
            id = vehicle.getId();
            type = vehicle.getType();
            plate = vehicle.getPlateNo();
            weight = vehicle.getWeight();
            route = vehicle.getRoute();

%>
    <td scope="row"><%=id%></td>
    <td scope="row"><%=type%></td>
    <td scope="row"><%=plate%></td>
    <td scope="row"><%=weight%></td>
    <td scope="row"><%=route%></td>
    <td scope="row"> <a href="./updatevehicle.jsp?plateNo=<%=vehicle.getPlateNo()%>"><button type="submit" class="btn btn-success">Edit</button></a></a>   | <a href="./deletevehicle?plateNo=<%=vehicle.getPlateNo()%>"><button type="submit" class="btn btn-danger">Delete</button></a></a> </td>
    </tr>
<% } %>
</tbody>
</table>

</div>
</div>
</div>
</div>
</div>
</div>

<jsp:include page="javascriptlibs.jsp"/>
</body>
</html>