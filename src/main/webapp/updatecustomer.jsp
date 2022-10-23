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
<h2> Update Customer Details Form</h2>
<form action="./updatecustomer.jsp?email=${customer.getEmail()}" method="post">
 <div class="bg-light rounded h-100 col-sm-12 col-xl-6">
                 <div class="form-floating mb-3">
                      <input type="text" class="form-control" id="floatingInput"placeholder="First Name" name="firstName" value=${customer.getFirstName()}>
                      <label for="floatingInput">First Name</label>
                 </div>
                 <div class="form-floating mb-3">
                       <input type="text" class="form-control" id="floatingInput"placeholder="Last Name" name="lastName" value=${customer.getLastName()}>
                       <label for="floatingInput">Last Name</label>
                 </div>
                 <div class="form-floating mb-3">
                        <input type="text" class="form-control" id="floatingInput"placeholder="Email" name="email" value=${customer.getEmail()}>
                        <label for="floatingInput">Email</label>
                 </div>
                 <div class="form-floating mb-3">
                         <input type="text" class="form-control" id="floatingInput"placeholder="Phone" name="phone" value=${customer.getPhone()}>
                         <label for="floatingInput"> Phone</label>
                 </div>
                 <div class="form-floating mb-3">
                      <input type="text" class="form-control" id="floatingInput"placeholder="Location" name="firstName" value=${customer.getLocation()}>
                      <label for="floatingInput">Location</label>
                 </div>
                 <div class="form-floating mb-3">
                   <input type="text" class="form-control" id="floatingInput"placeholder="Cargo" name="cargo" value=${customer.getCargo()}>
                   <label for="floatingInput">Cargo</label>
                 </div>
                 <div class="form-floating mb-3">
                   <input type="text" class="form-control" id="floatingInput"placeholder="Delivery Type" name="firstName" value=${customer.getDeliveryType()}>
                   <label for="floatingInput">Delivery Type</label>
                 </div>
 </div>
    <button type="submit" class="btn btn-success">Submit</button>
 </form>


<%
    String customerError = (String) application.getAttribute("addCustomerError");

    if (customerError != null && !customerError.equals("")) {

%>
    <span style="color:red"> ${applicationScope.addCustomerError} </span><br/>

<% } %>

    </div>
</div>
</body>
</html>