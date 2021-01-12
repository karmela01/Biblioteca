<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>index</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<div class="container">

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
	
	<div class="row justify-content-center mt-5">
		
		    <div id="verLibros" class="col-4">
		    	<p><a class="btn btn-primary btn-block"  href="libro?action=lista&id=0" role="button">Libros</a></p> 
			</div>
			 <div id="verUsuarios" class="col-4">
		    	<p><a class="btn btn-primary btn-block" href="usuario?action=lista&id=0" role="button">Usuarios</a></p> 
			</div>	
	  
	</div>
	<div id="imagen">
	
	<div id="carouselExampleSlidesOnly" class="carousel slide" data-ride="carousel">
	  <div class="carousel-inner">
	    <div class="carousel-item active">
	        <img src="..." class="d-block w-100" alt="...">
	    </div>   
	  </div>
	</div>
	</div>
</div>
</body>
</html>