<%@ page isELIgnored="false" %>
<%@ page import="javax.inject.Inject;" %>
<%@ page import="java.sql.*" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="cht" uri="WEB-INF/tlds/header.tld" %>
<%@ taglib prefix="cft" uri="WEB-INF/tlds/footer.tld" %>

<cht:Header applicationLabel="${applicationScope.applicationLabel}" />
<jsp:useBean id="contactUs" class="com.transportsystem.model.ContactUs" />

<div class="container-fluid">
<h2 class="text-primary"> Contact Us</h2>
<jsp:setProperty name="contactUs" property="*" /> -->

    <div class="container-xxl position-relative bg-white d-flex p-0">
        <jsp:include page="sidebar.jsp"/>
        <!-- Content Start -->
        <div class="content">
            <!-- Navbar Start -->
                <jsp:include page="navbar.jsp"/>
            <!-- Navbar End -->
            
            <div class="container-fluid pt-4 px-4">
<div class="d-flex align-items-center justify-content-between mb-2 col-sm-12 col-xl-6">
<div class="bg-light rounded h-100 col-sm-12 col-xl-6">
<div class="form-floating mb-3">
<p style="font-size:28px;">
    Thank You <br/>
    Email: ${contactUs.contactEmail}<br/>
    Phone: ${contactUs.messageAvailable}<br/>
    for contacting us.
</p>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
<jsp:include page="javascriptlibs.jsp"/>
<cft:Footer> </cft:Footer>