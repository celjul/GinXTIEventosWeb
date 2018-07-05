<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="updateSponsor" method="POST">
<label>Nombre</label>
<input name="txtnombre" id="txtnombre" type="text" value="${sponsor.nombre}"/>
<input hidden="hidden" name="idSponsor" id="idexpositor" value="${sponsor.id}"/>
<label>facebook</label>
<input name="txtfacebook" id="txtfacebook" type="text" value="${sponsor.facebook}"/>
<label>google</label>
<input name="txtgoogle" id="txtgoogle" type="text" value="${sponsor.google}"/>
<label>twitter</label>
<input name="txttwitter" id="txttwitter" type="text" value="${sponsor.twitter}"/>
<br>
<label>Pagina Internet</label>
<input name="txtpaginainternet" id="txtpaginainternet" type="text" value="${sponsor.paginainternet}"/>
<br>
<input id="inp" type='file'/>
<input hidden="hidden" name="bslogo" id="bslogo" value="${sponsor.logo}"/>
<input hidden="hidden" name="txtcambio" id="txtcambio" value="0"/>
<input type="submit" value="Editar" >
</form>
<form action="deleteSponsor"><input hidden="hidden" name="idsponsord" id="idsponsord" value="${sponsor.id}"/><input type="submit" value="Eliminar" ></form>

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