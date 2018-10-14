<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<div class="container">
	<div id="loginbox" style="margin-top: 50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
	<%
		String login_msg=(String)request.getAttribute("error");  
		if(login_msg!=null){
			out.println("<font color=red size=4px>"+login_msg+"</font>");
		}
	%>
		<div class="panel panel-info">
			<div class="panel-heading">
				<div class="panel-title">Ingresar</div>
			</div>
			<div style="padding-top: 30px" class="panel-body">
				<div style="display: none" id="login-alert"
					class="alert alert-danger col-sm-12">
				</div>
				<form id="loginform" method="post" action="Inicio?action=login" class="form-horizontal" role="form">
					<div style="margin-bottom: 25px" class="input-group">
						<span class="input-group-addon">
							<i class="glyphicon glyphicon-user"></i>
						</span> 
						<input id=username" type="text" class="form-control" name="username" 
							placeholder="Username" />
					</div>
					<div style="margin-bottom: 25px" class="input-group">
						<span class="input-group-addon">
							<i class="glyphicon glyphicon-lock"></i>
						</span>
						<input id="login-password" type="password" class="form-control" name="password"
							placeholder="Password" />
					</div>
					<div style="margin-top: 10px" class="form-group">
						<!-- #################################### BOTON SUBMIT ####################################-->
						<div class="col-sm-6 controls">
							<button id="btn-login" type="submit" class="btn btn-success">Loguearse</button>
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-12 control">
							<div style="border-top: 1px solid #888; padding-top: 15px; font-size: 85%">
								¿ No tienes cuenta ?
								<a href="#"	onClick="$('#loginbox').hide(); $('#signupbox').show()">Registrarse </a>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	<div id="signupbox" style="display: none; margin-top: 50px" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
		<div class="panel panel-info">
			<div class="panel-heading">
				<div class="panel-title">Registracion</div>
				<div style="float: right; font-size: 85%; position: relative; top: -10px">
					<a id="signinlink" href="#" onclick="$('#signupbox').hide(); $('#loginbox').show()">Loguearse</a>
				</div>
			</div>
			<div class="panel-body">
				<form id="signupform" method="post" action="Inicio?action=altaCliente" class="form-horizontal" role="form">
					<div id="signupalert" style="display: none"	class="alert alert-danger">
						<p>Error:</p>
						<span></span>
					</div>
					<div class="form-group">
						<label for="dni" class="col-md-3 control-label">DNI</label>
						<div class="col-md-9">
							<input type="text" class="form-control" name="dni" placeholder="DNI"  required ="true"/>
						</div>
					</div>					
					<div class="form-group">
						<label for="mail" class="col-md-3 control-label">Mail</label>
						<div class="col-md-9">
							<input type="text" class="form-control" name="mail"	placeholder="Mail"  required ="true" />
						</div>
					</div>
					<div class="form-group">
						<label for="username" class="col-md-3 control-label">Username</label>
						<div class="col-md-9">
							<input type="text" class="form-control" name="username"	placeholder="Username"  required ="true"/>
						</div>
					</div>					
					<div class="form-group">
						<label for="password" class="col-md-3 control-label">Password</label>
						<div class="col-md-9">
							<input type="password" class="form-control" name="password"	placeholder="Password"  required ="true"/>
						</div>
					</div>
					<div class="form-group">
						<label for="direccion" class="col-md-3 control-label">Direccion</label>
						<div class="col-md-9">
							<input type="text" class="form-control" name="direccion" placeholder="Direccion"  required ="true"/>
						</div>
					</div>
					<div class="form-group">
						<label for="telefono" class="col-md-3 control-label">Telefono</label>
						<div class="col-md-9">
							<input type="text" class="form-control" name="telefono"	placeholder="Telefono" required ="true" />
						</div>
					</div>
					<div class="form-group">
						<label for="tipo_usuario" class="col-md-3 control-label">Tipo Usuario</label>
						<div class="col-md-9">
							<select type="text" class="form-control" name="tipo_usuario" placeholder="Tipo Usuario"  required ="true">
								<option value="comprador">Comprador</option>
								<option value="vendedor">Vendedor</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<!-- #################################### BOTON SUBMIT ####################################-->
						<div class="col-md-offset-3 col-md-9">
							<button id="btn-signup" type="submit" class="btn btn-info">
								<i class="icon-hand-right">Registrarse</i>
							</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>