<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Review Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../../css/style.css">
</head>
<body>

<h1>Welcome to Review Page</h1>
<c:set var="alienId" scope="request" value='${sessionScope.alien_id}'/>
<c:set var="userId" scope="request" value='${sessionScope.user_id}'/>
<c:set var="alien" scope="request" value='${sessionScope.alien}'/>


<form action="controller" method="get">

    <input type="hidden" name="command" value="add_review">
    <input type="hidden" name="alien_id" value="${alienId}">
    <input type="hidden" name="user_id" value="${userId}">
    <div class="form-group">
        <img src="${alien.getImageUrl()}" class="img-thumbnail" alt="someImage" width="250">
    </div>
    <div class="form-group">
        <label for="review">Leave your feedback here</label>
        <textarea class="form-control" rows="5" cols="30" id="review" name="review"
                  placeholder="Enter Your Review here..." required></textarea>
    </div>
    <div class="form-group">
        <div class="rate">
            <input type="radio" id="star5" name="rate" value="5"/>
            <label for="star5" title="text">5 stars</label>
            <input type="radio" id="star4" name="rate" value="4"/>
            <label for="star4" title="text">4 stars</label>
            <input type="radio" id="star3" name="rate" value="3"/>
            <label for="star3" title="text">3 stars</label>
            <input type="radio" id="star2" name="rate" value="2"/>
            <label for="star2" title="text">2 stars</label>
            <input type="radio" id="star1" name="rate" value="1"/>
            <label for="star1" title="text">1 star</label>
        </div>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</body>
</html>
