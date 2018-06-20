<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.io.*" %> 
<html>
<head>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
</head>
<body >
	
		<table style="width: 100%" >
			<thead>
				<tr>
				   <th class="hasinput" style="width: 15%;">
				   Nombre 
				   </th>
				   <th class="hasinput" style="width: 15%;">
				   E-Mail
				   </th>
				   <th class="hasinput" style="width: 15%; ">
				   Telefono
				   </th>
				   <th class="hasinput" style="width: 15%;">
				   Fecha Nacimiento
				   </th>				   
				   <th class="hasinput" style="width: 15%;">
				   Tipo de Usuario
				   </th>
				   <th class="hasinput" style="width: 15%;">
				   Centro Operativo
				   </th>
				   <th class="hasinput" style="width: 10%;">
				   Editar
				   </th>
				</tr>					  	
			</thead>
			<tbody>
						<c:forEach items="${lista}" var="list">
							<tr>
								<td><label>	${list.nombre} </label></td>
								<td><label> ${list.email}</label> </td>
								<td><label> ${list.telefono}</label></td>
								<td><label> ${list.fechaNacimiento}</label></td>
								<td><label> ${list.categoria.detalle}</label></td>
								<td><label> ${list.centro.centroOpeativo}</label></td>
								<td >
									<button> Editar </button>
									<input hidden="true" type="text"  id="${list.id}"/>
							
								</td>
																
							</tr>	
							</c:forEach>
						</tbody>
						</table>
						<form action="editarUsuario" id="myform" name="myform">
						<input type="hidden" id="idUsuario" name="idUsuario" value="0" />
						</form>
						
						<script type="text/javascript">
						 
							$('button').on('click', function(){
							  var myform = document.getElementById('myform');
							  var id= $(this).next('input').attr('id');
							  document.getElementById('idUsuario').value = id;
						      myform.submit();
						                
							});
						
						</script>
</body>
</html>