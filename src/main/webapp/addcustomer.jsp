<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="cht" uri="WEB-INF/tlds/header.tld" %>
<%@ taglib prefix="cft" uri="WEB-INF/tlds/footer.tld" %>

<cht:Header applicationLabel="${applicationScope.applicationLabel}" />

<div class="container-fluid">
<h2> Add New Client Details Form</h2>
    <form action="./addcustomer" method="post">
    <div class="bg-light rounded h-100 col-sm-12 col-xl-6">
                 <div class="form-floating mb-3">
                      <input type="text" class="form-control" id="floatingInput"placeholder="First Name" name="firstName">
                      <label for="floatingInput">First Name</label>
                 </div>
                 <div class="form-floating mb-3">
                   <input type="text" class="form-control" id="floatingInput" placeholder="Last Name" name="lastName">
                   <label for="floatingInput">Last Name</label>
                 </div>
                 <div class="form-floating mb-3">
                    <input type="text" class="form-control" id="floatingInput"placeholder="Email" name="email">
                    <label for="floatingInput">Email</label>
                 </div>
                <div class="form-floating mb-3">
                    <input type="text" class="form-control" id="floatingInput"placeholder="Phone No" name="phone">
                    <label for="floatingInput">Phone No</label>
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