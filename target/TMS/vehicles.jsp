<%@ page isELIgnored="false" %>
<%@ page import="com.transportsystem.model.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp" />

<jsp:useBean id="vc" class="com.transportsystem.controllers.VehicleController" />

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

   
<%
    List<Vehicle> vehicles = vc.list((Connection) application.getAttribute("dbConnection"), new Vehicle());
            pageContext.setAttribute("vehicles", vehicles);
%> 
<tbody>
<c:foreach items="${vehicles}" var="vehicle">
    <tr>
    <td scope="row">${vehicle.id}</td>
    <td scope="row">${vehicle.type}</td>
    <td scope="row">${vehicle.plateNo}</td>
    <td scope="row">${vehicle.weight}</td>
    <td scope="row">${vehicle.route}</td>
    <td scope="row"> <a href="./updatevehicle.jsp"><button type="submit" class="btn btn-success">Edit</button></a></a>   | <a href="./deletevehicle"><button type="submit" class="btn btn-danger">Delete</button></a></a> </td>
    </tr>
    </c:foreach>
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