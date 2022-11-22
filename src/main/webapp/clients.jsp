<%@ page isELIgnored="false" %>
<%@ page import="com.transportsystem.model.*" %>
<%@ page import="com.transportsystem.pdf.*" %>
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
<div class="d-flex align-items-center justify-content-between mb-2 col-sm-12 col-xl-12">
       <h1 class="mb-0">Clients</h1>
       <p><a href='./addcustomer.jsp'><button type="submit" class="btn btn-primary ">Add Client</button></a>  |   <a href='./clientsreport'><button type="submit" class="btn btn-danger ">Clients Report</button></a></p>
</div> 
<table class="table">
   <thead>
     <tr>
     <th scope="col">Client Id</th>
    <th scope="col">First Name</th>
    <th scope="col">Last Name</th>
    <th scope="col">Email</th>
    <th scope="col">Phone</th>
    <th scope="col"></th>
    </tr>
   </thead>
<tbody>
    <c:forEach items="${CustomerView.list}" var="customer">
  <tr>
        <td>${customer.id}</td>
        <td>${customer.firstName}</td>
        <td>${customer.lastName}</td>
        <td>${customer.email}</td>
        <td>${customer.phone}</td>
        <td><a href="./updatecustomer.jsp?id=${customer.id}"><button type="submit" class="btn btn-success">Edit</button></a>   | <a href="./deletecustomer?id=${customer.id}"><button type="submit" class="btn btn-danger">Delete</button></a> </td>
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
</body>
</html>