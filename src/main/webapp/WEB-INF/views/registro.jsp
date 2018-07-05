<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <link href="resources/css/style-component.css" rel="stylesheet" type="text/css">

    <title>LOGIN | CONGERSO DIGITAL</title>
  </head>
  <body style="background-color: #213f59;">
    <div class="container">
	  <div class="row registro" >
	    <div class="col">
	      
	    </div>
	    <div class="col">
	    	<span class="align-middle">
	    		<div class="d-flex rec-olv">
				  	<div class="mr-auto p-2">
				  	<img src="resources/imagenes/PortalCongreso-15.png" onmouseover="cambiarImagen()" onmouseout="retornarImagen()" id="logoregistro" class="rounded" alt="Logo"/>
				  	</div>
				  	<div class="p-2">
				  		<div class="text-right registrate">
				  			<label>Regístrate</label>
				  		</div>
				  	</div>
				  </div>
	    		
				<form  action="addregistro" method="post" id="myForm" name="myForm" style="display: inline-block; width: 100%;">
				   <div class="d-flex rec-olv">
				  	<div class="mr-auto p-2">
				  		<div class="form-check">
				  			<input  onclick="deshabilitarCheckcolaborador()" type="checkbox" id="chckcolaborador" disabled="disabled" name="chckcolaborador" />  
							<small><label class="form-check-label" for="colaborador">Colaborador</label></small>
						</div>
				  	</div>
				  	<div class="p-2">
				  		<div class="form-check">
				  			<input  onclick="deshabilitarCheck()" type="checkbox" id="chckcliente" checked="checked" name="chckcliente" />
				  			<small><label class="form-check-label" for="cliente">Cliente</label></small>
						</div>
				  	</div>
				  	<input type="hidden" id="txtcategoria" name="txtcategoria" value="2"/>
						
				  </div>
				  <div class="form-group">
				    <input type="text" class="form-control" id="txtnombre" name="txtnombre" aria-describedby="emailHelp" placeholder="NOMBRE">
				  </div>
				  <div class="form-group">
				    <input type="password" class="form-control" id="txtcodigo" name="txtcodigo" placeholder="CONTRASEÑA">
				  </div>
				  <div class="form-group">
				    <input type="email" class="form-control" id="txtmail" name="txtmail" id="correo" placeholder="CORREO ELECTRONICO">
				  </div>
				  <div class="form-group">
				    <input type="text" class="form-control" name="txtcelular" id="txtcelular" aria-describedby="emailHelp" placeholder="TELÉFONO CELULAR">
				  </div>
				  <div class="form-group">
 							<select hidden="hidden" class="form-control"  id="centrooperativo" name="centrooperativo" >
									<c:forEach items="${lista}" var="list">
									<option value="${list.id}">${list.centroOpeativo}</option>
									</c:forEach>		  
									</select>
									<input type="text" class="form-control" placeholder="EMPRESA" id="txtEmpresa" name="txtEmpresa"/></div>
				  <div class="form-group">
				    <input type="date" class="form-control" id="centroop" id="txtnacimiento" name="txtnacimiento" aria-describedby="emailHelp" placeholder="FECHA NACIMIENTO">
				  </div>
				 
				  <button type="submit" class="btn btn-success botonverde">REGISTRARSE</button>
				</form>
	    	</span>
	      	
	    </div>
	    <div class="col">
	      
	    </div>
	  </div>
	</div>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
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
	document.getElementById("logoregistro").src="resources/imagenes/cabezaRegistro.png";
}

function retornarImagen() {
	document.getElementById("logoregistro").src="resources/imagenes/cruzregistro.png";
}
</script>
  </body>
</html>
