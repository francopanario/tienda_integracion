package usuarioUnitTest;

import static org.junit.Assert.*;
import controlador.*;
import exceptions.UsuarioException;
import negocio.Usuario;

import org.junit.Test;

public class loginFallido1 {

	@Test
	public void test() throws UsuarioException {
		String username = "fallido";
		String password = "asdasd";
		Usuario usuario = Controlador.getInstancia().existeUsuario(username,password);
		assertFalse("Login fallido",usuario.getUsuario_id().equals(null));
	}

}
