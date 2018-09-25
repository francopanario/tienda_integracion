package controlador;

import negocio.Club;
import negocio.Jugador;
import negocio.Producto;

import java.util.List;

import dao.ClubDAO;
import dao.JugadorDAO;
import dao.ProductoDAO;
import dto.JugadorDTO;
import dto.ProductoDTO;
import dto.UsuarioDTO;
import entities.ClubEntity;
import exceptions.ClubException;
import exceptions.JugadorException;
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
	
	
	/*public JugadorDTO getJugadorByDNI(String tipo, Integer numero) throws JugadorException
	{
		return JugadorDAO.getInstance().getJugadorById(tipo, numero).toDTO();
	}
	
	public void nuevoJugador(String tipo, int numero, String nombre, Integer idClub)
	{
		Club club;
		try {
			club = new Club((ClubEntity)ClubDAO.getInstance().findByID(idClub));
			Jugador jugador = new Jugador(tipo,numero,nombre);
			jugador.setClub(club);
			jugador.setCategoria(88);
			jugador.save();
		} catch (ClubException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}*/
	
	
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
	
	public ProductoDTO buscarProdutoById(String codBarra) throws ProductoException{
		return ProductoDAO.getInstancia().getProductoById(codBarra).toDTO();
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
	
	public UsuarioDTO buscarUsuarioById(String usuario_id) throws UsuarioException{
		return UsuarioDAO.getInstancia().getUsuarioById(usuario_id).toDTO();
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

}
