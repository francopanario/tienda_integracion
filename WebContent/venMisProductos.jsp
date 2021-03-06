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
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/jquery.blockUI.js"></script>
<script type="text/javascript" src="js/bootstrap-notify.js"></script>
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
	<form id="editarProducto" method="post" action="Inicio?action=editarProducto" class="form-horizontal" role="form">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Codigo de Barras</th>
					<th>Nombre</th>
					<th>Precio</th>
					<th>Activo</th>			
				</tr>
			</thead>
			<tbody>
				<% List<Producto> productos = Controlador.getInstancia().getAllProductosVendedor(Controlador.getInstancia().getUsername(),Controlador.getInstancia().getPassword());
			  		Producto prod;    
			  		
				%>
				<% for (Iterator<Producto> i = productos.iterator(); i.hasNext();) {
					prod = i.next();
				%>
				<tr>
					<td><%out.print(prod.getCodBarra());%></td>
					<td><%out.print(prod.getNombre());%></td>
					<td><%out.print(prod.getPrecio());%></td>
					<td><%
							if (prod.isActivo()){
								out.print("<p style='max-width:20px; background-color: #33cc33;'>&nbsp;</p>");
							}else{
								out.print("<p style='max-width:20px; background-color: #ff0000;'>&nbsp;</p>");
							}
						%>
					</td>
					<td><button id="btn-editar" name="codBarra" value="<%out.print(prod.getCodBarra());%>" type="submit" class="btn btn-success">Editar</button></td>					
				</tr>
				<%				
					}
				%>
				
			</tbody>
		</table>
	</form>
</div>