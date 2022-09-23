<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Home </title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>
	<h2 style="margin-top: 40px;color:white;text-align: center;font-size:40px"> Login Successful </h2>
	<h1 style="color:white"> Welcome! <%= session.getAttribute("empName") %> </h1>
	<center>
	<form action="AllUser" method="get" class="main-page-form">
		<input type="submit" value="View User details" class="center-button">
	</form>
	</center>
	<center>
	<form action="Logout" method="post" class="main-page-form">
		<input type="submit" value="Logout" class="logout-button">
	</form>
	</center>
	
</body>
</html>