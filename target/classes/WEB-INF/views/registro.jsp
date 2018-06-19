<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<title>Registro GinXTI</title>
</head>
<body bgcolor="#253E5A">
<div style="text-align: center;height: 150px;">


<div style="height: 40px; "></div>

<div class="content"> 
<img alt="registro" onmouseover="cambiarImagen()" onmouseout="retornarImagen()" 
	src="/resources/imagenes/cruzregistro.png" height="150px" id="imagenregistro"/>
</div>
<form action="addregistro" method="post" id="myForm" name="myForm">

<div style="text-align: center;height: 40px;">
	<div class="content" >
		<img alt="usuario"  src="/resources/imagenes/usuario.png" height="20px" ></img>
		<input id="txtnombre" required="required" name="txtnombre" type="text" style="height: 40px" placeholder="Nombre"></input>
	</div>
	
	<div style="text-align: center;height: 10px;"></div>

	<div style="text-align: center;height: 40px;">
		<div class="content">
			<img alt="cabeza" src="/resources/imagenes/contrasena.png" height="20px" ></img>
			<input id="txtcodigo" required="required" name="txtcodigo" type="text" style="height: 40px" placeholder="Codigo"></input>
		</div>
	</div>

	<div style="text-align: center;height: 10px;"></div>

	<div style="text-align: center;height: 40px;">
		<div class="content">
			<img alt="cabeza" src="/resources/imagenes/email.png" height="20px" ></img>
			<input id="txtmail" required="required" name="txtmail" type="text" style="height: 40px" placeholder="Correo Electronico"></input>
		</div>
	</div>
	
	<div style="text-align: center;height: 10px;"></div>

	<div style="text-align: center;height: 40px;">
		<div class="content">
			<img alt="cabeza" src="/resources/imagenes/celular.png" height="20px" ></img>
			<input id="txtcelular" required="required" name="txtcelular" type="text" style="height: 40px" placeholder="Telefono Celular"></input>
		</div>
	</div>
	
	<div style="text-align: center;height: 10px;"></div>

	<div style="text-align: center;height: 40px;">
		<div class="content">
			<img alt="cabeza" src="/resources/imagenes/centrooperativo.png" height="20px" ></img>
			<select id="centrooperativo" name="centrooperativo" style="height: 40px; width:175px">
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
		</div>
	</div>
	
	
	<div style="text-align: center;height: 10px;"></div>

	<div style="text-align: center;height: 40px;">
		<div class="content">
			<img alt="cabeza" src="/resources/imagenes/nacimiento.png" height="20px" ></img>
			<input id="txtnacimiento" required="required" name="txtnacimiento" type="date" style="width:170px; height: 40px;" placeholder="Fecha de Nacimiento"></input>
		</div>
	</div>
		<div style="text-align: center;height: 20px;">
	</div>
	<div style="text-align: center;height: 20px;">
	<input onclick="deshabilitarCheckcolaborador()" type="checkbox" id="chckcolaborador" name="chckcolaborador" /><span style="color: #ffffff; margin-right:40px; " > Colaborador</span>  
	<input onclick="deshabilitarCheck()" type="checkbox" id="chckcliente" name="chckcliente"/><span style="color: #ffffff; ">Cliente</span>
	<input type="hidden" id="txtcategoria" name="txtcategoria" value="0"/>
	</div>
	<div style="text-align: center;height: 10px;"></div>
	
	<div style="text-align: center;">
		<div class="content">
			<img alt="cabeza" id="btnRegistrar" src="/resources/imagenes/btnregistrar.png" width="200px" height="60px" ></img>
		</div>
	</div>
	<div style="text-align: center;height: 150px;"> 
	
  </div>	
	

</div>
</form>
</div>
<script type="text/javascript"> 

document.getElementById("btnRegistrar").onclick = function() {
	if(document.getElementById("txtcategoria").value !=0){
		document.getElementById("myForm").submit();}else{
		alert("LLene los campos porfavor");
	}
};

function deshabilitarCheckcolaborador(){
	if (document.getElementById("chckcolaborador").checked){
		document.getElementById("chckcliente").disabled = true;
		document.getElementById("txtcategoria").value = 1;
	}else{document.getElementById("chckcliente").disabled = false;
	document.getElementById("txtcategoria").value = 0;}
	
}

function deshabilitarCheck(){
	if (document.getElementById("chckcliente").checked){
		document.getElementById("chckcolaborador").disabled = true;
		document.getElementById("txtcategoria").value = 2;
	}else{document.getElementById("chckcolaborador").disabled = false;
	document.getElementById("txtcategoria").value = 0;}
	
}
function cambiarImagen() {
	document.getElementById("imagenregistro").src="/resources/imagenes/cabezaRegistro.png";
}

function retornarImagen() {
	document.getElementById("imagenregistro").src="/resources/imagenes/cruzregistro.png";
}
</script>
</body>
</html>