package productoUnitTest;

import static org.junit.Assert.*;


import java.util.List;

import org.junit.Before;
import org.junit.Test;


import controlador.Controlador;
import negocio.Producto;
public class obtenerProductos {


	@Test
	public void obtenerProductos() {
		List<Producto> prod=Controlador.getInstancia().getAllProductos();
		assertTrue(0<prod.size());
	}

}
