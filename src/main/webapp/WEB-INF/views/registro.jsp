<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
	<meta charset="UTF-8">
	<title>REGISTRO - CONGERSO DIGITAL</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
	<link href="/resources/css/style.css" rel="stylesheet" type="text/css" media="all">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css" integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt" crossorigin="anonymous">
</head>
<body class="cuerpo">
<div class="container">
		<section class="principal">
			<div class="columna"></div>
			<div class="columna">
				<div id="formulario">
					<div style="display: inline-block; float: left;">
						<a href="#">
					  		<img id="logoregistro" onmouseover="cambiarImagen()" onmouseout="retornarImagen()" src="/resources/imagenes/PortalCongreso-15.png" style="width: 70%;">
					  	</a>
					  	<div id="linearegistro"></div>
					</div>
					<div>
						<form action="addregistro" method="post" id="myForm" name="myForm" style="display: inline-block; width: 100%;">
							
							<div>
								<span class="blanco">Cliente</span>
								<input  onclick="deshabilitarCheck()" type="checkbox" id="chckcliente" checked="checked" name="chckcliente" /> 
								<span class="blanco" > Colaborador</span>
								<input  onclick="deshabilitarCheckcolaborador()" type="checkbox" id="chckcolaborador" disabled="disabled" name="chckcolaborador" />  
								<input type="hidden" id="txtcategoria" name="txtcategoria" value="2"/>
							</div>
							<div>
						        <i class="far fa-user iconoreg"></i>
						        <input id="txtnombre" name="txtnombre" type="text" class="booton" placeholder="NOMBRE:" required/>
							</div>
							<div>
						        <i class="fas fa-lock iconoreg"></i>
						        <input  id="txtcodigo" name="txtcodigo" type="password" class="booton" placeholder="CONTRASEÑA:" required/>
							</div>
							<div>
						        <i class="far fa-envelope iconoreg"></i>
						        <input id="txtmail" name="txtmail" type="email" class="booton" placeholder="CORREO ELECTRÓNICO:" required/>
							</div>
							<div>
						        <i class="fas fa-mobile-alt iconoreg"></i>
						        <input id="txtcelular" name="txtcelular" type="text" class="booton" placeholder="TELÉFONO CELULAR:" required/>
							</div>
							<div>
							<i class="far fa-address-book iconoreg"></i>
								<select hidden="hidden" class="booton"  id="centrooperativo" name="centrooperativo" >
									<c:forEach items="${lista}" var="list">
									<option value="${list.id}">${list.centroOpeativo}</option>
									</c:forEach>		  
									</select>
									<input type="text" placeholder="EMPRESA" class="booton" id="txtEmpresa" name="txtEmpresa"/>

							</div>
							<div>
						        <i class="far fa-calendar-alt iconoreg"></i>
						        <input id="txtnacimiento" name="txtnacimiento" type="date" class="booton" placeholder="FECHA NACIMIENTO:" required/>
							</div>
							<div>
						    	<input type="submit" class="button" id="btn_ingresar" value="REGISTRARSE">
						    </div>
						</form>
					</div>
				</div>
			</div>
		</section>
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
	document.getElementById("logoregistro").src="/resources/imagenes/cabezaRegistro.png";
}

function retornarImagen() {
	document.getElementById("logoregistro").src="/resources/imagenes/cruzregistro.png";
}
</script>
</body>
</html>

