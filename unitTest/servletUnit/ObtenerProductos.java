package servletUnit;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;


import controlador.Controlador;
import negocio.Producto;
public class ObtenerProductos {

	@Before
	public void setUp() throws Exception {
		//
	}

	@Test
	public void obtenerProductos() {
		List<Producto> prod=Controlador.getInstancia().getAllProductos();
		//Controlador.getInstancia().nuevoUsuario("nameTest", "prueba", "asdasd", "32424", "asdas@hotmail.com", "tu vieja", "comprador", true);
		assertEquals(6, prod.size());
		for(int i=0;i<prod.size();i++) {
			assertNotNull(prod.get(i).getCodBarra());
		}
		
	}

}
