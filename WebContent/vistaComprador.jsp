<head>
	<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
	<%@ page import="java.util.List"%>
	<%@ page import="java.util.Iterator"%>
	<%@page import="java.util.ArrayList"%>
	<%@ page import="negocio.*"%>
	<%@page import="controlador.Controlador"%>
	
	
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/custom.css">
</head>
<!------ Include the above in your HEAD tag ---------->

<body class ="body-color">
	<nav class="navbar navbar-default col-xs-12 navbar-color">
		<div class="container-fluid">
	    	<div class="row-fluid">   
	      		<!-- Brand and toggle get grouped for better mobile display -->    
	      		<div class="navbar-header">
	        		<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
	                	<span class="icon-bar"></span>
	          			<span class="icon-bar"></span>
	          			<span class="icon-bar"></span>
	        		</button>
	       		 	<a class="navbar-brand" href="#">Tienda</a>
	      		</div>
	      		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	       	 		<ul class="nav navbar-nav">          			
	          			<li><a href="comMisCompras.jsp">Mis Compras</a></li>
		          		<li><a href="comReclamos.jsp">Reclamos</a></li>
		        	</ul>
		        	<ul class="nav navbar-nav right">
			    		<li class="divider-vertical"></li>
		        		<li><a href="/tienda_integracion">Salir</a></li>
	        		</ul>
	      		</div>
	  		</div>  
		</div>
	</nav>
	<div class="container">
		<form id="comprador" method="post" action="Comprador?action=comprar">			
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Nombre</th>
						<th>Precio</th>
						<th>Vendedor</th>					
					</tr>
				</thead>
				<tbody>
					<% List<Producto> productos = Controlador.getInstancia().getAllProductos();
				  		Producto prod;			 	
				  		for(int i= 0; i<productos.size();i++) {
							prod = productos.get(i);
							Usuario usuario = prod.getUsuario();
							if(prod.isActivo() == true){
						
					%>
					<tr>
						<td><%out.print(prod.getNombre());%></td>
						<td><%out.print(prod.getPrecio());%></td>
						<td><%out.print(usuario.getUsername());%></td>
						<td><button class="btn btn-success" value=<%out.print(prod.getCodBarra());%> name="codBarra" type="submit">Comprar</button></td>					
					</tr>					
					<%
							}
						}
					%>
				</tbody>
			</table>		
		</form>
	</div>
</body>