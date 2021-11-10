<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<head>

	<title>Student Form</title>

</head>

<body>

	<form:form action="processForm" modelAttribute="student">
		
		First name : <form:input path="name"/>
		
		<br/>
		
		Last name  : <form:input path="lastName"/>
		
		<br/>
		
		Country <form:select path="country">
		
			<form:options items="${student.countryOptions}" />
			
		</form:select>
		
		<br/> 
		
		Favorite language:
		
		<br/>
		
		Java <form:radiobutton path="favoriteLanguage" value="Java"/>
		PHP <form:radiobutton path="favoriteLanguage" value="PHP"/>
		C# <form:radiobutton path="favoriteLanguage" value="C#"/>
		Ruby <form:radiobutton path="favoriteLanguage" value="Ruby"/>
		
		<br/> 
	
		<input type="submit" value="Submit">
		
	</form:form>

</body>