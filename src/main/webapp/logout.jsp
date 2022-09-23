<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Logout page </title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body style="text-align: center">
	<%
	session.removeAttribute("empName");
	session.removeAttribute("uid");
	session.invalidate();
	%>
<div class="container">
	<h1 style="margin-top: 50px;color:white;text-align: center;font-size:50px"><b>Logged out successfully!</b></h1>
	<a href="index.jsp" style="font-size: 30px;color:green"> Login again </a>
	</div>
</body>
</html>