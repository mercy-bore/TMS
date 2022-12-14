<%@ page isELIgnored="false" %>
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
<h2> Add New Order Form</h2>
    <form action="./addorder" method="post">
    <div class="bg-light rounded h-100 col-sm-12 col-xl-6">
                 <div class="form-floating mb-3">
                      <input type="text"  maxlength="40" class="form-control" id="floatingInput" placeholder="Cargo" name="cargo">
                      <label for="floatingInput">Cargo</label>
                 </div>
                 <div class="form-floating mb-3">
                   <input type="text"  maxlength="10" class="form-control" id="floatingInput" placeholder="Start Location" name="startLocation">
                   <label for="floatingInput">Start Location</label>
                 </div>
                 <div class="form-floating mb-3">
                    <input type="text"  maxlength="10" class="form-control" id="floatingInput" placeholder="Destination" name="destination">
                    <label for="floatingInput">Destination</label>
                 </div>
                 <div class="form-floating mb-3">
                                   <select class="form-control" name="status">
                                       <option value="active" selected>Active</option>
                                       </select>
                                       <label for="floatingInput">Status</label>
                                  </div>
                 <div class="form-floating mb-3">
                                 <select class="form-control" name="customerId">
                                     <option value="none" selected disabled hidden>Select a Customer</option>
                                          <c:forEach items="${CustomerView.list}" var="customer">
                                                <option value="${customer.id}">
                                                  ${customer.firstName}
                                                </option>
                                          </c:forEach>
                                 </select>
                                     <label for="floatingInput">Customer</label>
                                 </div>
                 <div class="form-floating mb-3">
                                    <select class="form-control" name="driverId">
                                       <option value="none" selected disabled hidden>Select a Driver</option>
                                         <c:forEach items="${driverBean.getDriverListWithoutOrder()}" var="driver">
                                               <option value="${driver.id}">
                                                 ${driver.firstName}
                                               </option>
                                         </c:forEach>
                                    </select>
                                    <label for="floatingInput">Driver</label>
                                 </div>


                                <div class="form-floating mb-3">
                                <select class="form-control" name="vehicleId">
                                     <option value="none" selected disabled hidden>Select a Vehicle</option>
                                         <c:forEach items="${vehicleBean.getVehicleListWithoutOrder()}" var="vehicle">
                                               <option value="${vehicle.id}">
                                                 ${vehicle.id}
                                               </option>
                                         </c:forEach>
                                </select>
                                <label for="floatingInput">Vehicle</label>
                                </div>

    </div>
     <button type="submit" class="btn btn-success" onclick="return confirmAdd()">Submit</button>
</form>
<%
    String loginError = (String) application.getAttribute("addVehicleError");

    if (loginError != null && !loginError.equals("")) {

%>
    <span style="color:red"> ${applicationScope.addVehicleError} </span><br/>

<% } %>
</div>
</div>
</div>
</div>
</div>
<script>
    function confirmAdd(){
        return confirm("Do You Want To Add Order Details");
    }
</script>
</body>
</html>