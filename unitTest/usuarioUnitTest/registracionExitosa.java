package usuarioUnitTest;

import static org.junit.Assert.*;
import controlador.*;
import java.util.*;
import servlet.Inicio;

import org.junit.Test;

import com.sun.net.httpserver.Authenticator.Success;

public class registracionExitosa {

	@Test
	public void test() {
		Controlador.getInstancia().nuevoUsuario("nameTest", "prueba", "asdasd", "32424", "asdas@hotmail.com", "tu vieja", "comprador", true);
		assertEquals(true, true);
		
	}

}
