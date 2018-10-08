package productoUnitTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import controlador.Controlador;
import exceptions.ProductoException;
import exceptions.UsuarioException;
import negocio.Producto;

public class misProductos {

	@Test
	public void test() throws UsuarioException,ProductoException {
		String usuario = "fpanario";
		String password = "asdasd";
		
		List<Producto> productos = Controlador.getInstancia().getAllProductosVendedor(usuario,password);
		assertTrue(0<productos.size());   
	}

}
