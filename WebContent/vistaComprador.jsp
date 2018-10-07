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
<!------ Include the above in your HEAD tag ---------->


<div class="navbar">
  <div class="navbar-inner">
    <div class="container">
      <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </a>
      <a class="brand" href="#">Integracion</a>
      <div class="nav-collapse">
        <ul class="nav">
          <li class="active"><a>Tienda</a></li>
          <li><a href="comMisCompras.jsp">Mis Compras</a></li>
          <li><a href="comReclamos.jsp">Reclamos</a></li>
        </ul>    
        <ul class="nav pull-right">
          <li class="divider-vertical"></li>
          <!-- ################ ACA CERRAR SESION DE USUARIO ######### -->
          <li><a href="/tienda_integracion">Salir</a></li>
        </ul>
      </div><!-- /.nav-collapse -->
    </div>
  </div><!-- /navbar-inner -->
</div>
<div class="container">
	<form method="post" action="Inicio?action=nuevaFactura">
			<table class="table table-striped">
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Precio</th>
					<th>Vendedor</th>
					<th>Medio de Pago</th>
					<th>Cantidad</th>								
				</tr>
			</thead>
			<tbody>
				<% List<Producto> productos = Controlador.getInstancia().getAllProductos();
			  		Producto prod;			  		
				%>
				<% for (Iterator<Producto> i = productos.iterator(); i.hasNext();) {
					prod = i.next();
					Usuario usuario = prod.getUsuario();
				%>
				<tr>
					<td><%out.print(prod.getNombre());%></td>
					<td><%out.print(prod.getPrecio());%></td>
					<td><%out.print(usuario.getUsername());%></td>
					<td>
						<select id="medio" type="text" class="form-control" name="medio" placeholder="medio" style="max-width: 90px;" onchange="yesnoCheck(this);">
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
					<td><input style="max-width: 60px;"type="number" value="0" name="cantidad" id="cantidad" /></td>
					<td><button id="btn-login" name="codBarra" value=<%out.print(prod.getCodBarra());%> type="submit" class="btn btn-success">Comprar</button></td>					
				</tr>					
				<%
					}
				%>
			</tbody>
		</table>
		<br />
		<div class="row" id="ifYes" style="display: none;">
    		<label for="nroTarjeta">Numero de Tarjeta</label><input id="nroTarjeta" name="nroTarjeta"></input>
    		<label for="duenio">Nombre del propietario</label><input id="duenio" name="duenio"></input>
    		<label for="fechaExp">Fecha expiracion</label><input id="fechaExp" name="fechaExp"></input>
    		<label for="codigo">Codigo Seguridad</label><input id="codigo" type="password"  name="codigo"></input>    						
		</div>
		<div class="row" id="ifSo" style="display: none;">
    		<label for="nroCuenta">Numero de Cuenta</label><input id="nroCuenta" name="nroCuenta"></input>
    		<label for="duenio">Nombre del propietario</label><input id="duenio" name="duenio"></input>
    		<label for="banco">Banco</label><input id="banco" name="banco"></input>    						
		</div>
	</form>
</div>