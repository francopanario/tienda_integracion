<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="negocio.*"%>
<%@page import="controlador.Controlador"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/custom.css">
<!------ Include the above in your HEAD tag ---------->

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
       		 	<a class="navbar-brand" href="vistaComprador.jsp">Tienda</a>
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
<body class ="body-color">
	<div class="container">
		<form method="post" action="Inicio?action=nuevaFactura">
			<div class="container">
				<div class="row center-img">
					<img src="${pageContext.request.contextPath}/img/carne-cerdo.jpg" />					
				</div>
			</div>
			<div class="container">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Codigo de Barras</th>
							<th>Nombre</th>
							<th>Precio</th>
							<th>Cantidad</th>
							<th>Medio de Pago</th>					
						</tr>
					</thead>
					<tbody>
						<% Producto prod = Controlador.getInstancia().getProductoVendedor(request.getParameter("codBarra"));%>
						<tr>
							<td><%out.print(prod.getCodBarra());%></td>
							<td><%out.print(prod.getNombre());%></td>
							<td><%out.print(prod.getPrecio());%></td>
							<td><input style="max-width: 60px;" type="text" value="0" name="cantidad" id="cantidad"/></td>
							<td>
								<select id="<%prod.getCodBarra();%>medio" type="text" class="form-control" name="medio" style="max-width: 90px;" onchange="yesnoCheck(this);">
									<option value="blank"></option>
									<option value="efectivo">Efectivo</option>
									<option value="tarjeta">Tarjeta</option>
									<option value="ctaCorriente">CtaCorriente</option>
								</select>
							</td>
							<script>
	    						function yesnoCheck(that) {
	        						if (that.value == "tarjeta") {
	            						document.getElementById("ifYes").style.display = "block";
	       							 } else {
			           					document.getElementById("ifYes").style.display = "none";
			       					 }
	   		     					if (that.value == "ctaCorriente") {
	   	   		  						document.getElementById("ifSo").style.display = "block";
	      							 } else {
		    	       					document.getElementById("ifSo").style.display = "none";
		       						 }
	 						   	}
							</script>															
						</tr>						
					</tbody>
				</table>
			</div>
			<br />
			<div class="container">			
				<div class="row" id="ifYes" style="display: none;">
		    		<label class="label-tarjeta" for="nroTarjeta">Numero de Tarjeta</label><input id="nroTarjeta" name="nroTarjeta"></input>
		    		<label class="label-tarjeta" for="duenio">Nombre del propietario</label><input id="duenio" name="duenio"></input>
		    		<label class="label-tarjeta" for="fechaExp">Fecha expiracion</label><input id="fechaExp" name="fechaExp"></input>
		    		<label class="label-tarjeta" for="codigo">Codigo Seguridad</label><input id="codigo" type="password"  name="codigo"></input>    						
				</div>
				<div class="row" id="ifSo" style="display: none;">
		    		<label for="nroCuenta">Numero de Cuenta</label><input id="nroCuenta" name="nroCuenta"></input>
		    		<label for="dueniocca">Nombre del propietario</label><input id="dueniocca" name="duenio"></input>
	    			<label for="banco">Banco</label><input id="banco" name="banco"></input>    						
				</div>		
			</div>
			<div class="row">
				<center><button name="codBarra" value=<%out.print(prod.getCodBarra());%> class="btn btn-success size-btn" type="submit">Confirmar</button></center>
			</div>
		</form>
	</div>
</body>