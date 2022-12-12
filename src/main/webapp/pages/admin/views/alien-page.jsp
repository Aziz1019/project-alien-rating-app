<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11/26/2022
  Time: 10:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
    <title>View Aliens</title>
</head>
<body>
<%@ include file="/pages/admin/admin-header.jsp" %>
<%
    session.setAttribute("id", session.getAttribute("id"));
%>
<div class="container-fluid text-center">
    <div class="row content">
        <div class="col-sm-8 text-left">
            <h1>Aliens</h1>
            <table class="table">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Alien Name</th>
                    <th scope="col">Source</th>
                    <th scope="col">Admin Name</th>
                    <th scope="col">Date</th>
                    <th scope="col">Edit</th>
                    <th scope="col">Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${aliens}" var="a">
                    <tr>
                        <td>${a.getId()}</td>
                        <td>${a.getAlienName()}</td>
                        <td>${a.getSource()}</td>
                        <td>${a.getCreatedBy()}</td>
                        <td>${a.getCreatedAt()}</td>
                        <td>
                            <a href="controller?command=edit_alien&id=${a.getId()}">Edit</a>
                        </td>
                        <td>
                            <a href="controller?command=delete_alien&id=${a.getId()}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <br><br>
            <a href="controller?command=forward_alien">Add New Alien</a>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
<%@ include file="/pages/footer.jsp" %>
</body>
</html>