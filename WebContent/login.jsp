<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<title>Login</title>
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
		    <h5 class="card-title">Login</h5>
			    <form action="login">
				  <div class="form-group">
				    <label for="nombre">nombre</label>
				    <input type="text" class="form-control" id="nombre" name="nombre">   
				  </div>
				  <div class="form-group">
				    <label for="password">Contraseña</label>
				    <input type="password" class="form-control" id="password" name="password">
				  </div>			  
		  
		 			<button type="submit" class="btn btn-primary">Registrar</button>