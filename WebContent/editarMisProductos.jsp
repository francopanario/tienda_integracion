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
          <li><a href="vistaVendedor.jsp">Mis Ventas</a></li>
          <li class="active"><a>Mis Productos</a></li>
          <li><a href="venSubirProducto.jsp">Subir Producto</a></li>
          <li><a href="venMisQuejas.jsp">Mis Quejas</a></li>
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
	<form method="post" action="Inicio?action=modificarProducto">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Codigo de Barras</th>
					<th>Nombre</th>
					<th>Precio</th>					
				</tr>
			</thead>
			<tbody>
				<% Producto prod = Controlador.getInstancia().getProductoVendedor(request.getParameter("codBarra"));%>
				<tr>
					<td><%out.print(prod.getCodBarra());%></td>
					<td><input style="max-width: 60px;" type="text" value="<%out.print(prod.getNombre());%>" name="nombre" id="nombre" /></td>
					<td><input style="max-width: 60px;" type="text" value="<%out.print(prod.getPrecio());%>" name="precio" id="precio" /></td>
					<td>
						<select type="text" class="form-control" name="estado" placeholder="estado" style="max-width: 90px;">
							<option value="true">Activar</option>
							<option value="false">Desactivar</option>
						</select>
					</td>
					<td><button name="codBarra" value=<%out.print(prod.getCodBarra());%> class="btn btn-success" type="submit">Editar</button></td>								
				</tr>						
			</tbody>
		</table>
	</form>
</div>