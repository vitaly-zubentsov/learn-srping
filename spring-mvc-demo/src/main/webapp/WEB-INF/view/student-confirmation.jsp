<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<head>

	<title>Student Confirmation</title>

</head>

<body>
		
	The student is confirmed : ${student.name} ${student.lastName}
	
	<br/>
	
	The country : ${student.country}
	
	<br/>
	
	Favorite language: ${student.favoriteLanguage}
	
	<br/>
	
	Operating Systems:
	<ul>			
		<c:forEach var="temp" items="${student.operatingSystems}">
		
			<li> ${temp} </li>
	
		</c:forEach>	
	</ul>
	
	
	
		
</body>