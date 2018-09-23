package tets;

import controlador.Controlador;
import dto.ProductoDTO;
import exceptions.ProductoException;

public class Prueba {

	public static void main(String[] args) throws ProductoException {
		//Controlador.getInstancia().nuevoUsuario("123", "asda", "234", "asdas", "asd", "asd", "asd",true);
		//Controlador.getInstancia().nuevoProducto("0000001","coca cola",40,"123",true);
		ProductoDTO p=  Controlador.getInstancia().buscarProdutoById("0000001");
		System.out.println(p.getCodBarra());		
	}

}
