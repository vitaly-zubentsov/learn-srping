<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>

<head>

<title>Customer Registration Form</title>

<style>
.error {
	color: red
}
</style>

</head>

<body>
	<i>Fill out the form. Asterisk (*) means required.</i>

	<form:form action="processForm" modelAttribute="customer">
	
	First name : <form:input path="firstName" />

		<br />
		<br />
	
		Last name(*) : <form:input path="lastName" />

		<form:errors path="lastName" cssClass="error" />

		<br />
		<br />
		
		Free passes(*)  : <form:input path="freePasses" />
		<form:errors path="freePasses" cssClass="error" />

		<br />
		<br />
		
		Post code : <form:input path="postCode" />
		<form:errors path="postCode" cssClass="error" />

		<br />
		<br />
		
		Course code : <form:input path="courseCode" />
		<form:errors path="courseCode" cssClass="error" />

		<br />
		<br />

		<input type="submit" value="Submit" />

	</form:form>

</body>