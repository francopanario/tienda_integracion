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
	<form method="post" action="Administrador?action=modificarUsuario">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>DNI</th>
					<th>Username</th>
					<th>Apellido</th>
					<th>Email</th>
					<th>Password</th>
					<th>Tipo</th>
					<th>Telefono</th>
					<th>Direccion</th>
					<th>Estado</th>					
				</tr>
			</thead>
			<tbody>
				<% Usuario usuario = Controlador.getInstancia().buscarUsuarioById(request.getParameter("usuarioId"));%>
				<tr>
					<td><%out.print(usuario.getUsuario_id());%></td>
					<td><input style="max-width: 60px;" type="text" value="<%out.print(usuario.getUsername());%>" name="username" id="username" /></td>
					<td><input style="max-width: 60px;" type="text" value="<%out.print(usuario.getMail());%>" name="mail" id="mail" /></td>
					<td><input style="max-width: 60px;" type="text" value="<%out.print(usuario.getApellido());%>" name="apellido" id="apellido" /></td>
					<td><input style="max-width: 60px;" type="text" value="<%out.print(usuario.getPassword());%>" name="password" id="password" /></td>
					<td><input style="max-width: 60px;" type="text" value="<%out.print(usuario.getTipo_usuario());%>" name="tipo" id="tipo" /></td>
					<td><input style="max-width: 60px;" type="text" value="<%out.print(usuario.getTelefono());%>" name="telefono" id="telefono" /></td>
					<td><input style="max-width: 60px;" type="text" value="<%out.print(usuario.getDireccion());%>" name="direccion" id="direccion" /></td>
					<td>
						<select type="text" class="form-control" name="estado" placeholder="estado" style="max-width: 90px;">
							<option value="true">Activar</option>
							<option value="false">Desactivar</option>
						</select>
					</td>
					<td><button name="usuarioId" value=<%out.print(usuario.getUsuario_id());%> class="btn btn-success" type="submit">Editar</button></td>								
				</tr>						
			</tbody>
		</table>
	</form>
</div>
</body>