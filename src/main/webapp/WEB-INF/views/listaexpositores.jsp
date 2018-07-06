<!DOCTYPE html>
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

    <title>EXPOSITORES | CONGRESO DIGITAL</title>
    <style>
      .img-expositores{
        border-radius: 1%;

        width: 100px;
      }
    </style>
  </head>
<body class="fondo-patro">
	<div class="container">
		<header>
		<div class="justify-content-start">
        <a href="atras">
          <img class="img-regreso" src="resources/imagenes/back.png" alt="...">
        </a>
      </div>
			<ul class="nav justify-content-end">
			  <li class="nav-item">
			    <a class="nav-link disabled" href="#">
			    	<h2>Expositores <ion-icon name="contacts"></ion-icon></h2>
			    </a>
			  </li>
			</ul>
		</header>
    <div class="row lineauno"></div>
    <div class="row">
    <c:forEach items="${lista}" var="list">
      <div class="col align-self-center">
        <a href="${list.paginainternet}">
          <div class="col">
          <img class="img-expositores" src="data:image/png;base64,${list.logo}" alt="...">
          </div>
        </a>
      </div>
      </c:forEach>
    </div>
  </div>
</body>
</html>