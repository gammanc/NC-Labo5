<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSTL Test</title>
</head>
<body>
	<h1>${message}</h1>
	
	<form action="${pageContext.request.contextPath}/search" method="post">
		<label>Buscar por ID: </label><input type="number" name="idsearch" required>
		<input type="submit" value="Buscar"/>
	</form>
	
	<table>
		<tr>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>Edad</th>
			<th>Estado</th>
			<th></th>
		</tr>
		<tr>
			<th>${student.s_name}</th>
			<th>${student.s_lname}</th>
			<th>${student.s_age}</th>
			<th>${student.activoDelegate}</th>
		</tr>
	</table>
</body>
</html>