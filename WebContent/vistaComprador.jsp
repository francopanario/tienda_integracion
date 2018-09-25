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
          <li><a href="">Tienda</a></li>
          <li><a href="">Mis Compras</a></li>
          <li><a href="">Reclamos</a></li>
        </ul>    
        <ul class="nav pull-right">
          <li class="divider-vertical"></li>
          <!-- ################ ACA CERRAR SESION DE USUARIO ######### -->
          <li><a href="#">Salir</a></li>
        </ul>
      </div><!-- /.nav-collapse -->
    </div>
  </div><!-- /navbar-inner -->
</div>
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
			<c:forEach items="${productos}" var="p"> 
				<tr>
					<td>${p.codBarra}</td>
					<td>${p.nombre}</td>
					<td>${p.precio}</td>
					<td><input style="max-width: 60px;"type="number" value="0" name="cantidad_${p.codBarra}" id="cantidad_${p.codBarra}"></td>
					<td>
						<input id="compra" type="button" value="Comprar" class="btn btn-info" onclick="#" />
					</td>  
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>