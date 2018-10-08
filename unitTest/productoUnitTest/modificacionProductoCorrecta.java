package productoUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import controlador.Controlador;
import exceptions.ProductoException;

public class modificacionProductoCorrecta {

	@Test
	public void test() throws ProductoException {
		String codBarra = "233044163";
		String nombre =  "lays";
		String estado =  "true";
		float precio = Float.parseFloat("54");
		Controlador.getInstancia().modificarProducto(codBarra, nombre, precio, estado);
		
	}

}
