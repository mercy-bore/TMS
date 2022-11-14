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
<h2> Update Order Form</h2>
<form action="./updateorder" method="post">
   <% Long a = Long.valueOf(Integer.parseInt(request.getParameter("id")));
        pageContext.setAttribute("id", a);
   %>
      <c:set var="order" value = "${orderBean.getOrder(id)}" />
 <div class="bg-light rounded h-100 col-sm-12 col-xl-6">
                 <div class="form-floating mb-3">
                       <input type="hidden" class="form-control" id="floatingInput"placeholder="Id" name="id" value="${order.id}">
                       <label for="floatingInput">Id</label>
                 </div>
                 <div class="form-floating mb-3">
                      <input type="text" class="form-control" id="floatingInput"placeholder="Cargo" name="cargo" value="${order.cargo}">
                      <label for="floatingInput">Cargo</label>
                 </div><tr>
                 <div class="form-floating mb-3">
                       <input type="text" class="form-control" id="floatingInput"placeholder="Start Location" name="startLocation" value="${order.startLocation}">
                       <label for="floatingInput">Start Location</label>
                 </div>
                 <div class="form-floating mb-3">
                    <input type="text" class="form-control" id="floatingInput"placeholder="Destination" name="destination" value="${order.destination}">
                    <label for="floatingInput">Destination</label>
                 </div>
                 <div class="form-floating mb-3">
                    <input type="text" class="form-control" id="floatingInput"placeholder="Name" name="name" value="${order.name}">
                    <label for="floatingInput">Name</label>
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
<cft:Footer>
     </cft:Footer>