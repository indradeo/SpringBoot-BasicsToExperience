<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products</title>
</head>
<body>
	<h2>Available Products</h2>

	<table border="1">
		<thead>
			<tr>
				<td>S.No</td>
				<td>Name</td>
				<td>Price</td>
				<td>Quantity</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${products }" var="p" varStatus="index">
				<tr>
				<td>${index.count }</td>
				<%-- <td>${p.name }</td> --%>
				<%-- <td>${p.price }</td>
				<td>${p.quantity }</td> --%>
			</tr>
			</c:forEach>
		</tbody>

	</table>
</body>
</html>