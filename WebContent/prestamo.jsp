<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<title>pr�stamo</title>
</head>
<body>
<div class ="container">
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	  <a class="navbar-brand" href="#">Inicio</a>	   
	  <a class="navbar-brand" href="#">Registro</a>
	  <a class="navbar-brand" href="#">Login</a>
	  <a class="navbar-brand" href="#">Pr�stamos</a>	 
	</nav>
	
		<div id="formulario  mt-5">
	<div class="card" style="width: 18rem;">
		  <div class="card-body">
		    <h5 class="card-title">Formulario de pr�stamo</h5>
			    <form action="prestamo">
				  <div class="form-group">
				    <label for="tituloLibro">T�tulo libro</label>
				    <input type="text" class="form-control" id="tituloLibro" name="tituloLibro">   
				  </div>
				  <div class="form-group">
				    <label for="autor">Autor</label>
				    <input type="text" class="form-control" id="autor" name="autor">
				  </div>
				  <div class="form-group">
				    <label for="editorial">Editorial</label>
				    <input type="text" class="form-control" id="editorial" name="editorial">
				  </div>
		  
		 			<button type="submit" class="btn btn-primary">Solicitar</button>
				</form>
  			</div>
  		</div>
	</div>
    
  </div>
</div>
</div>
</body>
</html>