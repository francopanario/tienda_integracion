<head>
	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	    pageEncoding="ISO-8859-1"%>
	<%@ page import="java.util.List"%>
	<%@ page import="java.util.Iterator"%>
	<%@page import="java.util.ArrayList"%>
	<%@ page import="negocio.*"%>
	<%@page import="controlador.Controlador"%>
	
	<!DOCTYPE html>
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
	       		 	<a class="navbar-brand" href="/vistaComprador.jsp">Tienda</a>
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
	<div align="center">
		<div id="loginbox" style="margin-top: 50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<div class="panel panel-info">
				<div class="panel-heading">
					<h2>Subir Reclamo<h2>
				</div>
				<div style="padding-top: 30px" class="panel-body">
					<form id="ingresarReclamo" method="post" action="Comprador?action=ingresarReclamo" class="form-horizontal" role="form">
						<div style="margin-bottom: 25px" class="input-group">
							<p>Ingrese su reclamo</p>
						</div>
						<div style="margin-bottom: 25px" class="input-group">
							<textarea rows="7" cols="50" name="reclamo"></textarea>
						</div>
						<% Factura fac = Controlador.getInstancia().getFactura(request.getParameter("facturaId"));%>							
						<div style="margin-top: 10px" class="form-group">
						<!-- #################################### BOTON SUBMIT ####################################-->
	    					<div class="col-sm-12 controls">
								<button id="btn-login" type="submit" name="facturaId" class="btn btn-success" value="<%out.print(fac.getFacturaID());%>">Subir</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>