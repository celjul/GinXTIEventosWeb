<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>LOGIN - CONGERSO DIGITAL</title>

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
					<div>
						<div id="linealogouno"></div>
						<a href="#" onMouseOver="cambiar();" onMouseOut="volver();">
					  		<img id="logo" src="/resources/imagenes/PortalCongreso-16.png">
					  	</a>
					  	<div id="linealogodos"></div>
					</div>
					<div>
						<form action="logeo" method="post">
							<div>
						        <i class="far fa-user icono"></i>
						        <input name="txtemail" id="txtemail" type="text" class="booton" placeholder="NOMBRE:" required/>
						    </div>
						    <div>
						    	<i class="fas fa-lock icono"></i>
						        <input name="txtcodigo" id="txtcodigo" type="password" class="booton" placeholder="CONTRASEÑA" required/>
						    </div>
						    <div>
						    	<input type="submit" class="button" id="btn_ingresar" value="INGESAR">
						    </div>
							<div class="squaredFour">
								
							</div>
							<div id="olvidaste">
								<a href="#" id="contra">¿Olvidaste tu contraseña?</a>
							</div>
							<div id="linea"></div>

						</form>						
					</div>
				</div>
			</div>
			<div class="columna"></div>
		</section>		
	</div>
	<script type="text/javascript">
	 
	 function cambiar () {
	  document.getElementById('logo').src = "/resources/imagenes/PortalCongreso-15.png";
	 }
	 
	 function volver () {
	  document.getElementById('logo').src = "/resources/imagenes/PortalCongreso-16.png";
	 }
	</script>
</body>
</html>
