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
<script type="text/javascript">
	function callPostServletCompra() {
		//var cantidad=$("#cantidad_"+codBarra).val();
		var codBarra = ${prod.codBarra};
		var nombre = ${prod.nombre};
		var precio = ${prod.precio};
		var usuario_id = ${usuario.usuario_id};
		alert(codBarra);
		alert(nombre);
		alert(precio);
		alert(cantidad);
		alert(usuario_id);
		var url='Compra';
		//$(button).prop('disabled',true);
		console.log('cantidad '+cantidad);	
		$.ajax({
			url: url,
		    type: "post",
		    //data: {codBarra: codBarra, nombre: nombre, precio: precio, cantidad, usuario_id : usuario_id}
		}).done(function (respuesta){
			//$(button).prop('disabled',false);
			$.unblockUI();
			$.notify({message: 'Articulo agregado correctamente!'},{type: 'success'});
		}).fail(function(){
			$.unblockUI();
			var responseJsonObj = JSON.parse(data.responseText);
			$.notify({message: responseJsonObj.errorMessage},{type: 'danger'});
		});
	}
</script>

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
	<form method="post" action="Inicio?action=nuevoFactura">
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
					<td id="codBarra"><%out.print(prod.getCodBarra());%></td>
					<td><%out.print(prod.getNombre());%></td>
					<td><%out.print(prod.getPrecio());%></td>
					<td><input style="max-width: 60px;"type="number" value="0" name="cantidad" id="cantidad"></td>
					<td>
						<input id="compra" type="submit" value="Comprar" class="btn btn-info"/>					
					</td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</form>
</div>