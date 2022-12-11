<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11/28/2022
  Time: 8:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Review Page</title>
    <link rel="stylesheet" type="text/css" href="../../css/style.css">
</head>
<body>

<h1>Welcome to Review Page</h1>
<p>User Adds a Review to a particular alien</p>

<%
    request.setAttribute("alienId", session.getAttribute("alien_id"));
    request.setAttribute("userId", session.getAttribute("user_id"));
%>

<form action="controller" method="get">

    <input type="hidden" name="command" value="add_review">
    <input type="hidden" name="alien_id" value="${alienId}">
    <input type="hidden" name="user_id" value="${userId}">

    <label for="review">Review</label>
    <br>
    <textarea rows="5" cols="30" id="review"  name="review" placeholder="Enter Your Review here..." required></textarea>
    <br>
    <br>
    <div class="rate">
        <input type="radio" id="star5" name="rate" value="5" />
        <label for="star5" title="text">5 stars</label>
        <input type="radio" id="star4" name="rate" value="4" />
        <label for="star4" title="text">4 stars</label>
        <input type="radio" id="star3" name="rate" value="3" />
        <label for="star3" title="text">3 stars</label>
        <input type="radio" id="star2" name="rate" value="2" />
        <label for="star2" title="text">2 stars</label>
        <input type="radio" id="star1" name="rate" value="1" />
        <label for="star1" title="text">1 star</label>
    </div>

    <input type="submit" value="Add Review">

</form>


</body>
</html>
