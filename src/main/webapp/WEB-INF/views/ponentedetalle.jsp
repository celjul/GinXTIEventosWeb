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
			    <a class="nav-link disabled" href="#">
			    	<h2>Ponentes <ion-icon name="people"></ion-icon></h2>
			    </a>
			  </li>
			</ul>
		</header>
    <div class="row">
      <div class="col-4 col-md-3 col-sm-6">
        <img class="rounded-circle" src="data:image/png;base64,${ponente.foto}" alt="">        
      </div>
      <div class="col-8 col-md-9 col-sm-6">
        <table class="tabla-ponente">
          <tbody>
            <tr>
              <th class="contenido-ponente">
                <h3 class="nombre-uno">${ponente.nombre}</h3>
                <h3 class="nombre-dos">${ponente.puesto}</h3>
                <p>${ponente.semblanza}</p>
               </th>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</body>
</html>