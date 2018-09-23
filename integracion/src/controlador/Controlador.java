package controlador;

import negocio.Club;
import negocio.Jugador;
import negocio.Producto;
import dao.ClubDAO;
import dao.JugadorDAO;
import dao.ProductoDAO;
import dto.JugadorDTO;
import dto.ProductoDTO;
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
	
	public void nuevoUsuario(String usuario_id,String username , String password,  String telefono,String mail,String direccion,String tipo_usuario, boolean activo)
	{	
		
		try {
			Usuario usuario = new Usuario(usuario_id, username, password, telefono, mail, direccion, tipo_usuario,activo);
			System.out.println(usuario.getUsername());
			usuario.save();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
