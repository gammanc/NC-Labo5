<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${message}</title>
</head>
<body>
	<h1>${message}</h1>
	<form:form action="${pageContext.request.contextPath}/formData" method="POST" modelAttribute="student">
		<form:input type="hidden" name="id" path="cStudent"/>
             <table>
                <tr>
                    <td><label>Nombre : </label></td>
                    <td><form:input type="text" name="name" path="sName"/></td>
                </tr>
                <tr>
                    <td><label>Apellido : </label></td>
                    <td><form:input type="text" name="lname" path="lName"/></td>
                </tr>
                <tr>
                    <td><label>Edad : </label></td>
                    <td><form:input type="number" name="age" path="sAge"/></td>
                </tr>
                <tr>
                    <td><label>Estado : </label></td>
                    <td>
                    	<form:radiobutton name="status" path="bActivo" value="true"/><label>Activo</label> 
						<form:radiobutton name="status" path="bActivo" value="false"/><label>Inactivo</label>                     
                    </td>
                </tr>
                <tr>
                    <td><input type="submit" value="Guardar"/></td>
                </tr>
            </table>
        </form:form>
</body>
</html>