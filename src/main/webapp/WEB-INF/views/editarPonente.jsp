<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="updatePonente" method="POST">
<label>Nombre</label>
<input name="txtnombre" id="txtnombre" type="text" value="${ponente.nombre}"/>
<input hidden="hidden" name="idponente" id="idponente" value="${ponente.id}"/>
<label>Puesto</label>
<input name="txtpuesto" id="txtpuesto" type="text" value="${ponente.puesto}"/>
<label>Semblanza</label>
<input name="txtsemblanza" id="txtsemblanza" type="text" value="${ponente.semblanza}"/>
<label>Logo</label>
<input id="inp" type='file'/>
<input hidden="hidden" name="bslogo" id="bslogo" value="${ponente.foto}"/>
<input hidden="hidden" name="txtcambio" id="txtcambio" value="0"/>
<input type="submit" value="Agregar" >
</form>
<form action="deletePonente"><input hidden="hidden" name="idponented" id="idponented" value="${ponente.id}"/><input type="submit" value="Eliminar" ></form>


<script type="text/javascript">
function readFile() {
	  
	  if (this.files && this.files[0]) {
	    
	    var FR= new FileReader();
	    
	    FR.addEventListener("load", function(e) {
	    	  var id= e.target.result;
	      document.getElementById("bslogo").value = id;
	      document.getElementById("txtcambio").value = 1;
	      
	    }); 
	    
	    FR.readAsDataURL( this.files[0] );
	  }
	  
	}

	document.getElementById("inp").addEventListener("change", readFile);
</script>

</body>
</html>