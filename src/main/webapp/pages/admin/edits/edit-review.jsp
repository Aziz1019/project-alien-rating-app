<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11/26/2022
  Time: 10:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Edit Review</title>
</head>
<body>


<h1>Edit Review</h1>
<table>
    <form action="controller" method="get">
        <input type="hidden" name="command" value="update_review"/>
        <tr><td>ID:</td><td>
            <input type="text" name="id" value="${currentReview.getId()}"/></td></tr>
        <tr><td>User Id:</td><td>
            <input type="text" name="user_id" value="${currentReview.getUserId()}"/></td></tr>

        <tr><td>Alien Id:</td><td>
            <input type="text" name="alien_id" value="${currentReview.getAlienId()}"/></td></tr>

        <tr><td>Review:</td><td>
            <input type="text" name="review" value="${currentReview.getReview()}"/></td></tr>

        <tr><td>Rating</td><td>
            <input type="text" name="rating" value="${currentReview.getRating()}"/></td></tr>
        <tr><td colspan="2"><input type="submit" value="Update Review"/></td></tr>
    </form>
</table>

</body>
</html>
