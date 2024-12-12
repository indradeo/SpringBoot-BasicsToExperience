<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div>
		<h2 style="color: green">${save }</h2>
	</div>
	<form:form method="POST" action="/save" modelAttribute="product">
	<table>
		<tr>
			<td><form:label path="name">Name :</form:label></td>
			<td><form:input path="name" /></td>
		</tr>
		<tr>
			<td><form:label path="price">Price : </form:label></td>
			<td><form:input path="price" /></td>
		</tr>
		<tr>
			<td><form:label path="quantity">Quantity :</form:label></td>
			<td><form:input path="" /></td>
		</tr>
		<tr><td><form:input type="submit" value="Submit" path=""/></td></tr>
		
	</table>
		
	</form:form>
	<div>
		<a href="../viewProducts">View All Products</a>
	</div>
</body>
</html>