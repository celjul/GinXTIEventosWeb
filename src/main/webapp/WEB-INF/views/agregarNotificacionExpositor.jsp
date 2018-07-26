<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
<form action="addNotificacionExpositor" method="POST">
<label>Titulo</label>
<input name="txtnombre" id="txtnombre" type="text" />
<br>
<label>Detalle</label>
<textarea name="txtDetalle" cols="150" rows="10" id="txtDetalle" type="text" ></textarea>
<input type="submit" value="Agregar" >
</form>

</body>
</html>