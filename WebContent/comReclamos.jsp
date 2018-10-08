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
          <li><a href="vistaComprador.jsp">Tienda</a></li>
          <li><a href="comMisCompras.jsp">Mis Compras</a></li>
          <li class="active"><a>Reclamos</a></li>
        </ul>    
        <ul class="nav pull-right">
          <li class="divider-vertical"></li>
          <li><a href="/tienda_integracion">Salir</a></li>
        </ul>
      </div><!-- /.nav-collapse -->
    </div>
  </div><!-- /navbar-inner -->
</div>
<body>
	<center><h1>Estas son Mis Reclamos</h1></center>
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
				List<Factura> facturas = Controlador.getInstancia().getAllFacturasVendedor(Controlador.getInstancia().getUsername(),Controlador.getInstancia().getPassword());
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
</body>