<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="id" scope="session" value='${sessionScope.id}'/>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Alien App</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>

<%@ include file="/pages/user/user-header.jsp" %>
<div class="container-fluid text-center">
    <div class="row content">
        <div class="col-sm-8 text-left">
            <h1>Aliens</h1>
            <table class="table">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">Alien Name</th>
                    <th scope="col">Source</th>
                    <th scope="col">Date</th>
                    <th scope="col">Image</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${aliens}" var="a">
                    <tr>
                        <td>${a.getAlienName()}</td>
                        <td>${a.getSource()}</td>
                        <td>${a.getCreatedAt()}</td>
                        <td><a href="controller?command=forward_review&page=add_review&alien_id=${a.getId()}&user_id=${id}">
                            <img src="${a.getImageUrl()}" width="50" alt="Image of an alien">
                        </a></td>
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