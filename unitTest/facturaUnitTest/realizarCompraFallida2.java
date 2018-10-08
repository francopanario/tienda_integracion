package facturaUnitTest;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;

import org.junit.Test;

import controlador.Controlador;
import exceptions.FacturaException;
import exceptions.ProductoException;
import exceptions.UsuarioException;
import negocio.Producto;
import negocio.Usuario;

public class realizarCompraFallida2 {

	@Test
	public void test() throws UsuarioException,ProductoException,FacturaException {
		String username = "santi";
		String password = "asdasd";
		Usuario usuario = Controlador.getInstancia().existeUsuario(username,password);
		assertFalse("Login fallido",usuario.getUsuario_id().equals(null));
		
		
		List<Producto> prod=Controlador.getInstancia().getAllProductos();
		assertTrue(0<prod.size());
		for(int i =0;i<prod.size();i++) {
			System.out.println(prod.get(i).getNombre());
		}
		
		
		Random rand = new Random();
		int  n = rand.nextInt(999999999) + 111111111;
		String codBarra = "395824021";
		String medio = "tarjeta";
		Controlador.getInstancia().nuevaFactura(String.valueOf(n), username, password, codBarra, "-1", medio);
	}
	

}
