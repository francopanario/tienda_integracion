package usuarioUnitTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import controlador.Controlador;
import exceptions.FacturaException;
import exceptions.UsuarioException;
import negocio.Factura;

public class misVentas {

	@Test
	public void test() throws UsuarioException,FacturaException {
		
		String usuario = "fpanario";
		String password = "asdasd";
		List<Factura> facturas = Controlador.getInstancia().getAllFacturasVendedor(usuario,password);
		assertTrue("No hay ventas",0<facturas.size()); 
		
		for(int i =0;i<facturas.size();i++) {
			System.out.println(facturas.get(i).getFacturaID());
		}
	}

}
