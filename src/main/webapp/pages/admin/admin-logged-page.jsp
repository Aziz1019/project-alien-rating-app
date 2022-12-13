<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Admin Page</title>
</head>
<body>
<%@ include file="/pages/admin/admin-header.jsp" %>

<div class="container-fluid text-center">
    <div class="row content">
        <div class="col-sm-8 text-left">
            <h1>Welcome  ${sessionScope.user_name}</h1>
        </div>
    </div>
</div>

<%@ include file="/pages/footer.jsp" %>

</body>
</html>
