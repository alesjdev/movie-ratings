<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Popular movies</title>
</head>
<body>
<h3>Popular movies right now</h3>
<br>
<ul>
    <c:forEach var="temp" items="${popular}">
        <li> ${temp} </li>
    </c:forEach>
</ul>
</body>
</html>