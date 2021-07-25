<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Movie list</title>
</head>
<body>
	<ul>
		<c:forEach var="temp" items="${movies}">
			<li> ${temp} </li>
		</c:forEach>
	</ul>
</body>
</html>