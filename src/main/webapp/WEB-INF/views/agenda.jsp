	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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

    <title>AGENDA | CONGRESO DIGITAL</title>
  </head>
<body class="fondo-agenda">
	<div class="container">
		<header>
      <div class="justify-content-start">
        <a href="atras">
          <img class="img-regreso" src="resources/imagenes/back.png" alt="...">
        </a>
      </div>
			<ul class="nav justify-content-end">
			  <li class="nav-item">
			 
			    	<h2>Agenda <ion-icon name="calendar"></ion-icon></h2>
		
			  </li>
			</ul>
		</header>
    <div class="row">
      <div class="col-3">
        
      </div>
      <div class="col-12 col-sm-auto table-responsive">
        <table class="table table-bordered">
          <thead>
            <tr class="fondo-verde">
              <th colspan="2"><h2>Hora</h2></th>
              <th><h2>Conferencista</h2></th>
              <th colspan="2"><h2>Titulo</h2></th>
            </tr>
          </thead>
          <tbody>
            
            <tr>
              <th style="border: 0px" scope="col" ></th>
              <th style="border: 0px" scope="col" ></th>
              <td style="border: 0px" scope="col" ></td>

              <th class="fondo-azul" scope="col">
                <h2 style="font-size: 3em;">AGOSTO</h2>
                <h2 style="font-size: 3em; color: rgb(196, 214, 0); float: right;">28</h2>
              </th>
            </tr>
            <tr>
              <th scope="col">8:00</th>
              <th scope="col">9:00</th>
      			<td colspan="2"><h2>Registro</h2></h2></td>
        	
            </tr>
            <c:forEach items="${lista1}" var="list1">
            <tr>
              <th scope="col" style="vertical-align:middle">${list1.horainicioString}</th>
              <th scope="col" style="vertical-align:middle">${list1.horafinString}</th>
              <c:choose>
  <c:when test="${fn:length(list1.ponentes) gt 1}">
    <td scope="col"><c:forEach items="${list1.ponentes}" var="ponent"><h2>${ponent.nombre}</h2></c:forEach></td>
  <td scope="col" style="vertical-align:middle; font-size: 1.5em; ">${list1.titulo}</td>
  </c:when>
  <c:otherwise>
   <td colspan="2" style="vertical-align:middle"><h2>${list1.titulo}</h2></td>
 
  </c:otherwise>
  </c:choose>
      			
        	
             
            </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
    </div>
    <div class="row">
      <div class="col-3">
        
      </div>
      <div class="col-12 col-sm-auto table-responsive">
        <table class="table table-bordered">
          <thead>
            <tr class="fondo-verde">
              <th colspan="2"><h2>Hora</h2></th>
              <th><h2>Conferencista</h2></th>
              <th colspan="2"><h2>Titulo</h2></th>
            </tr>
          </thead>
          <tbody>
            
            <tr>
              <th style="border: 0px" scope="col" ></th>
              <th style="border: 0px" scope="col" ></th>
              <td style="border: 0px" scope="col" ></td>

              <th class="fondo-azul" scope="col">
                <h2 style="font-size: 3em;">AGOSTO</h2>
                <h2 style="font-size: 3em; color: rgb(196, 214, 0); float: right;">29</h2>
              </th>
            </tr>
             <tr>
              <th scope="col">8:00</th>
              <th scope="col">9:00</th>
      			<td colspan="2"><h2>Registro</h2></td>
        	
            </tr>
            <c:forEach items="${lista2}" var="list2">
            <tr>
              <th scope="col" style="vertical-align:middle">${list2.horainicioString}</th>
              <th scope="col" style="vertical-align:middle">${list2.horafinString}</th>
             
                          <c:choose>
  <c:when test="${fn:length(list2.ponentes) gt 1}">
    <td scope="col"><c:forEach items="${list2.ponentes}" var="ponente"><h2>${ponente.nombre}</h2></c:forEach></td>
  <td scope="col" style="vertical-align:middle; font-size: 1.5em;">${list2.titulo}</td>
  </c:when>
  <c:otherwise>
   <td colspan="2" style="vertical-align:middle"><h2>${list2.titulo}</h2></td>
 
  </c:otherwise>
  </c:choose>
      	   </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
    </div>
  </div>
  <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>