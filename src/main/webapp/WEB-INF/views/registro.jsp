<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
	<link rel="stylesheet" type="text/css" href="/resources/css/estiloregistro.css">
	<title>Registro GinXTI</title>
</head>
<body>
<div style="text-align: center;height: 150px;">
	<div style="height: 40px; "></div>
	<div class="content"> 
		<img alt="registro" onmouseover="cambiarImagen()" onmouseout="retornarImagen()" 
		src="/resources/imagenes/cruzregistro.png" height="150px" id="imagenregistro"/>
	</div>
	<form action="addregistro" method="post" id="myForm" name="myForm">
		<div class="contenido">
			<span class="blanco">Cliente</span>
			<input  onclick="deshabilitarCheck()" type="checkbox" id="chckcliente" checked="checked" name="chckcliente" style="margin-right:40px;"/> 
			<span class="blanco" > Colaborador</span>
			<input  onclick="deshabilitarCheckcolaborador()" type="checkbox" id="chckcolaborador" disabled="disabled" name="chckcolaborador" />  
			<input type="hidden" id="txtcategoria" name="txtcategoria" value="2"/>
		</div>
		<div class="separacion"></div>
		<div class="contenido" >
			<input style="background-image:url(/resources/imagenes/usuario.png)" class ="inputredondeado" id="txtnombre" required="required" name="txtnombre" type="text"  placeholder="Nombre"></input>
		</div>
		<div class="separacion"></div>
		<div class="contenido">
			<input style="background-image:url(/resources/imagenes/contrasena.png)" class ="inputredondeado" id="txtcodigo" required="required" name="txtcodigo" type="password" placeholder="Contraseña"></input>	
		</div>
		<div class="separacion"></div>
		<div class="contenido">
			<input  style="background-image:url(/resources/imagenes/email.png)"  class ="inputredondeado" id="txtmail" required="required" name="txtmail" type="email"  placeholder="Correo Electronico"></input>
		</div>
		<div class="separacion"></div>
		<div class="contenido">
			<input style="background-image:url(/resources/imagenes/celular.png)"  class ="inputredondeado" id="txtcelular" required="required" name="txtcelular" type="number" placeholder="Telefono Celular"></input>
		</div>
		<div class="separacion"></div>
		<div class="contenido">
			<input style="background-image:url(/resources/imagenes/nacimiento.png)"  class ="inputredondeado" id="txtnacimiento" required="required" name="txtnacimiento" type="date" placeholder="Fecha de Nacimiento"></input>	
		</div>
		<div class="separacion"></div>
		<div class="contenido">
			<select hidden="hidden" style="background-image:url(/resources/imagenes/centrooperativo.png)"class ="inputredondeado" id="centrooperativo" name="centrooperativo" >
			<c:forEach items="${lista}" var="list">
				<option value="${list.id}">${list.centroOpeativo}</option>
			</c:forEach>		  
			</select>
			<input type="text" style="background-image:url(/resources/imagenes/centrooperativo.png)" placeholder="Empresa" class="inputredondeado" id="txtEmpresa" name="txtEmpresa"/>
		</div>
	<div class="separacion"></div>
		<div class="contenido">
		<input class = "registro" type="submit" value ="Registrar"/>
		</div>
</form>
</div>
<script type="text/javascript"> 

function deshabilitarCheckcolaborador(){
	if (document.getElementById("chckcolaborador").checked){
		document.getElementById("txtEmpresa").hidden = true; 
		document.getElementById("centrooperativo").hidden = false; 
		document.getElementById("chckcliente").disabled = true;
		document.getElementById("txtcategoria").value = 1;
	}else{document.getElementById("chckcliente").disabled = false;
	document.getElementById("txtcategoria").value = 0;
	}
	
}

function deshabilitarCheck(){
	if (document.getElementById("chckcliente").checked){
		document.getElementById("txtEmpresa").hidden = false; 
		document.getElementById("centrooperativo").hidden = true; 
		document.getElementById("chckcolaborador").disabled = true;
		document.getElementById("txtcategoria").value = 2;
	}else{document.getElementById("chckcolaborador").disabled = false;
	document.getElementById("txtcategoria").value = 0;}
	
}
function cambiarImagen() {
	document.getElementById("imagenregistro").src="/resources/imagenes/cabezaRegistro.png";
}

function retornarImagen() {cabezaRegistro
	document.getElementById("imagenregistro").src="/resources/imagenes/cruzregistro.png";
}
</script>
</body>
</html>