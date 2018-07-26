<!doctype html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

    <title>NOTIFICACIONES | CONGRESO DIGITAL</title>
  </head>
<body class="fondo-notificacion">
	<div class="container">
		<header>
		<ul class="nav justify-content-start">
			
			<li><a href="atrasExpo">
          	<img class="img-regreso" src="resources/imagenes/back.png" alt="...">
        	</a></li>
        </ul>
        <ul class="nav justify-content-end">
        <li>
        	<form action="agregarNotificacionExpositor"  >
			<input type="submit" class="btn btn-primary" value="Agregar">
			</form></li>
        </ul>

			<ul class="nav justify-content-end">
			  <li class="nav-item">
			    
			    	<h2>Notificaciones <ion-icon name="alert"></ion-icon></h2>
			   
			  </li>
			</ul>
		</header>
  
     
      <div class="col-10 col-sm-auto">
        <table class="table align-self-start tabla-notifi">
          <thead>
            <tr>
              <th scope="col">Titulo</th>
            </tr>
          </thead>
          <tbody><c:forEach items="${lista}" var="notificacion">
            <tr>
            
              <th scope="row">${notificacion.titulo}</th>
              
               <div class="modal fade" id="exampleModalCenter${notificacion.id}" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="exampleModalLongTitle">
                ${notificacion.titulo}
              </h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div class="modal-body">
              ${notificacion.descripcion}
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-dismiss="modal">Salir</button>
            </div>
          </div>
        </div>
      </div>
              <td>
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter${notificacion.id}">
                  Ver
                </button></td><td><form action="editarnotificacionExpositor"><input type="hidden" id="idnotificacion" name="idnotificacion" value="${notificacion.id}"><input type="submit" class="btn btn-primary" value="editar"></form>
              </td>
             
            </tr> </c:forEach>
          </tbody>
        </table>
      </div>
   

      <!-- Modal -->
     
  </div>
  <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>