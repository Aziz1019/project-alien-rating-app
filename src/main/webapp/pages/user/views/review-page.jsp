<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Review Lists</title>
</head>
<body>
<%@ include file="/pages/user/user-header.jsp" %>
<div class="container-fluid text-center">
    <div class="row content">
        <div class="col-sm-8 text-left">
            <h1>Reviews</h1>
            <table class="table">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">Source</th>
                    <th scope="col">Alien Name</th>
                    <th scope="col">Review</th>
                    <th scope="col">Rating</th>
                    <th scope="col">Username</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${reviews}" var="r">
                    <tr>
                        <td>${r.getSource()}</td>
                        <td>${r.getAlienName()}</td>
                        <td>${r.getReview()}</td>
                        <td>${r.getRating()}</td>
                        <td>${r.getUsername()}</td>
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