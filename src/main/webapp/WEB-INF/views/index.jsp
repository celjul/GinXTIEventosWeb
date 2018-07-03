<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <!-- Iconos -->
    <script src="https://unpkg.com/ionicons@4.2.4/dist/ionicons.js"></script>
    <!-- Google Fonts-->
    <link href="https://fonts.googleapis.com/css?family=Roboto:300" rel="stylesheet">
     <!-- Estilos Personalizados de Bootstrap -->
    <link href="resources/css/style-component.css" rel="stylesheet" type="text/css">

    <title>CONGERSO DIGITAL</title>
  </head>
<body>
	<div class="container">
		<div class="row">
			<video autoplay muted loop id="myVideo">
			  <source src="resources/videos/videoindex.mp4" type="video/mp4">
			</video>
		</div>
		
		<div class="inicio">
			<div class="row col">
				<div class="col-2 col-md-2 col-sm-6"></div>
				<div class="col-2 col-md-2 col-sm-6"></div>
				<div class="col-auto col-md-2 col-sm-6">
					<a href="login.html" onMouseOver="cambiar();" onMouseOut="volver();">
				  		<img class="btn-img-index" id="btn_imagen1" src="resources/imagenes/PortalCongreso-10.png">
				  	</a>
				</div>
				<div class="col-auto col-md-2 col-sm-6">
					<a href="registro.html" onMouseOver="cambiardos();" onMouseOut="volverdos()";>
				  		<img class="btn-img-index" id="btn_imagen2" src="resources/imagenes/PortalCongreso-11.png">
				  	</a>
				</div>
				<div class="col-2 col-md-2 col-sm-6"></div>
				<div class="col-2 col-md-2 col-sm-6"></div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
	 
	 function cambiar () {
	  document.getElementById('btn_imagen1').src = "resources/imagenes/PortalCongreso-12.png";
	 }
	 
	 function volver () {
	  document.getElementById('btn_imagen1').src = "resources/imagenes/PortalCongreso-10.png";
	 }

	 
	 function cambiardos () {
	  document.getElementById('btn_imagen2').src = "resources/imagenes/PortalCongreso-13.png";
	 }
	 
	 function volverdos () {
	  document.getElementById('btn_imagen2').src = "resources/imagenes/PortalCongreso-11.png";
	 }
	</script>
</body>
</html>