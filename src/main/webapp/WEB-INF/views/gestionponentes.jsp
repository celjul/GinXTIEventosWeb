<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
</head>
<body>
<div><form id="agregarPonente" name="agregarPonente" action="agregarPonente"><input type="submit" value="+Agregar"/></form></div>
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
		      <img src="data:image/png;base64,${list.foto}"
		      class="w3-left w3-margin-right" style="width:100px; height:100px;">
				 <p>${list.nombre}</p>    
		     	 <p>${list.puesto}</p>
		     	 <p>${list.semblanza}</p>	 
    		</div>	  
		</div>
	</div>
</div>
</c:forEach>
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