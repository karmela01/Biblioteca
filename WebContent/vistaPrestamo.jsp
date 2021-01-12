<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@page import="java.util.List" %>

<%@page import="model.Prestamo"%>
<%@page import="java.lang.reflect.Field"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<title>Vista Libros</title>
</head>
<body>

<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">FECHA</th>
      <th scope="col">NOMBRE_USUARIO</th>
      <th scope="col">TITULO_LIBRO</th>
      <th scope="col">ACCIÓN1</th>
      <th scope="col">ACCIÓN2</th>
    </tr>
  </thead>
  <tbody>
   
  <% @SuppressWarnings("unchecked")
	List<Prestamo> prestamos = (List<Prestamo>) request.getAttribute("prestamos");%>
  
  <%
	 for(Prestamo p : prestamos){%>
		<tr>
		<td>
		 	<%=p.getId()%>		 
		</td>
		<td>
		 	<%=p.getFecha()%>		 
		</td>
		<td>
		 	<%=p.getNombre_usuario()%> 
		</td>		
		 <td> 
		 	<%=p.getTitulo_libro()%>
		 </td>
		 <td> 
		 <a href="prestamo?action=borra&id=<%=p.getId()%>">Borrar</a>
		 </td>	
		 <td> 
		 <a href="prestamo?action=edita&id=<%=p.getId()%>">Editar</a>
		 </td>			
		 </tr>
		 
	<%} %>
</table>
</body>
</html>