<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="updateExpositor">
<label>Nombre</label>
<input name="txtnombre" id="txtnombre" type="text" value="${expositor.nombre}"/>
<input hidden="hidden" name="idexpositor" id="idexpositor" value="${expositor.id}"/>
<label>facebook</label>
<input name="txtfacebook" id="txtfacebook" type="text" value="${expositor.facebook}"/>
<label>google</label>
<input name="txtgoogle" id="txtgoogle" type="text" value="${expositor.google}"/>
<label>twitter</label>
<input name="txttwitter" id="txttwitter" type="text" value="${expositor.twitter}"/>
<br>
<label>Pagina Internet</label>
<input name="txtpaginainternet" id="txtpaginainternet" type="text" value="${expositor.paginainternet}"/>
<br>
<input type="submit" value="Editar" >
</form>
<form action="deleteExpositor"><input hidden="hidden" name="idexpositord" id="idexpositord" value="${expositor.id}"/><input type="submit" value="Eliminar" ></form>
</body>
</html>