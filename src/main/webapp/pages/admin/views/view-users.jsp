<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
    <title>View Users</title>
</head>
<body>
<%@ include file="/pages/admin/admin-header.jsp" %>
<div class="container-fluid text-center">
    <div class="row content">
        <div class="col-sm-8 text-left">
            <h1>Active Users</h1>
            <table class="table">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Username</th>
                    <th scope="col">Status</th>
                    <th scope="col">Password</th>
                    <th scope="col">Active</th>
                    <th scope="col">Role</th>
                    <th scope="col">Date</th>
                    <th scope="col">Edit</th>
                    <th scope="col">Block</th>
                    <th scope="col">Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${users}" var="u">
                    <tr>
                        <td>${u.getId()}</td>
                        <td>${u.getUsername()}</td>
                        <td>${u.getStatus()}</td>
                        <td>${u.getPassword()}</td>
                        <td>${u.getIsActive()}</td>
                        <td>${u.getRole()}</td>
                        <td>${u.getCreatedAt()}</td>
                        <td>
                            <a href="controller?command=edit&id=${u.getId()}">Edit</a>
                        </td>
                        <td>
                            <a href="controller?command=block&id=${u.getId()}">Block</a>
                        </td>
                        <td>
                            <a href="controller?command=delete&id=${u.getId()}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <br/><a href="controller?command=forward_register">Add New User</a>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
<%@ include file="/pages/footer.jsp" %>
</body>
</html>