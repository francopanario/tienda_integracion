package controlador;


import negocio.Factura;

import negocio.Producto;
import negocio.Reclamo;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import org.json.JSONException;
import org.json.simple.JSONObject;

import dao.FacturaDAO;
import dao.ProductoDAO;
import dao.ReclamoDAO;
import entities.ProductoEntity;
import exceptions.FacturaException;
import exceptions.ProductoException;
import exceptions.UsuarioException;
import integracion.Almacen;
import integracion.EnviarCsv;
import javafx.scene.image.Image;
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
	
	
	public void nuevoProducto(String codBarra, String nombre, float precio,  String comprador_username,String comprador_password)
	{
		Usuario usuario;
		try {
			usuario = existeUsuario(comprador_username, comprador_password);
			Producto producto = new Producto(codBarra,nombre,precio,true);
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
	
	public void modificarProducto(String codBarra, String nombre, float precio, String estado) {
		try {
			ProductoDAO.getInstancia().modificarProducto(codBarra,nombre,precio, estado);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public Producto getProductoVendedor(String codBarra) throws ProductoException {
		return ProductoDAO.getInstancia().getProductoById(codBarra);	
	}
	
	
	//UsuarioABM
	
	
	public void nuevoUsuario(String apellido,String usuario_id,String username , String password,  String telefono,String mail,String direccion,String tipo_usuario, boolean activo)
	{	
		
		try {
			Usuario usuario = new Usuario(usuario_id, username, password, telefono, mail, direccion, tipo_usuario,apellido,activo);
			usuario.save();
		} catch (Exception e) {
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
			String b,String apellido) {
		try {
			UsuarioDAO.getInstancia().modificarUsuario(usuario_id,username,mail,direccion,telefono,apellido,tipo_usuario,b);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public Usuario existeUsuario(String username, String password) throws UsuarioException {
		return UsuarioDAO.getInstancia().existeUsuario(username,password);		
	}

	public List<Usuario> getAllUsuarios() {
		return UsuarioDAO.getInstancia().getUsuarios();
	}
	
	// ############################ TIENDA ############################ 
	
	public List<Producto> getAllProductos() {
		return ProductoDAO.getInstancia().getAll();
	}
	
	public List<Producto> getAllProductosVendedor(String username,String password) throws UsuarioException {
		Usuario us=existeUsuario(username, password);
		return ProductoDAO.getInstancia().getAllVendedor(us.getUsuario_id());
	}
	
	// Factura ABM
	
	public void nuevaFactura(String factura_id, String comprador_username,String comprador_password, String producto_id, String cant, String medio)
	{
		Usuario comprador;
		Usuario vendedor;
		Producto articulo;
		try {
			comprador = existeUsuario(comprador_username, comprador_password);
			articulo = new Producto((ProductoEntity)ProductoDAO.getInstancia().getProductoEntityById(producto_id));
			vendedor = ProductoDAO.getInstancia().getVendedorAsociado(producto_id);
			int cantidad = Integer.parseInt(cant);
			float total = articulo.getPrecio() * cantidad;
			Factura factura=new Factura(factura_id, comprador, vendedor, articulo, cantidad, medio, total);
			factura.save();
		} catch (UsuarioException e) {
			e.printStackTrace();
		} catch (ProductoException e) {
			e.printStackTrace();
		}
	}
	
	public List<Factura> getAllFacturasVendedor(String username,String password) throws UsuarioException {
		Usuario us=existeUsuario(username, password);
		return FacturaDAO.getInstancia().getAllFacturasVendedor(us.getUsuario_id());
	}
	
	public List<Factura> getAllFacturasComprador(String username,String password) throws UsuarioException {
		Usuario us=existeUsuario(username, password);
		return FacturaDAO.getInstancia().getAllFacturasComprador(us.getUsuario_id());
	}
	
	public void ingresarReclamo(String n, String detalles,boolean b, String estado, String facturaId) throws FacturaException {
		System.out.println(facturaId);
		Factura fac = FacturaDAO.getInstancia().getFacturaById(facturaId);
		Reclamo recla = new Reclamo(n,detalles,b,estado,fac);
		recla.save();
	}
	
	public Factura getFactura(String facturaID) throws FacturaException {
		return FacturaDAO.getInstancia().getFacturaById(facturaID);
	}
	
	public List<Reclamo> getAllReclamos(){		
		return ReclamoDAO.getInstancia().getAll();		
	}

	public int consultarStock(String url) throws Exception {
		return Almacen.consultarStock(url);
	}



	public void enviarCompra(String url, Factura fac) {
		Almacen.enviarCompra(url, fac);
		
	}



	public List<Factura> getAllFacturasDay(java.util.Date truncatedDate) {
		return FacturaDAO.getInstancia().getAllFacturasDay(truncatedDate);
	}



	public void generarCsv() throws IOException, JSONException {
		EnviarCsv.traerFacturas();
		
	}

}
