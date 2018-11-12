<!DOCTYPE html>
<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" href="css/custom.css">
<html>
<body onload="myFunction();">



<script>
function myFunction() {
	
    alert("Lo sentimos, la cantidad supera el Stock disponible :(");
}
</script>

<div  class="col-md-4 text-center boton-volver">
	<h2>No hay stock suficiente. Intente con otra cantidad.</h2>
	<form id="volverComp" method="post" action="Comprador?action=volverComp">
	 <button name="codBarra" value="volverComp" class="btn btn-success" type="submit" id="volverComp" >Volver</button>
	</form>
</div>




</body>
</html>
