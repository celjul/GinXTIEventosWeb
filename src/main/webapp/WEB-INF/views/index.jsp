<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>CONGERSO DIGITAL</title>

	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
	<link href="/resources/css/style.css" rel="stylesheet" type="text/css" media="all">


</head>
<body>
	<div class="container">
		<section>
			<video autoplay="autoplay" loop="loop" id="video_background" preload="auto" >
			  <source src="/resources/videos/videoindex.mp4" type="video/mp4" />
			</video>
		</section>
		
    	<footer>
    		<div id="footer_inicio">
			  	<div></div>
			  	<div>
			  		<!-- agregar la ruta para el inicio de sesión -->
			  		<a href="login.html" onMouseOver="cambiar();" onMouseOut="volver();">
				  		<img id="btn_imagen1" src="/resources/imagenes/PortalCongreso-10.png">
				  	</a>
				  	<!-- agregar la ruta para el registro -->
				  	<a href="registro.html" onMouseOver="cambiardos();" onMouseOut="volverdos();">
				  		<img id="btn_imagen2" src="/resources/imagenes/PortalCongreso-11.png">
				  	</a>
			  	</div>
			  	<div></div>
			</div>
	    </footer>

	    		
	</div>
	<script type="text/javascript">
	 
	 function cambiar () {
	  document.getElementById('btn_imagen1').src = "/resources/imagenes/PortalCongreso-12.png";
	 }
	 
	 function volver () {
	  document.getElementById('btn_imagen1').src = "/resources/imagenes/PortalCongreso-10.png";
	 }

	 
	 function cambiardos () {
	  document.getElementById('btn_imagen2').src = "/resources/imagenes/PortalCongreso-13.png";
	 }
	 
	 function volverdos () {
	  document.getElementById('btn_imagen2').src = "/resources/imagenes/PortalCongreso-11.png";
	 }
	</script>
	
</body>
</html>