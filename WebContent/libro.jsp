<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<title>libro</title>
</head>
<body>
<div class ="container">
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">BIBLIOTECA CELIA VI�AS</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <form method ="post" action="buscar"  class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" name="query" type="search" placeholder="b�squeda de Libros" aria-label="Search">
      <button class="btn btn-outline-primary my-2 my-sm-0" type="submit">Libros</button>
    </form>
    <form  method ="post" action="buscarUsuario"  class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" name="query" type="search" placeholder="b�squeda de Usuarios" aria-label="Search">
      <button class="btn btn-outline-primary my-2 my-sm-0" type="submit">Usuarios</button>
    </form>  
</nav>
	
     
     
	<div id="titulo" class="text-center mt-5">
	<h3>Bienvenidos a la bibioteca Celia Vi�as</h3>
	<h4 class="font-italic text-primary font-weight-bold">sequentia columna librarium</h4>
	</div>
	
	<div id="formulario  mt-5" class="d-flex justify-content-center">
	<div class="card justify-content-center" style="width: 18rem;">
		  <div class="card-body">
		    <h5 class="card-title">Registrar nuevo libro</h5>
			    <form action="libro" method ="post">
				  <div class="form-group">
				    <label for="titulo">T�tulo</label>
				    <input type="text" class="form-control" id="titulo" name="titulo">   
				  </div>
				  <div class="form-group">
				    <label for="autor">Autor</label>
				    <input type="text" class="form-control" id="autor" name="autor">
				  </div>
				  <div class="form-group">
				    <label for="editorial">Editorial</label>
				    <input type="text" class="form-control" id="editorial" name="editorial">
				  </div>
		  
		 			<button type="submit" class="btn btn-primary">Registrar</button>
		 			<a class="btn btn-primary"  href="index.jsp" role="button">volver</a></p>
				</form>
  			</div>
  		</div>
	</div>
	
</div>
</body>
</html>