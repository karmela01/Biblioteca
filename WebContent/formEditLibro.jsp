<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.Libro"%>
<%@page import="java.lang.reflect.Field"%>
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
	  <a class="navbar-brand" href="#">Inicio</a>	   
	  <a class="navbar-brand" href="#">Registro</a>
	  <a class="navbar-brand" href="#">Login</a>
	  <a class="navbar-brand" href="#">Préstamos</a>	 
	</nav>
	
	<div id="formulario  mt-5">
	<div class="card" style="width: 18rem;">
		  <div class="card-body">
		    <h5 class="card-title">Editar libro</h5>
				    <form action="libro" method ="post">	
				    
					  <% Libro lbr = (Libro) request.getAttribute("libro");  %>
					  
						<div class="form-group">				  
							<input type="hidden" id="id" class="form-control" name="id" value="<%=lbr.getId()%>">
						</div>
						<div class="form-group">
							<label for="titulo">Titulo</label> <input type="text" class="form-control" id="titulo" name="titulo" value="<%=lbr.getTitulo()%>">
						</div>
						<div class="form-group">
							<label for="autor">Autor</label> <input type="text" id="autor" name="autor" value="<%=lbr.getAutor()%>">
						</div>
						<div class="form-group">						
							<label for="editorial">Editorial</label> <input type="text" id="editorial" name="editorial" value="<%=lbr.getEditorial()%>">
						</div>
						
						<input type="hidden" value="modifica" name="action"/>
							<input type="submit" value="Guardar">							
					</form>
					</div>
				</div>
  			</div>
  		</div>

</body>
</html>