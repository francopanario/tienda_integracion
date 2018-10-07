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
	<form id="usuarios" method="post" action="Inicio?action=admUsuarios" class="form-horizontal" role="form">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>DNI</th>
					<th>Username</th>
					<th>Email</th>
					<th>Password</th>
					<th>Tipo</th>
					<th>Telefono</th>
					<th>Direccion</th>
					<th>Estado</th>			
				</tr>
			</thead>
			<tbody>
				<% List<Usuario> usuarios = Controlador.getInstancia().getAllUsuarios();
			  		Usuario usuario;    
			  		
				%>
				<% for (Iterator<Usuario> i = usuarios.iterator(); i.hasNext();) {
					usuario = i.next();
				%>
				<tr>
					<td><%out.print(usuario.getUsuario_id());%></td>
					<td><%out.print(usuario.getUsername());%></td>
					<td><%out.print(usuario.getMail());%></td>
					<td>*******</td>
					<td><%out.print(usuario.getTipo_usuario());%></td>
					<td><%out.print(usuario.getTelefono());%></td>
					<td><%out.print(usuario.getDireccion());%></td>
					<td><%
							if (usuario.isActivo()){
								out.print("<p style='max-width:20px; background-color: #33cc33;'>&nbsp;</p>");
							}else{
								out.print("<p style='max-width:20px; background-color: #ff0000;'>&nbsp;</p>");
							}
						%>
					</td>					
					<td><button id="btn-editar" name="usuarioId" value="<%out.print(usuario.getUsuario_id());%>" type="submit" class="btn btn-success">Editar</button></td>					
				</tr>
				<%				
					}
				%>				
			</tbody>
		</table>
	</form>
</div>