package usuarioUnitTest;

import static org.junit.Assert.*;
import controlador.Controlador;
import exceptions.UsuarioException;
import negocio.Usuario;

import org.junit.Test;

public class loginExitoso {

	@Test
	public void test() throws UsuarioException {
		String username = "santi";
		String password = "asdasd";
		Usuario usuario = Controlador.getInstancia().existeUsuario(username,password);
		assertFalse("Login fallido",usuario.getUsuario_id().equals(null));

	}

}
