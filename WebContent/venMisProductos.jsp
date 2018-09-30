<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<body>
	<center><h1>Estos son Mis Productos</h1></center>
</body>
<div>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Codigo de Barras</th>
				<th>Nombre</th>
				<th>Precio</th>
				<th>Cantidad</th>				
			</tr>
		</thead>
		<tbody>
			<% List<Producto> productos = Controlador.getInstancia().getAllProductos();
		  		Producto prod;    
			%>
			<% for (Iterator<Producto> i = productos.iterator(); i.hasNext();) {
				prod = i.next();
			%>
			<tr>
				<td><%out.print(prod.getCodBarra());%></td>
				<td><%out.print(prod.getNombre());%></td>
				<td><%out.print(prod.getPrecio());%></td>
				<td><input style="max-width: 60px;"type="number" value="0" name="cantidad_${prod.codBarra}" id="cantidad_${prod.codBarra}"></td>
				<td>
					<input id="compra" type="button" value="Comprar" class="btn btn-info" onclick="callPostServletCompra();" />					
				</td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
</div>