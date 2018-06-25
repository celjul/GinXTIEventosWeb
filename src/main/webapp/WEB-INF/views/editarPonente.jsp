<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="updatePonente">
<label>Nombre</label>
<input name="txtnombre" id="txtnombre" type="text" value="${ponente.nombre}"/>
<input hidden="hidden" name="idponente" id="idponente" value="${ponente.id}"/>
<label>Puesto</label>
<input name="txtpuesto" id="txtpuesto" type="text" value="${ponente.puesto}"/>
<label>Semblanza</label>
<input name="txtsemblanza" id="txtsemblanza" type="text" value="${ponente.semblanza}"/>
<input type="submit" value="Editar" >
</form>
<form action="deletePonente"><input hidden="hidden" name="idponented" id="idponented" value="${ponente.id}"/><input type="submit" value="Eliminar" ></form>
</body>
</html>