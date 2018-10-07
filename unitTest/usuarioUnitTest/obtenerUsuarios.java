package usuarioUnitTest;

import static org.junit.Assert.*;

import java.util.List;

import controlador.*;
import negocio.Usuario;

import org.junit.Test;

public class obtenerUsuarios {

	@Test
	public void test() {
		List<Usuario> users = Controlador.getInstancia().getAllUsuarios();
		assertEquals(6, users.size());
		for(int i=0;i<users.size();i++) {
			assertNotNull(users.get(i).getUsuario_id());
		}
		
	}

}
