<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<head>

<title>Customer Confirmation</title>

</head>

<body>
	The customer is confirmed : ${customer.firstName} ${customer.lastName}

	<br /> Free passes : ${customer.freePasses}

	<br /> Post code : ${customer.postCode}
	
	<br /> Course code : ${customer.courseCode}


</body>