package usuarioUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import controlador.Controlador;
import exceptions.UsuarioException;
import negocio.Usuario;

public class loginFallido2 {

	@Test
	public void test() throws UsuarioException {
		//password erronea
		String username = "santi";
		String password = "fallido";
		Usuario usuario = Controlador.getInstancia().existeUsuario(username,password);
		assertFalse("Login fallido",usuario.getUsuario_id().equals(null));
	}

}
