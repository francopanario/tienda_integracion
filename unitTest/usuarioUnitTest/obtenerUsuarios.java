package usuarioUnitTest;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;


import controlador.*;
import negocio.Usuario;

import org.junit.Test;


public class obtenerUsuarios {
	

	@Test
	public void test() throws ServletException, IOException {
		
		List<Usuario> users = Controlador.getInstancia().getAllUsuarios();
		assertTrue(0<users.size());
	}

}
