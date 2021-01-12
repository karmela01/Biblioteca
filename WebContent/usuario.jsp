<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<title>usuario</title>
</head>
<body>
<div class ="container">
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">BIBLIOTECA CELIA VIÑAS</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <form method ="post" action="buscar"  class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" name="query" type="search" placeholder="búsqueda de Libros" aria-label="Search">
      <button class="btn btn-outline-primary my-2 my-sm-0" type="submit">Libros</button>
    </form>
    <form  method ="post" action="buscarUsuario"  class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" name="query" type="search" placeholder="búsqueda de Usuarios" aria-label="Search">
      <button class="btn btn-outline-primary my-2 my-sm-0" type="submit">Usuarios</button>
    </form>  
</nav>
	
     
     
	<div id="titulo" class="text-center mt-5">
	<h3>Bienvenidos a la bibioteca Celia Viñas</h3>
	<h4 class="font-italic text-primary font-weight-bold">sequentia columna librarium</h4>
	</div>
	
	
	<div id="formulario" class="d-flex justify-content-center">
	<div class="card" style="width: 18rem;">
		  <div class="card-body">
		    <h5 class="card-title">Registrar nuevo usuario</h5>
			    <form action="usuario" method="post">
				  <div class="form-group">
				    <label for="titulo">Nombre</label>
				    <input type="text" class="form-control" id="nombre" name="nombre">   
				  </div>
				  <div class="form-group">
				    <label for="autor">Mail</label>
				    <input type="text" class="form-control" id="mail" name="mail">
				  </div>
				 <div class="form-group">
				    <label for="password">Contraseña</label>
				    <input type="password" class="form-control" id="password" name="password">
				  </div>
				  <div class="form-group">
				    <label for="estado">Estado</label>
				    <input type="text" class="form-control" id="estado" name="estado">
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