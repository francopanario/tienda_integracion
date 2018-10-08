package usuarioUnitTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import controlador.Controlador;
import exceptions.FacturaException;
import exceptions.UsuarioException;
import negocio.Factura;
import negocio.Producto;

public class misCompras {

	@Test
	public void test() throws UsuarioException,FacturaException{
		String usuario = "asd";
		String password = "asd";
		
		 List<Factura> facturas = Controlador.getInstancia().getAllFacturasComprador(usuario,password);
		assertTrue(0<facturas.size());   
		for(int i =0;i<facturas.size();i++) {
			System.out.println(facturas.get(i).getFacturaID()+"  "+ facturas.get(i).getTotal());
		}
	}
	

}
