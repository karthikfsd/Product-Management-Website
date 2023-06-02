<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div align="center">
		<h2>Register to access Product Management System</h2>
		<s:form action="registerAction" class="loginForm">
		<s:textfield name="userName" key="global.userName" class="formTextField"></s:textfield>
		<s:textfield name="password" key="global.password" class="formTextField"></s:textfield>
		<s:password name="repassword" key="global.repassword" class="formTextField"></s:password>
		<s:textfield name="email" key="global.email" class="formTextField"></s:textfield>
		<s:submit key="global.register" class="actionBtn"></s:submit>
		</s:form>
		
		<s:url action="changeLocaleAction" var="urlEn">
			<s:param name="request_locale">en</s:param>
		</s:url>
		<a href="${urlEn}">English</a>
		
		<s:url action="changeLocaleAction" var="urlFr">
			<s:param name="request_locale">fr</s:param>
		</s:url>
		<a href="${urlFr}">French</a>
		
		<s:url action="changeLocaleAction" var="urlHi">
			<s:param name="request_locale">hi</s:param>
		</s:url>
		<a href="${urlHi}">Hindi</a>
	</div>
</body>
</html>