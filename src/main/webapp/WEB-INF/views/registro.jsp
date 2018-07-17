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

    <title>LOGIN | CONGRESO DIGITAL</title>
    
    <style>
    .container2 {
    display: block;
    position: relative;
    padding-left: 35px;
    margin-bottom: 12px;
    cursor: pointer;
    font-size: 22px;
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
    user-select: none;
}

.container2 input {
    position: absolute;
    opacity: 0;
    cursor: pointer;
}

/* Create a custom radio button */
.checkmark {
    position: absolute;
    top: 0;
    left: 0;
    height: 25px;
    width: 25px;
    background-color: #eee;
    border-radius: 0%;
}

/* When the radio button is checked, add a blue background */
.container2 input:checked ~ .checkmark {
    background-color: #2196F3;
}

/* Create the indicator (the dot/circle - hidden when not checked) */
.checkmark:after {
    content: "";
    position: absolute;
    display: none;
}

/* Show the indicator (dot/circle) when checked */
.container2 input:checked ~ .checkmark:after {
    display: block;
}

/* Style the indicator (dot/circle) */
.container2 .checkmark:after {
  left: 9px;
  top: 5px;
  width: 5px;
  height: 10px;
  border: solid white;
  border-width: 0 3px 3px 0;
  -webkit-transform: rotate(45deg);
  -ms-transform: rotate(45deg);
  transform: rotate(45deg);
}
    </style>
  </head>
  <body style="background-color: #213f59;">
    <div class="container">
	  <div class="row registro" >
	    <div class="col">
	       <a href="home">
          <img class="img-regreso" src="resources/imagenes/back.png" alt="...">
        </a>
	    </div>
	    <div class="col">
	    	<span class="align-middle">
	    		<div class="d-flex rec-olv">
				  	<div class="mr-auto p-2">
				  	<img src="resources/imagenes/PortalCongreso-15.png" onmouseover="cambiarImagen()" onmouseout="retornarImagen()" id="logoregistro" class="img-fluid" alt="Logo"/>
				  	</div>
				  	<div class="p-2">
				  			
				  	</div>
				  </div>
	    		
				<form  action="addregistro" method="post" id="myForm" name="myForm" style="display: inline-block; width: 100%;">
				   <div class="d-flex rec-olv">
				  	<label style=" font-size: 15px;color:white;"class="container2" onchange="handleChange2();">Cliente
					  <input type="radio" checked="checked" value="2" name="txtcategoria">
					  <span class="checkmark"></span>
					</label>
					<div class="col"></div>
					<label style=" font-size: 15px;color:white;" class="container2">Colaborador
						  <input type="radio" name="txtcategoria" value="1" onchange="handleChange1();">
						  <span class="checkmark"></span>
					</label>
				  </div>
				  <div class="form-group">
				    <input required type="text" class="form-control" id="txtnombre" name="txtnombre" aria-describedby="emailHelp" placeholder="NOMBRE">
				  </div>
				  <div class="form-group">
				    <input required type="password" class="form-control" id="txtcodigo" name="txtcodigo" placeholder="CONTRASEÑA">
				  </div>
				  <div class="form-group">
				    <input required type="email" class="form-control" id="txtmail" name="txtmail" id="correo" placeholder="CORREO ELECTRONICO">
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
				    <input type="date" required class="form-control" id="centroop" id="txtnacimiento" name="txtnacimiento" aria-describedby="emailHelp" placeholder="FECHA NACIMIENTO">
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
 
 function handleChange1() {
		document.getElementById("txtEmpresa").hidden = true; 
			document.getElementById("centrooperativo").hidden = false; 

	    
	}
 
 function handleChange2() {
		document.getElementById("txtEmpresa").hidden = false; 
			document.getElementById("centrooperativo").hidden = true; 
	    
	}
 
	function deshabilitarCheckcolaborador(){
 		if (document.getElementById("chckcolaborador").checked){
 			document.getElementById("txtEmpresa").hidden = true; 
 			document.getElementById("centrooperativo").hidden = false; 
 			document.getElementById("txtcategoria").value = 1;
 		}
 		
 	}

 	function deshabilitarCheck(){
 		if (document.getElementById("chckcliente").checked){
 			document.getElementById("txtEmpresa").hidden = false; 
 			document.getElementById("centrooperativo").hidden = true; 
 			document.getElementById("txtcategoria").value = 2;
 		}
 		
 	}

function cambiarImagen() {
	document.getElementById("logoregistro").src="resources/imagenes/PortalCongreso-15.png";
}

function retornarImagen() {
	document.getElementById("logoregistro").src="resources/imagenes/PortalCongreso-15.png";
}
</script>
  </body>
</html>
