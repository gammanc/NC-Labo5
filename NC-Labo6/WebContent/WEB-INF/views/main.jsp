<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CRUD Esudiantes</title>
</head>
<body>
	<h1>${message}</h1>
	
	<form action="${pageContext.request.contextPath}/search" method="post">
		<label>Buscar por ID: </label><input type="number" name="idsearch" required>
		<input type="submit" value="Buscar"/>
	</form>
	
	<form action="${pageContext.request.contextPath}/save" method="post">
		<input type="submit" value="Agregar un nuevo usuario"/>
	</form>
	
	<table>
		<tr>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>Edad</th>
			<th>Estado</th>
			<th>Acciones</th>
		</tr>
		<c:forEach items="${students}" var="student">
		<tr>
			<th>${student.sName}</th>
			<th>${student.lName}</th>
			<th>${student.sAge}</th>
			<th>${student.activoDelegate}</th>
			<th>
				<button onclick="window.location.href='${pageContext.request.contextPath}/edit/${student.cStudent}'">Editar</button>
				<button onclick="window.location.href='${pageContext.request.contextPath}/delete/${student.cStudent}'">Eliminar</button>	
			</th>
		</tr>
		</c:forEach>
	</table>
</body>
</html>