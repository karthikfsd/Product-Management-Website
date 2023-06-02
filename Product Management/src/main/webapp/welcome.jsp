<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<link rel="stylesheet" href="style.css">
<sx:head/>
</head>
<body>
<%@ include file = "header.jsp" %>
	<div class="form-container">
	<s:form action="welcomeAction" class="form-container">
		<s:textfield name="productName" label="Product Name" class="filterTextField"></s:textfield>
		<s:textfield name="productCategory" label="Product Category" class="filterTextField"></s:textfield>
		<sx:datetimepicker name="createdDate" label="Create Date" displayFormat="MMM-dd-yyyy" cssClass="datetimepicker"></sx:datetimepicker>
		<s:submit value="Search Product" class="filteractionBtn"></s:submit>
	</s:form>
	</div>
	
	<table width ="750" align ="center" class="productTable">
		<thead>
			<tr>
				<th>Product ID</th>
				<th>Product Name</th>
				<th>Product Category</th>
				<th>Product Price Rs</th>
				<th>Created Date</th>
				<th colspan="2">Actions</th>
			</tr>
		</thead>
		
		<s:iterator value="product" var="prod">
			<tr>
				<td>
					<s:property value="#prod.productId"/>
				</td>
				<td>
					<s:property value="#prod.productName"/>
				</td>
				<td>
					<s:property value="#prod.productCategory"/>
				</td>
				<td>
					<s:property value="#prod.productPrice"/>
				</td>
				<td>
					<s:property value="#prod.createdDate"/>
				</td>
				<td>
					<a href="updateDataAction?productId=<s:property value="#prod.productId"/>">
					<button class="actionBtn">Update</button></a>
				</td>
				<td>
					<a href="deleteAction?productId=<s:property value="#prod.productId"/>">
					<button class="actionBtn">Delete</button></a>
				</td>
			</tr>
		</s:iterator>			
	</table>
</body>
</html>