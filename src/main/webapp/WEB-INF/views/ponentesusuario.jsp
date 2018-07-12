<!doctype html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
  <head>
    <!-- Required meta tags -->
    <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
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

    <title>PONENTES | CONGRESO DIGITAL</title>
  </head>
<body class="fondo-ponentes">
	<div class="container">
		<header>
		<div class="justify-content-start">
        <a href="atras">
          <img class="img-regreso" src="resources/imagenes/back.png" alt="...">
        </a>
      </div>
			<ul class="nav justify-content-end">
			  <li class="nav-item">
			    
			    	<h2>Ponentes <ion-icon name="people"></ion-icon></h2>
			   
			  </li>
			</ul>
		</header>
    <div class="row lineauno"></div>
    <div class="row">

     
      
<c:forEach items="${lista}" var="list">
<div class="col-12 col-md-4 align-self-center">
        <a  href="#" onclick="MyFunction(${list.id})">
          <div class="col">
           <img class="img-ponente" src="data:image/png;base64,${list.foto}" alt="...">
            <h3 class="nombre-uno">${list.nombre}</h3>
            <h3 class="nombre-dos">${list.puesto}</h3>
          </div>
        </a>
      </div>
</c:forEach>
      <form action="revisarPonente" id="revisarPonente" name="revisarPonente" >
<input type="hidden" name="idPonente" id="idPonente">
</form>
    </div>
  </div>
  <script type="text/javascript">

  function MyFunction(a){
	  var myform = document.getElementById('revisarPonente');
	  var id= a;
    document.getElementById('idPonente').value = id;
    myform.submit();
	};
  
  </script>
</body>
</html>