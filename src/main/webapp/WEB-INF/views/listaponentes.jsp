<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv=”Content-Type” content=”text/html; charset=UTF-8″>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body>
<div class="justify-content-start">
        <a href="atras">
          <img class="img-regreso" src="resources/imagenes/back.png" alt="...">
        </a>
      </div>
<c:forEach items="${lista}" var="list">
<div class="row" style="background-color:#ccc;height:40px"></div>
<div class="row">
	<div class="column" style="background-color:#aaa" >
  		<div class="w3-container">
		    <div class="w3-container">
		      <hr>
		      <img src="/resources/imagenes/celular.png" alt="Avatar" class="w3-left w3-circle w3-margin-right" style="width:60px">
				 <p>${list.nombre}</p>    
		     	 <p>${list.puesto}</p>
		     	 <p>${list.semblanza}</p>	 
    		</div>	  
		</div>
	</div>
</div>
</c:forEach>
</body>
</html>