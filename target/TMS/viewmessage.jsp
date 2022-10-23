<%@ page isELIgnored="false" %>
<jsp:include page="header.jsp"/>
<div class="container-fluid">
<h2 style="color:blue;"> Contact Us</h2>

<jsp:useBean id="contactUs" class="com.transportsystem.model.ContactUs" />
<jsp:setProperty name="contactUs" property="*" />
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
</body>
</html>