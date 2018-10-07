import static org.junit.Assert.*;
import controlador.*;

import org.junit.Test;

public class registracionFallida {

	@Test
	public void test() {
		Controlador.getInstancia().nuevoUsuario(null,"asdasd", "asdasd", "32424", "asdas@hotmail.com", "tu vieja", "comprador", true);
		assertEquals(true, false);
	}

}
