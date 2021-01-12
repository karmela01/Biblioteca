<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@page import="java.util.*" %>

<%@page import="model.Usuario"%>
<%@page import="java.lang.reflect.Field"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<title>Vista Usuarios</title>
</head>
<body>
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
		
		    <div id="volver" class="col-4">
		    	<p><a class="btn btn-primary btn-block"  href="index.jsp" role="button">volver</a></p> 
			</div>
			 <div id="insertar" class="col-4">
		    	<p><a class="btn btn-primary btn-block"  href="usuario.jsp"" role="button">Insertar</a></p> 
			</div>	
	  
	</div>


<table class="table table-striped mt-5">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">NOMBRE</th>
      <th scope="col">MAIL</th>
      <th scope="col">ESTADO</th>
      <th scope="col">ACCIÓN1</th>
      <th scope="col">ACCIÓN2</th>
    </tr>
  </thead>
  <tbody>
   
  <% @SuppressWarnings("unchecked")
	List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");%>
  
  <%
	 for(Usuario usr : usuarios){%>
		<tr>
		<td>
		 	<%=usr.getId()%>		 
		</td>
		<td>
		 	<%=usr.getNombre()%>		 
		</td>
		<td>
		 	<%=usr.getMail()%> 
		</td>		
		 <td> 
		 	<%=usr.getEstado()%>
		 </td>
		 <td> 
		 <a href="usuario?action=borra&id=<%=usr.getId()%>">Borrar</a>
		 </td>	
		 <td> 
		 <a href="usuario?action=edita&id=<%=usr.getId()%>">Editar</a>
		 </td>			
		 </tr>
		 
	<%} %>
</table>
</body>
</html>