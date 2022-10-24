<%@ page isELIgnored="false" %>
<%@ page import="com.transportsystem.controllers.*" %>
<%@ page import="com.transportsystem.model.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<jsp:include page="header.jsp" />

<jsp:useBean id="cc" class="com.transportsystem.controllers.CustomerController" />
<%!
    Long id;
    String fn;
    String ln;
    String location;
    String email;
    String phone;
    String cargo;
    String dt;


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
 <div class="col-sm-12 col-xl-12">
 <div class="bg-light rounded h-100 p-4">
<div class="d-flex align-items-center justify-content-between mb-2 col-sm-12 col-xl-12">
       <h1 class="mb-0">Clients</h1>
       <p><a href='./addcustomer.jsp'><button type="submit" class="btn btn-primary ">Add Client</button></a></p>
</div> <table class="table">
   <thead>
     <tr>
     <th scope="col">Id</th>
    <th scope="col">First Name</th>
    <th scope="col">Last Name</th>
    <th scope="col">Email</th>
    <th scope="col">Phone</th>
    <th scope="col">Location</th>
    <th scope="col">Cargo</th>
    <th scope="col">Delivery Type</th>
    <th scope="col"></th>
    </tr>
   </thead>
<tbody>
  <tr>
   <%
    List<Customer> customers = cc.list((Connection) application.getAttribute("dbConnection"), new Customer());
    for (Customer customer : customers) {
        id = customer.getId();
        fn = customer.getFirstName();
        ln = customer.getLastName();
        location = customer.getLocation();
        email = customer.getEmail();
        phone = customer.getPhone();
        cargo = customer.getCargo();
        dt = customer.getDeliveryType();

    %>
        <td><%=id%></td>
        <td><%=fn%></td>
        <td><%=ln%></td>
        <td><%=email%></td>
        <td><%=phone%></td>
        <td><%=location%></td>
        <td><%=cargo%></td>
        <td><%=dt%></td>
        <td><a href="./updatecustomer.jsp?email=<%=customer.getEmail()%>"><button type="submit" class="btn btn-success">Edit</button></a>   | <a href="./deletecustomer?id=<%=customer.getId()%>"><button type="submit" class="btn btn-danger">Delete</button></a> </td>
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