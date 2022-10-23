<%@ page isELIgnored="false" %>
<jsp:include page="header.jsp" />
<div class="container-fluid">
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
    <span style="color:yellow"> ${applicationScope.addVehicleError} </span><br/>

<% } %>

</div>
</div>
</body>
</html>