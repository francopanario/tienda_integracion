<head>
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
</head>
<body>
<% 
					if (request.getParameter("usuario") != null){
		%>
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
          <li class="active"><a>Mis Ventas</a></li>
          <li><a href="venMisProductos.jsp">Mis Productos</a></li>
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
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Factura ID</th>
				<th>Comprador</th>
				<th>Articulo</th>
				<th>Cantidad</th>
				<th>Medio de Pago</th>
				<th>Total</th>
			</tr>
		</thead>
		<tbody>
			<% List<Factura> facturas = Controlador.getInstancia().getAllFacturasVendedor(Controlador.getInstancia().getUsername(),Controlador.getInstancia().getPassword());
		  		Factura fac;     
			%>
			<% for (Iterator<Factura> i = facturas.iterator(); i.hasNext();) {
				fac = i.next();
			%>
			<tr>
				<td><%out.print(fac.getFacturaID());%></td>
				<td><%out.print(fac.getComprador().getUsername());%></td>
				<td><%out.print(fac.getArticulo().getNombre());%></td>
				<td><%out.print(fac.getCant());%></td>
				<td><%out.print(fac.getMedio());%></td>
				<td><%out.print(fac.getTotal());%></td>
				
			</tr>
			<%
				}
			}
			%>
		</tbody>
	</table>
</div>
</body>