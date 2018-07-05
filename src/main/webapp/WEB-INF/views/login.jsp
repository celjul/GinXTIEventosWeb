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
	  <div class="row login" >
	    <div class="col">
	      
	    </div>
	    <div class="col">
	    	<span class="align-middle">
	    		<div class="text-center">
					<img src="resources/imagenes/PortalCongreso-16.png" class="rounded" alt="Logo"  id="logo" name="logo" onMouseOver="cambiar();" onMouseOut="volver();">
				</div>
				<form action="logeo" method="post">
				  <div class="form-group">
				    <input type="text" name="txtemail" id="txtemail" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="CORREO ELECTRONICO">
				  </div>
				  <div class="form-group">
				    <input type="password" name="txtcodigo" id="txtcodigo" class="form-control" id="exampleInputPassword1" placeholder="CONTRASE�A">
				  </div>
				  <button type="submit" class="btn btn-success botonverde">INGESAR</button>

				  <div class="d-flex rec-olv">
				  	<div class="mr-auto p-2">
				  		<div class="form-check">
						    <input type="checkbox" class="form-check-input" id="exampleCheck1">
						    <small><label class="form-check-label" for="exampleCheck1">Recordarme</label></small>
						</div>
				  	</div>
				  	<div class="p-2">
				  		<div>
					  		<small><a href="#" class="linkuno">�Olvidaste tu Contrase�a?</a></small>
					  	</div>
				  	</div>
				  </div>
				  <div class="linea"></div>
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
	 
	 function cambiar () {
	  document.getElementById('logo').src = "resources/imagenes/PortalCongreso-15.png";
	 }
	 
	 function volver () {
	  document.getElementById('logo').src = "resources/imagenes/PortalCongreso-16.png";
	 }
	</script>
  </body>
</html>
