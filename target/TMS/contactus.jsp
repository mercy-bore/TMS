<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="cht" uri="WEB-INF/tlds/header.tld" %>
<%@ taglib prefix="cft" uri="WEB-INF/tlds/footer.tld" %>

<cht:Header applicationLabel="${applicationScope.applicationLabel}" />

<div class="container-fluid">
<h2> Contact Us</h2>
<div class="d-flex align-items-center justify-content-between mb-2 col-sm-12 col-xl-6">
       <h6 class="mb-0">Leave a comment.....</h6>
</div>
      <form action="./viewmessage.jsp" method="post">
       <div class="bg-light rounded h-100 col-sm-12 col-xl-6">
              <div class="form-floating mb-3">
                  <input type="email" class="form-control" id="floatingInput"
                      placeholder="name@example.com" name= "contactEmail">
                  <label for="floatingInput">Email address</label>
              </div>
              <div class="form-floating mb-3">
                  <input type="text" class="form-control" id="floatingPassword"
                      placeholder="Phone No"name= "phoneNumber">
                  <label for="floatingPassword">Phone No</label>
              </div>

              <div class="form-floating">
                  <textarea class="form-control" placeholder="Leave a comment here"
                      id="floatingTextarea" style="height: 150px;"name= "message"></textarea>
                  <label for="floatingTextarea">Message</label>
              </div>
       </div>
       <button type="submit" class="btn btn-success">Submit</button>
      </form>
<br/><br/><br/><br/>
${param.invalidAccess}
${param.invalidAccessWarn}

</div>
</div>
</body>
</html>