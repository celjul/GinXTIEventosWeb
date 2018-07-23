<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
<form action="updateNotificacion" method="POST">
<label>Titulo</label>
<input name="txtnombre" id="txtnombre" type="text" value="${notificacion.titulo}" />
<br>
<label>Detalle</label>
<textarea name="txtDetalle" cols="150" rows="10" id="txtDetalle" type="text" >${notificacion.descripcion}</textarea>
<input type="hidden" id="idnotificacion" name="idnotificacion" value="${notificacion.id}">
<input type="submit" value="Editar" >
</form>
<form action="deleteNotificacion"><input type="hidden" id="idnotificacion" name="idnotificacion" value="${notificacion.id }"><input type="submit" value="eliminar"> </form>

</body>
</html>