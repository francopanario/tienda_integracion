package usuarioUnitTest;

import static org.junit.Assert.*;

import org.hibernate.AssertionFailure;

import controlador.*;

import org.junit.Test;

public class registracionFallida {

	@Test
	public void test() {
		Controlador.getInstancia().nuevoUsuario(null,"asdasd", "asdasd", "32424", "asdas@hotmail.com", "tu vieja", "comprador", true);
		assertTrue("Faltan campos", false);

	}

}
