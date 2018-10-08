package productoUnitTest;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import controlador.Controlador;
import exceptions.ProductoException;
import exceptions.UsuarioException;
import negocio.Usuario;

public class altaProductoFallida {

	@Test
	public void test() throws UsuarioException,ProductoException {
		Random rand = new Random();
		int  n = rand.nextInt(999999999) + 111111111;
		String usuario = "fpanario";
		String password = "asdasd";
		Usuario usuar = Controlador.getInstancia().existeUsuario(usuario,password);
		assertFalse("Login fallido",usuar.getUsuario_id().equals(null));
		String nombre = "Pizza";
		String precio = String.valueOf(52.2);
		Controlador.getInstancia().nuevoProducto(null, nombre, Float.valueOf(precio), usuario, password);

	}

}
