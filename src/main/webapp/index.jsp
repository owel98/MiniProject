<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Login page </title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>
<h1 style="text-align-last:center">Login Form</h1>
<hr style="background-color:black;width:100px;height:3px;">
	<div class="wrapper">
	<center>
		<form action = "Login" method = "post" class="login-register-form">
		<div class="container">
<b>Employee Id:</b><input type="text" name="empId"  placeholder="Enter the ID"><br><br>
<b>Employee Name:</b><input type="text" name="empName"  placeholder="Enter ur name"><br>
 <input type="submit" value="login"  style="text-align:center;  color: white;padding: 6px 5px;margin: 5px 0;border:none;cursor: pointer;
  background-color: green">
  <br><br>
  
				<a href="register.jsp"> <u>New User?</u> </a>
   
  	</center>

</div>
</form>
	</div>
	</body>
</html>