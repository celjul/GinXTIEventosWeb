<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="addAgenda">
Fecha inicio
<input id="fechainicio" required name="fechainicio" type="date" value="2018-08-28"/>
Hora inicio
<input id="horainicio" required name="horainicio" type="time">
Fecha fin
<input id="fechafin" required name="fechafin" type="date" value="2018-08-28"/>
Hora fin
<input id="horafin" required name="horafin" type="time">
Titulo
<input id="txttitulo" required name="txttitulo" type="text">
<br>
Ponente
	<select multiple id="ponentes" name="ponentes" >
									<c:forEach items="${lista}" var="list">
									<option value="${list.id}">${list.nombre}</option>
									</c:forEach>		  
									</select>
<input type="submit">
</form>
</body>
</html>