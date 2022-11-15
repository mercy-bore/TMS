<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="cht" uri="WEB-INF/tlds/header.tld" %>
<%@ taglib prefix="cft" uri="WEB-INF/tlds/footer.tld" %>

<cht:Header applicationLabel="${applicationScope.applicationLabel}" />

<div class="container-fluid">
<h2> Add New Order Form</h2>
    <form action="./addorder" method="post">
    <div class="bg-light rounded h-100 col-sm-12 col-xl-6">
                 <div class="form-floating mb-3">
                      <input type="text" class="form-control" id="floatingInput" placeholder="Cargo" name="cargo">
                      <label for="floatingInput">Cargo</label>
                 </div>
                 <div class="form-floating mb-3">
                   <input type="text" class="form-control" id="floatingInput" placeholder="Start Location" name="startLocation">
                   <label for="floatingInput">Start Location</label>
                 </div>
                 <div class="form-floating mb-3">
                    <input type="text" class="form-control" id="floatingInput" placeholder="Destination" name="destination">
                    <label for="floatingInput">Destination</label>
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
                                         <c:forEach items="${orderBean.test2()}" var="order">
                                               <option value="${order.driver.id}">
                                                 ${order.driver.firstName}
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
    <button type="submit" class="btn btn-success">Submit</button>
    </form>


<%
    String loginError = (String) application.getAttribute("addVehicleError");

    if (loginError != null && !loginError.equals("")) {

%>
    <span style="color:red"> ${applicationScope.addVehicleError} </span><br/>

<% } %>

</div>
</div>
</body>
</html>