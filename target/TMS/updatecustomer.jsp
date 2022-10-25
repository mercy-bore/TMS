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
<%@ taglib prefix="cft" uri="WEB-INF/tlds/footer.tld" %><%@ taglib prefix="cht" uri="WEB-INF/tlds/header.tld" %>
<%@ taglib prefix="cft" uri="WEB-INF/tlds/footer.tld" %>
<cht:Header></cht:Header>


<jsp:useBean id="vc" class="com.transportsystem.controllers.VehicleController" />
<jsp:useBean id="cc" class="com.transportsystem.controllers.CustomerController" />
 <%
     List<Customer> customers = cc.list((Connection) application.getAttribute("dbConnection"), new Customer());
      pageContext.setAttribute("customers", customers);
%>
<div class="container-fluid">
<h2> Update Customer Details Form</h2>
  <c:forEach items="${customers}" var="customer">
<form action="./updatecustomer" method="post">
 <div class="bg-light rounded h-100 col-sm-12 col-xl-6">
                  <div class="form-floating mb-3">
                       <input type="text" class="form-control" id="floatingInput"placeholder="Id" name="id" value="${customer.id}">
                       <label for="floatingInput">Id</label>
                  </div>
                 <div class="form-floating mb-3">
                      <input type="text" class="form-control" id="floatingInput"placeholder="First Name" name="firstName" value="${customer.firstName}">
                      <label for="floatingInput">First Name</label>
                 </div>
                 <div class="form-floating mb-3">
                       <input type="text" class="form-control" id="floatingInput"placeholder="Last Name" name="lastName" value="${customer.lastName}">
                       <label for="floatingInput">Last Name</label>
                 </div>
                 <div class="form-floating mb-3">
                        <input type="text" class="form-control" id="floatingInput"placeholder="Email" name="email" value="${customer.email}">
                        <label for="floatingInput">Email</label>
                 </div>
                 <div class="form-floating mb-3">
                         <input type="text" class="form-control" id="floatingInput"placeholder="Phone" name="phone" value="${customer.phone}">
                         <label for="floatingInput"> Phone</label>
                 </div>
                 <div class="form-floating mb-3">
                      <input type="text" class="form-control" id="floatingInput"placeholder="Location" name="location" value="${customer.location}">
                      <label for="floatingInput">Location</label>
                 </div>
                 <div class="form-floating mb-3">
                   <input type="text" class="form-control" id="floatingInput"placeholder="Cargo" name="cargo" value="${customer.cargo}">
                   <label for="floatingInput">Cargo</label>
                 </div>
                 <div class="form-floating mb-3">
                   <input type="text" class="form-control" id="floatingInput"placeholder="Delivery Type" name="deliveryType" value="${customer.deliveryType}">
                   <label for="floatingInput">Delivery Type</label>
                 </div>
 </div>
    <button type="submit" class="btn btn-success">Submit</button>
 </form>
  </c:forEach>


<%
    String customerError = (String) application.getAttribute("addCustomerError");

    if (customerError != null && !customerError.equals("")) {

%>
    <span style="color:red"> ${applicationScope.addCustomerError} </span><br/>

<% } %>

    </div>
</div>
<cft:Footer></cft:Footer>