package productoUnitTest;

import static org.junit.Assert.*;

import org.hibernate.validator.AssertTrue;
import org.junit.Test;

import controlador.Controlador;
import exceptions.ProductoException;

public class modificacionProductoFallida {

	@Test
	public void test() throws ProductoException {
		String codBarra = "464746";
		String nombre =  "lays";
		String estado =  "true";
		float precio = Float.parseFloat("54");
		Controlador.getInstancia().modificarProducto(codBarra, nombre, precio, estado);
		
	}

}
