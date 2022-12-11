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
    <title>Edit Form</title>
</head>
<body>


<h1>Edit Form</h1>
<table>
    <form action="controller" method="get">
        <input type="hidden" name="command" value="update_alien"/>

        <tr>
            <td>Id:</td>
            <td><input type="text" name="id" value="${currentAlien.getId()}"/>
            </td>
        </tr>
        <tr>
            <td>Alien Name:</td>
            <td>
                <input type="text" name="alien_name" value="${currentAlien.getAlienName()}"/></td>
        </tr>
        <tr>
            <td>Source:</td>
            <td>
                <input type="text" name="source" value="${currentAlien.getSource()}"/></td>
        </tr>
        <tr>
            <td>Image link:</td>
            <td>
                <input type="text" name="image_url" value="${currentAlien.getImageUrl()}"/></td>
        </tr>

        <tr>
            <td colspan="2"><input type="submit" value="Update Alien"/></td>
        </tr>
    </form>
</table>

</body>
</html>

