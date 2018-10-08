package productoUnitTest;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import controlador.Controlador;
import exceptions.ProductoException;
import exceptions.UsuarioException;
import negocio.Usuario;

public class altaProductoFallidaDuplicado {

	@Test
	public void test() throws UsuarioException,ProductoException {
		String usuario = "fpanario";
		String password = "asdasd";
		Usuario usuar = Controlador.getInstancia().existeUsuario(usuario,password);
		assertFalse("Login fallido",usuar.getUsuario_id().equals(null));
		String nombre = "Pan";
		String precio = String.valueOf(52.2);
		Controlador.getInstancia().nuevoProducto("46456", nombre, Float.valueOf(precio), usuario, password);
	}

}
