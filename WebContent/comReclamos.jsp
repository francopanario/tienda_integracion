<head>
	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	    pageEncoding="ISO-8859-1"%>
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
	<div>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Factura ID</th>
					<th>Vendedor</th>
					<th>Articulo</th>
					<th>Reclamo ID</th>
					<th>Detalles</th>
					<th>Estado</th>
					<th>Activo</th>
				</tr>
			</thead>
			<tbody>
				<%
					List<Factura> facturas = Controlador.getInstancia().getAllFacturasComprador(Controlador.getInstancia().getUsername(),Controlador.getInstancia().getPassword());
		  			Factura fac;
			  		Reclamo rec;
			  		List<Reclamo> reclamos = Controlador.getInstancia().getAllReclamos();
			  		for(int i=0;i<facturas.size();i++){
			  			for(int r=0;r<reclamos.size();r++){
			  				if(facturas.get(i).getFacturaID().equals(reclamos.get(r).getFactura().getFacturaID())){
			  					rec= reclamos.get(r);
			  				
				%>
				<% 
					
				%>
				<tr>
					<td><%out.print(rec.getFactura().getFacturaID());%></td>
					<td><%out.print(rec.getFactura().getComprador().getUsername());%></td>
					<td><%out.print(rec.getFactura().getArticulo().getNombre());%></td>
					<td><%out.print(rec.getReclamo_id());%></td>
					<td><%out.print(rec.getDetalles());%></td>
					<td><%out.print(rec.getEstado());%></td>
					<td><%
							if (rec.isActivo()){
								out.print("<p style='max-width:20px; background-color: #33cc33;'>&nbsp;</p>");
							}else{
								out.print("<p style='max-width:20px; background-color: #ff0000;'>&nbsp;</p>");
							}
						%>
					</td>
				</tr>
				<%
							}
			  			}
			  		}
				%>				
			</tbody>
		</table>
	</div>	
</body>