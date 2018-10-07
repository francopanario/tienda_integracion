package productoUnitTest;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import controlador.Controlador;

public class altaProducto {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Random rand = new Random();
		int  n = rand.nextInt(999999999) + 111111111;
		String usuario = "fpanario";
		String password = "asdasd";
		String nombre = "Milanesa";
		String precio = String.valueOf(52.2);
		Controlador.getInstancia().nuevoProducto(String.valueOf(n), nombre, Float.valueOf(precio), usuario, password);
	}

}
