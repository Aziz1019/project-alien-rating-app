<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11/27/2022
  Time: 10:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Page</title>
</head>
<body>
<%@ include file="/pages/admin/admin-header.jsp" %>

<div class="container-fluid text-center">
    <div class="row content">
        <div class="col-sm-8 text-left">
            <h1>Welcome <%= session.getAttribute("user_name") %>!</h1>
        </div>
    </div>
</div>

<%@ include file="/pages/footer.jsp" %>

</body>
</html>
