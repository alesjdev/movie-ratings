<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Movie list</title>
</head>
<body>

<!-- Popular -->
<h3>Popular movies</h3>
<ul>
	<c:forEach var="temp" items="${popular}">
		<li> ${temp} </li>
	</c:forEach>
</ul>
<br>

<!-- Latest -->
<h3>Latest movies</h3>
<ul>
	<li> ${latest} </li>
</ul>
<br>

<!-- Top Rated -->
<h3>Top Rated movies</h3>
<ul>
	<c:forEach var="temp" items="${topRated}">
		<li> ${temp} </li>
	</c:forEach>
</ul>
<br>

<!-- Upcoming -->
<h3>Upcoming movies</h3>
<ul>
	<c:forEach var="temp" items="${upcoming}">
		<li> ${temp} </li>
	</c:forEach>
</ul>
<br>

</body>
</html>