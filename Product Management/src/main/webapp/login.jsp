<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div align="center">
		<h2>Login into Product Management System</h2>
		<s:form action="loginAction" class="loginForm">
		<s:textfield name="userName" label="User Name" class="formTextField"></s:textfield>
		<s:password name="password" label="Password" class="formTextField"></s:password>
		<s:submit value="Login" class="actionBtn"></s:submit>
		</s:form>
	</div>
	
	<div align="center">
		<h6>New User? Register below..</h6>
		<a href="register.jsp">
		<button class="actionBtn">Register</button></a>
	</div>
</body>
</html>