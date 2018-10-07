package productoUnitTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;


import controlador.Controlador;
import negocio.Producto;
public class ObtenerProductos {


	@Test
	public void obtenerProductos() {
		List<Producto> prod=Controlador.getInstancia().getAllProductos();
		assertEquals(6, prod.size());
		for(int i=0;i<prod.size();i++) {
			assertNotNull(prod.get(i).getCodBarra());
		}
		
	}

}
