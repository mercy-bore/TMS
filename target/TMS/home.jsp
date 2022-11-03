<%@ page isELIgnored="false" %>
<%@ page import="com.transportsystem.controllers.*" %>
<%@ page import="com.transportsystem.model.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
            <br/><br/><br/><br/><br/>

 <div class="col-sm-12 col-xl-12">
 <h2 style="text-align:center;"> Hello ${sessionScope.username},<br/>Welcome To Transport Management System. <br/> ${sessionScope.loggedInTime}</h2>
 <c:set var="String" value="Welcome to Transport Management System"/>

     <c:if test="${fn:contains(String, 'Transport')}">
      <h3>Jstl functions e.g Contains</h3>
        <p>Found Transport string<p>
     </c:if>

     <c:if test="${fn:contains(String, 'TRANSPORT')}">
        <p>Found TRANSPORT string<p>
     </c:if>
     <c:set var="str" value="Transport Management System"/>
           <h3>Jstl functions e.g Length</h3>
           <p>Str: >> Transport Management System</p>
     <p>Length of str is :${fn:length(str)}</p>


 <div class="bg-light rounded h-100 p-4">
  <h3>Jstl formating e.g Date</h3>
 <c:set var="str" value="<%=new java.util.Date()%>" />
     <table border="2" width="100%">
       <tr>
         <td width="100%" colspan="2" bgcolor="#abf0f7">
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
           <td width="50%"  bgcolor="#abf0f7">
             <c:out value="${zone}" />
           </td>
           <td width="50%" bgcolor="#abf0f7">
             <fmt:timeZone value="${zone}">
               <fmt:formatDate value="${str}" timeZone="${zn}"
               type="both"/>
             </fmt:timeZone>
           </td>
         </tr>
      </c:forEach>
     </table>

<!--! Formatting Tags	Descriptions
fmt:parseNumber	It is used to Parses the string representation of a currency, percentage or number.
fmt:timeZone	It specifies a parsing action nested in its body or the time zone for any time formatting.
fmt:formatNumber	It is used to format the numerical value with specific format or precision.
fmt:parseDate	It parses the string representation of a time and date.
fmt:bundle	It is used for creating the ResourceBundle objects which will be used by their tag body.
fmt:setTimeZone	It stores the time zone inside a time zone configuration variable.
fmt:setBundle	It loads the resource bundle and stores it in a bundle configuration variable or the named scoped variable.
fmt:message	It display an internationalized message.
fmt:formatDate	It formats the time and/or date using the supplied pattern and styles. -->
<!--! JSTL Functions	Description
fn:contains()	It is used to test if an input string containing the specified substring in a program.
fn:containsIgnoreCase()	It is used to test if an input string contains the specified substring as a case insensitive way.
fn:endsWith()	It is used to test if an input string ends with the specified suffix.
fn:escapeXml()	It escapes the characters that would be interpreted as XML markup.
fn:indexOf()	It returns an index within a string of first occurrence of a specified substring.
fn:trim()	It removes the blank spaces from both the ends of a string.
fn:startsWith()	It is used for checking whether the given string is started with a particular string value.
fn:split()	It splits the string into an array of substrings.
fn:toLowerCase()	It converts all the characters of a string to lower case.
fn:toUpperCase()	It converts all the characters of a string to upper case.
fn:substring()	It returns the subset of a string according to the given start and end position.
fn:substringAfter()	It returns the subset of string after a specific substring.
fn:substringBefore()	It returns the subset of string before a specific substring.
fn:length()	It returns the number of characters inside a string, or the number of items in a collection.
fn:replace()	It replaces all the occurrence of a string with another string sequence. -->

</div>
</div>
</div>
</div>
</div>
</div>

<jsp:include page="javascriptlibs.jsp"/>

</body>
</html>