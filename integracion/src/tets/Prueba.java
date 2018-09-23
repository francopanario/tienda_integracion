package tets;

import controlador.Controlador;
import dto.ProductoDTO;
import dto.UsuarioDTO;
import exceptions.ProductoException;
import exceptions.UsuarioException;

public class Prueba {

	public static void main(String[] args) throws ProductoException, UsuarioException {
		//Controlador.getInstancia().nuevoUsuario("123", "asda", "234", "asdas", "asd", "asd", "asd",true);
		//Controlador.getInstancia().nuevoProducto("0000001","coca cola",40,"123",true);
		//Controlador.getInstancia().bajaProducto("0000001");
		/*ProductoDTO p=  Controlador.getInstancia().buscarProdutoById("0000001");
		UsuarioDTO u=  Controlador.getInstancia().buscarUsuarioById("123");
		System.out.println(u.getUsername());*/
		//Controlador.getInstancia().modificarUsuario("123","asda", "234", "asd", "asd", "asd",true);
		Controlador.getInstancia().modificarUsuario("0000001","coca cola",40,"123",true);
	}

}
