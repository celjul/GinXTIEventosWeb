<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
</head>
<body>
<div><form id="anadirExpositor" name="anadirExpositor" action="agregarExpositor"><input type="submit" value="+Agregar"/></form></div>

<c:forEach items="${lista}" var="list">
<div class="row" style="background-color:#ccc;height:40px"></div>
<div class="row">
	<div class="column" style="background-color:#aaa" >
  		<div class="w3-container">
		    <header class="w3-container">
		      <h3><button>Editar/Eliminar</button> <input type="hidden" id="${list.id}" name="${list.id}"/>${list.nombre} </h3> 
		    </header>
		    <div class="w3-container">
		      <hr>
		      <img src="/resources/imagenes/celular.png" alt="Avatar" class="w3-left w3-circle w3-margin-right" style="width:60px">
				 <p><a href="${list.paginainternet}">${list.paginainternet}</a> </p>    
		     	 <p><a href="${list.twitter}"><img src="/resources/imagenes/twitter.png" alt="Avatar" class="w3-left w3-circle w3-margin-right" style="width:30px"></a></p>
		     	 <p><a href="${list.facebook}"><img src="/resources/imagenes/facebook.png" alt="Avatar" class="w3-left w3-circle w3-margin-right" style="width:30px"></a></p>
		     	 <p><a href="${list.google}"><img src="/resources/imagenes/google.png" alt="Avatar" class="w3-left w3-circle w3-margin-right" style="width:30px"></a></p><br>
    			 
    		</div>	  
		</div>
	</div>
</div>
</c:forEach>
<form action="editarExpositor" id="editarExpositor" name="editarExpositor" >
<input type="hidden" name="idExpositor" id="idExpositor">
</form>
<script>
$('button').on('click', function(){
	  var myform = document.getElementById('editarExpositor');
	  var id= $(this).next('input').attr('id');
    document.getElementById('idExpositor').value = id;
    myform.submit();
              
});</script>
</body>
</html>