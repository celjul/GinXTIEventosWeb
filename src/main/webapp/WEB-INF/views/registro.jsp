<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
				  <option value="1">Seleccione centro</option>
				  <option value="2">Alcanfores</option>
				  <option value="3">Amores</option>
				  <option value="4">Azcapotzalco</option>
				  <option value="5">Cancún</option>
				  <option value="6">Centro</option>
				  <option value="7">Colorines</option>
				  <option value="8">Interlomas</option>
				  <option value="9">Maycky</option>
				  <option value="10">Montes Urales</option>
				  <option value="11">Polanco</option>
				  <option value="12">Presidencia</option>
				  <option value="13">Presidencia I</option>
				  <option value="14">Presidencia II</option>
				  <option value="15">Presidencia III</option>
				  <option value="16">Presidencia IV</option>
				  <option value="17">Presidencia V</option>
				  <option value="18">Presidencia VI</option>
				  <option value="19">Presidencia VII</option>
				  <option value="20">Presidencia A</option>
				  <option value="21">Presidencia B</option>
				  <option value="22">Santa Fe</option>
				  <option value="23">Santa Fe Cancún</option>
			  	  <option value="24">Satélite</option>
				  <option value="25">WTC</option>
				  <option value="26">Auditoría y Asuntos Especiales</option>
				  <option value="27">Contabilidad</option>
				  <option value="28">Contraloría</option>
				  <option value="29">Integra</option>
				  <option value="30">Comunicación Corporativa</option>
				  <option value="31">Jurídico</option>
				  <option value="32">Sistemas</option>
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