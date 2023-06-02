<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

<%
if(session.getAttribute("LoggedInUser") == null){
	response.sendRedirect("login.jsp");
}
%>
	<div align="right">
		<p>Current User: <s:property value="#session.LoggedInUser"/></p>
		<p>Logged In DateTime: <s:property value="#session.now"/></p>
	</div>
<div class="topnav">
  <a class="active" href="welcomeAction">Home</a>
  <a href="addProduct.jsp">Add Product</a>
  <a href="logoutAction" class="right">Logout</a>
</div>
</body>
</html>