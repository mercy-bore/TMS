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
<h2> Add New Vehicle Form</h2>
    <form action="./addvehicle" method="post">
    <div class="bg-light rounded h-100 col-sm-12 col-xl-6">
                 <div class="form-floating mb-3">
                      <input type="text" class="form-control" id="floatingInput"placeholder="Vehicle Type" name="type">
                      <label for="floatingInput">Type</label>
                 </div>
                 <div class="form-floating mb-3">
                   <input type="text" class="form-control" id="floatingInput" placeholder="Plate Number" name="plateNo">
                   <label for="floatingInput">Plate No</label>
                 </div>
                 <div class="form-floating mb-3">
                    <input type="text" class="form-control" id="floatingInput"placeholder="Weight in KG" name="weight">
                    <label for="floatingInput">Weight</label>
                 </div>
                <div class="form-floating mb-3">
                    <input type="text" class="form-control" id="floatingInput"placeholder="Route" name="route">
                    <label for="floatingInput">Route</label>
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
</div>
</div>
</div>
</div>
</body>
</html>