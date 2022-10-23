<%@ page isELIgnored="false" %>
<%@ page import="com.transportsystem.controllers.*" %>
<%@ page import="com.transportsystem.model.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<jsp:include page="header.jsp" />
<div class="container-fluid">
<div class="container-xxl position-relative bg-white d-flex p-0">
        <jsp:include page="sidebar.jsp"/>
        <!-- Content Start -->
        <div class="content">
            <!-- Navbar Start -->
                <jsp:include page="navbar.jsp"/>
            <!-- Navbar End -->
            <div class="container-fluid pt-4 px-4">
            <br/><br/><br/><br/><br/>

 <div class="col-sm-12 col-xl-12">
 <h2 style="text-align:center;color:"> Hello ${sessionScope.username},<br/>Welcome To Transport Management System. <br/>You  Logged In At <br/> ${sessionScope.loggedInTime}</h2>

 <div class="bg-light rounded h-100 p-4">

</div>
</div>
</div>
</div>
</div>
</div>

<jsp:include page="javascriptlibs.jsp"/>
</body>
</html>