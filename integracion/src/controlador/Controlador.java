package controlador;


import negocio.Factura;

import negocio.Producto;

import java.sql.Date;
import java.util.List;


import dao.ProductoDAO;


import entities.ProductoEntity;

import exceptions.ProductoException;
import exceptions.UsuarioException;
import negocio.Usuario;
import dao.UsuarioDAO;
import entities.UsuarioEntity;

public class Controlador {
	

	private static Controlador instancia;
	

	private Controlador() { }
	
	
	public static Controlador getInstancia(){
		if(instancia == null)
			instancia = new Controlador();
		return instancia;
	}
	
	String username;
	String password;
	
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setearUsuario (String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	//ProductoABM
	
	
	public void nuevoProducto(String codBarra, String nombre, float precio, String usuario_id,boolean activo)
	{
		Usuario usuario;
		try {
			usuario = new Usuario((UsuarioEntity)UsuarioDAO.getInstancia().findById(usuario_id));
			Producto producto = new Producto(codBarra,nombre,precio,activo);
			producto.setUsuario(usuario);			
			producto.save();
		} catch (UsuarioException e) {
			e.printStackTrace();
		}		
	}
	
	public Producto buscarProdutoById(String codBarra) throws ProductoException{
		return ProductoDAO.getInstancia().getProductoById(codBarra);
	}
	
	public void bajaProducto(String codBarra) {
		try {
			ProductoDAO.getInstancia().bajaProducto(codBarra);						
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	public void modificarUsuario(String codBarra, String nombre, float precio, String usuario_id, boolean b) {
		try {
			ProductoDAO.getInstancia().modificarProducto(codBarra,nombre,precio,usuario_id,b);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}	
	
	//UsuarioABM
	
	
	public void nuevoUsuario(String usuario_id,String username , String password,  String telefono,String mail,String direccion,String tipo_usuario, boolean activo)
	{	
		
		try {
			Usuario usuario = new Usuario(usuario_id, username, password, telefono, mail, direccion, tipo_usuario,activo);
			usuario.save();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Usuario buscarUsuarioById(String usuario_id) throws UsuarioException{
		return UsuarioDAO.getInstancia().getUsuarioById(usuario_id);
	}

	public void bajaUsuario(String usuario_id) {
		try {
			UsuarioDAO.getInstancia().bajaUsuario(usuario_id);						
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void modificarUsuario(String usuario_id,String username, String mail, String direccion, String telefono, String tipo_usuario,
			boolean b) {
		try {
			UsuarioDAO.getInstancia().modificarUsuario(usuario_id,username,mail,direccion,telefono,tipo_usuario,b);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public Usuario existeUsuario(String username, String password) throws UsuarioException {
		return UsuarioDAO.getInstancia().existeUsuario(username,password);		
	}

	
	// ############################ TIENDA ############################ 
	
	public List<Producto> getAllProductos() {
		return ProductoDAO.getInstancia().getAll();
	}
	
	// Factura ABM
	
	public void nuevaFactura(String factura_id, String comprador_username,String comprador_password, String vendedor_id,String producto_id)
	{
		Usuario comprador;
		Usuario vendedor;
		Producto articulo;
		try {
			System.out.println("comprador   "+comprador_username+"    "+comprador_password+" vendedor   "+vendedor_id+"   producto"+producto_id);
			comprador = existeUsuario(comprador_username, comprador_password);
			vendedor = new Usuario((UsuarioEntity)UsuarioDAO.getInstancia().findById(vendedor_id));
			articulo = new Producto((ProductoEntity)ProductoDAO.getInstancia().getProductoEntityById(producto_id));
			
			Factura factura=new Factura(factura_id, comprador, vendedor, articulo, 2);		
			factura.save();
		} catch (UsuarioException e) {
			e.printStackTrace();
		} catch (ProductoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	

}
