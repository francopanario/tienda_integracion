<head>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
</head>
<body>
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
          <li><a href="venMisProductos.jsp">Mis Productos</a></li>  
          <li class="active"><a>Subir Producto</a></li>
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
<div align="center">
	<div id="loginbox" style="margin-top: 50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
		<div class="panel panel-info">
			<div class="panel-heading">
				<h2>Subir Producto<h2>
			</div>
			<div style="padding-top: 30px" class="panel-body">
				<div style="display: none" id="login-alert"
					class="alert alert-danger col-sm-12">
				</div>
				<form id="loginform" method="post" action="Vendedor?action=subirProducto" class="form-horizontal" role="form">
					<div style="margin-bottom: 25px" class="input-group">
						<span class="input-group-addon">
							<i class="glyphicon glyphicon-user"></i>
						</span> 
						<input id="nombre" type="text" class="form-control" name="nombre" 
							placeholder="Nombre..." />
					</div>
					<div style="margin-bottom: 25px" class="input-group">
						<span class="input-group-addon">
							<i class="glyphicon glyphicon-user"></i>
						</span> 
						<input id="precio" type="number" class="form-control" name="precio" 
							placeholder="Precio..." />
					</div>
					<div style="margin-bottom: 25px" class="input-group">
						<span class="input-group-addon">
							<i class="glyphicon glyphicon-user"></i>
						</span> 
						<input id="ruta" type="file" class="form-control" name="ruta" 
							placeholder="Imagen..." />
					</div>
					<div style="margin-top: 10px" class="form-group">
						<!-- #################################### BOTON SUBMIT ####################################-->
						<div class="col-sm-12 controls">
							<button id="btn-login" type="submit" class="btn btn-success">Subir</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>