<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11/25/2022
  Time: 9:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Alien App</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body>
<%@ include file="/pages/user/user-header.jsp" %>
<%
    session.setAttribute("id", session.getAttribute("id"));
%>

<div class="container-fluid text-center">
    <div class="row content">
        <div class="col-sm-8 text-left">
            <h1>Welcome to Alien Review App <%= session.getAttribute("user_name") %>!</h1>
            <p>This is the place you are going to enjoy reviewing you favorite Comics Heroes from different universes.
                Like DC and Marvel Universe.
                Review and leave your feedback. And watch how close your rating was right among others.
                If positive, your score will be on top.
            <hr>
        </div>
    </div>
</div>
<%@ include file="/pages/footer.jsp" %>
</body>
</html>
