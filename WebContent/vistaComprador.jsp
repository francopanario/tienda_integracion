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
<div>
	<form method="post" action="Inicio?action=nuevaFactura">
			<table class="table table-striped">
			<thead>
				<tr>
					<th>Codigo de Barras</th>
					<th>Nombre</th>
					<th>Precio</th>
					<th>Vendedor</th>
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
					<td id="codBarra" label for="usermail"><%out.print(prod.getCodBarra());%></td>
					<td><%out.print(prod.getNombre());%></td>
					<td><%out.print(prod.getPrecio());%></td>
					<td><%out.print(usuario.getUsername());%>
					<td><input style="max-width: 60px;"type="number" value="0" name="cantidad" id="cantidad" /></td>
					<td><button id="btn-login" name="codBarra" value=<%out.print(prod.getCodBarra());%> type="submit" class="btn btn-success">Comprar</button></td>					
				</tr>
				<%
					}
				%>
			</tbody>
		</table>		
	</form>
</div>