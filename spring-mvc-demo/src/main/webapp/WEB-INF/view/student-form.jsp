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
		
			<form:option value="Russia" label="Russia"></form:option>
			<form:option value="England" label="England"></form:option>
			<form:option value="India" label="India"></form:option>
			<form:option value="Brazil" label="Brazil"></form:option>
			
		</form:select>
		
		<br/>
	
		<input type="submit" value="Submit">
		
	</form:form>

</body>