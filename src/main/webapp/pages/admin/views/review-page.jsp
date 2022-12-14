<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Review Lists</title>
</head>
<body>
<%@ include file="/pages/admin/admin-header.jsp" %>
<div class="container-fluid text-center">
    <div class="row content">
        <div class="col-sm-8 text-left">
            <h1>Reviews</h1>
            <table class="table">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">User ID</th>
                    <th scope="col">Review</th>
                    <th scope="col">Alien ID</th>
                    <th scope="col">Rating</th>
                    <th scope="col">Date</th>
                    <th scope="col">Edit</th>
                    <th scope="col">Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${reviews}" var="r">
                    <tr>
                        <td>${r.getId()}</td>
                        <td>${r.getUserId()}</td>
                        <td>${r.getReview()}</td>
                        <td>${r.getAlienId()}</td>
                        <td>${r.getRating()}</td>
                        <td>${r.getCreatedAt()}</td>
                        <td>
                            <a href="controller?command=edit_review&id=${r.getId()}">Edit</a>
                        </td>
                        <td>
                            <a href="controller?command=delete_review&id=${r.getId()}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>

<%@ include file="/pages/footer.jsp" %>
</body>
</html>