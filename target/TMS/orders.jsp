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
<br/>
 <div class="col-sm-12 col-xl-12">
 <div class="bg-light rounded h-100 p-4">
<div class="d-flex align-items-center justify-content-between mb-2 col-sm-12 col-xl-12">
       <h1 class="mb-0">Orders</h1>
       <p><a href='./addorder.jsp'><button type="submit" class="btn btn-primary ">Add Order</button></a></p>
</div>
<table class="table">
    <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Start Location</th>
            <th scope="col">Destination</th>
            <th scope="col">Cargo</th>
            <th scope="col">Customer Id</th>
            <th scope="col"></th>

        </tr>
    </thead>
<tbody>
<c:forEach items="${OrderView.list}" var="order">
    <tr>
    <td scope="row">${order.id}</td>
    <td scope="row">${order.startLocation}</td>
    <td scope="row">${order.destination}</td>
    <td scope="row">${order.cargo}</td>
    <td scope="row">${order.customerId}</td>

    <td scope="row"> <a href="./updateorder.jsp?id=${order.id}"><button type="submit" class="btn btn-success">Edit</button></a></a>   | <a href="./deleteorder?id=${order.id}"><button type="submit" class="btn btn-danger">Delete</button></a></a> </td>
    </tr>
    </c:forEach>
</tbody>
</table>

</div>
</div>
</div>
</div>
</div>
</div>

<jsp:include page="javascriptlibs.jsp"/>
</body></html>