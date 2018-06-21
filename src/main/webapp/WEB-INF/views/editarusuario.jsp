<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="updateUsuario">
<label>Nombre</label>
<input type="text" value="${usuario.nombre}"/>
<label>E-mail</label>
<input type="text" value="${usuario.email}"/>
<label>Telefono</label>
<input type="text" value="${usuario.telefono}"/>
<label>Fecha nacimiento</label>
<input type="date" value="${usuario.fechaNacimiento}"/>
<br>
<label>Centro</label>
<input type="text" value="${usuario.centro.centroOpeativo}"/>
<label>Categoria</label>
<input type="text" value="${usuario.categoria.detalle}"/>
<label>Status</label>
<input type="text" value="${usuario.estatus.detalle}"/>
<label>Empresa</label>
<input type="text" value="${usuario.empresa}"/>
<br>
<input type="submit" value="Editar" >
</form>
</body>
</html>