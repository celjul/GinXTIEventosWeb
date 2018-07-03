<!doctype html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
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

    <title>PONENTES | CONGERSO DIGITAL</title>
  </head>
<body class="fondo-ponentes">
<form id="agregarPonente" name="agregarPonente" action="agregarPonente"><input type="submit" value="+Agregar"/></form>
	<div class="container">
		<header>
			<ul class="nav justify-content-end">
			  <li class="nav-item">
			    <a class="nav-link disabled" href="#">
			    	<h2>Ponentes <ion-icon name="people"></ion-icon></h2>
			    </a>
			  </li>
			</ul>
		</header>
    <div class="row lineauno"></div>
    <div class="row">

     
      
<c:forEach items="${lista}" var="list">
<div class="col-12 col-md-4 align-self-center">
        
          <div class="col">
          <a href="ponentetres.html">
            <img class="img-ponente" src="data:image/png;base64,${list.foto}" alt="...">
            <h3 class="nombre-uno">${list.nombre}</h3>
            <h3 class="nombre-dos">${list.puesto}</h3></a>
            <button>Editar/Eliminar</button>
            <input type="hidden" id="${list.id}" name="${list.id}"/>
          </div>
        
      </div>
</c:forEach>
      
    </div>
  </div>

<form action="editarPonente" id="editarPonente" name="editarPonente" >
<input type="hidden" name="idPonente" id="idPonente">
</form>
<script>
$('button').on('click', function(){
	  var myform = document.getElementById('editarPonente');
	  var id= $(this).next('input').attr('id');
    document.getElementById('idPonente').value = id;
    myform.submit();
              
});</script>
</body>
</html>