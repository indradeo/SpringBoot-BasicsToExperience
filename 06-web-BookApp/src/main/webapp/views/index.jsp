<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/book">
		<input type="text" name="id" id="id" value="${book.id }" />
		<button type="submit">Get Book</button>
	</form>

	<div>
		<p>Book Id : ${book.id }</p>
		<p>Book name : ${book.name }</p>
		<p>Book price : ${book.price }</p>
	</div>

	<div>
		<form:form method="POST" action="/update" modelAttribute="bookBinding">

			<table>
				<tr>
					<td><form:label path="id">Id</form:label></td>
					<td><form:input path="id" /></td>
				</tr>
				<tr>
					<td><form:label path="name">Name</form:label></td>
					<td><form:input path="name" /></td>
				</tr>
				<tr>
					<td><form:label path="price">Price</form:label></td>
					<td><form:input path="price" /></td>
				</tr>
				<tr>
					<td><form:label path="course">Courses</form:label></td>
					<td><form:select path="course">
							<form:option value="-select-"></form:option>
							<form:options items="${courses }" path="course" />
						</form:select></td>
				</tr>
				<tr>
					<td><input type="submit" value="Submit" /></td>
				</tr>
			</table>
		</form:form>
	</div>

</body>
</html>