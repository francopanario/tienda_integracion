package usuarioUnitTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import controlador.Controlador;
import exceptions.UsuarioException;
import negocio.Producto;
import negocio.Usuario;

public class visibilidadDelComprador {



	@Test
	public void test() throws UsuarioException {
		//Logueo al usuario
		String username = "santi";
		String password = "asdasd";
		Usuario usuario = Controlador.getInstancia().existeUsuario(username,password);
		assertFalse("Login fallido",usuario.getUsuario_id().equals(null));
		
		
		//Obtener productos
		List<Producto> productos = Controlador.getInstancia().getAllProductos();
		assertTrue(0<productos.size());
		
		for(int i =0;i<productos.size();i++) {
			System.out.println(productos.get(i).getNombre());
		}
	}

}
