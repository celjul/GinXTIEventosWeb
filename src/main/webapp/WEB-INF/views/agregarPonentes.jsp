<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
<form action="addPonente" method="POST">
<label>Nombre</label>
<input name="txtnombre" id="txtnombre" type="text" />
<label>Puesto</label>
<input name="txtpuesto" id="txtpuesto" type="text" />
<br>
<label>Semblanza</label>
<textarea name="txtsemblanza" cols="150" rows="10" id="txtsemblanza" type="text" ></textarea>
<label>Logo</label>
<input id="inp" type='file'/>
<input hidden="hidden" name="bslogo" id="bslogo" value=""/>
<input type="submit" value="Agregar" >
</form>
<script type="text/javascript">
function readFile() {
	  
	  if (this.files && this.files[0]) {
	    
	    var FR= new FileReader();
	    
	    FR.addEventListener("load", function(e) {
	    	  var id= e.target.result;
	      document.getElementById("bslogo").value = id
	    }); 
	    
	    FR.readAsDataURL( this.files[0] );
	  }
	  
	}

	document.getElementById("inp").addEventListener("change", readFile);
</script>
</body>
</html>