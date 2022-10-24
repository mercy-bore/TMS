<%@ page isELIgnored="false" %>
<%@ page import="com.transportsystem.controllers.*" %>
<%@ page import="com.transportsystem.model.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

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
 <h2 style="text-align:center;"> Hello ${sessionScope.username},<br/>Welcome To Transport Management System. <br/> ${sessionScope.loggedInTime}</h2>
 <c:set var="String" value="Welcome to Transport Management System"/>

     <c:if test="${fn:contains(String, 'Transport')}">
        <p>Found Transport string<p>
     </c:if>

     <c:if test="${fn:contains(String, 'TRANSPORT')}">
        <p>Found TRANSPORT string<p>
     </c:if>





 <div class="bg-light rounded h-100 p-4">
 <c:set var="str" value="<%=new java.util.Date()%>" />
     <table border="2" width="100%">
       <tr>
         <td width="100%" colspan="2" bgcolor="#8eb0f5">
           <p align="center">
             <b>
               <font color="#000000" size="6">Formatting:
               <fmt:formatDate value="${str}" type="both" timeStyle="long" dateStyle="long" />
               </font>
             </b>
           </p>
         </td>
       </tr>

       <c:forEach var="zone"
       items="<%=java.util.TimeZone.getAvailableIDs()%>">
         <tr>
           <td width="50%"  bgcolor="#a6c1f5">
             <c:out value="${zone}" />
           </td>
           <td width="50%" bgcolor="#91a2c4">
             <fmt:timeZone value="${zone}">
               <fmt:formatDate value="${str}" timeZone="${zn}"
               type="both"/>
             </fmt:timeZone>
           </td>
         </tr>
       </c:forEach>
     </table>

</div>
</div>
</div>
</div>
</div>
</div>

<jsp:include page="javascriptlibs.jsp"/>

<cft:Footer> 
     </cft:Footer>