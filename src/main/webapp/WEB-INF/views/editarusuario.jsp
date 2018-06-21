<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="updateUsuario">
<label>Nombre</label>
<input name="txtnombre" id="txtnombre" type="text" value="${usuario.nombre}"/>
<input hidden="hidden" name="idusuario" id="idusuario" value="${usuario.id}"/>
<label>E-mail</label>
<input name="txtemail" id="txtemail" type="email" value="${usuario.email}"/>
<label>Telefono</label>
<input name="txttelefono" id="txttelefono" type="number" value="${usuario.telefono}"/>
<label>Fecha nacimiento</label>
<input name="txtfecha" id="txtfecha" type="date" value="${usuario.fechaNacimiento}"/>
<br>
<label>Centro Operativo</label>
<select id="centrooperativo" name="centrooperativo" >
<option value="${usuario.centro.id}">${usuario.centro.centroOpeativo}</option>
	<c:forEach items="${lista}" var="list">
				<option value="${list.id}">${list.centroOpeativo}</option>
	</c:forEach>		  
</select>
<label>Categoria</label>
<select id="categoria" name="categoria" >
<option value="${usuario.categoria.id}">${usuario.categoria.detalle}</option>
	<option value="1">Colaborador</option>
	<option value="2">Cliente</option>	  
	<option value="3">Administrador</option>	  	  
</select>
<label>Status</label>
<select id="status" name="status" >
<option value="${usuario.estatus.id}">${usuario.estatus.detalle}</option>
	<option value="1">Registrado</option>
	<option value="2">Sin Registrar</option>	  
	<option value="3">Cancelado</option>	  	  
</select>

<label>Empresa</label>
<input name="txtempresa" id="txtempresa" type="text" value="${usuario.empresa}"/>
<br>
<input type="submit" value="Editar" >
</form>
</body>
</html>