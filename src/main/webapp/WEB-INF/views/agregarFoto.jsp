<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="addFoto" method="POST" >
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