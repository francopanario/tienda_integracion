package dto;

import java.io.Serializable;

import negocio.Usuario;

public class ProductoDTO implements Serializable{

	/**
	 * Yo soy un DTO, asi que tengo solo estado, no tengo comportamiento de ningun tipo, solo acciones asociadas a la presentacion y/o trasferencia de datos
	 * */
	private static final long serialVersionUID = 9142896418624834351L;
	private String codBarra;
	private String nombre;
	private float precio;
	private UsuarioDTO usuario;
	
	public ProductoDTO() {}

	public ProductoDTO(String codBarra, String nombre, float precio, UsuarioDTO usuario) {
		super();
		this.codBarra = codBarra;
		this.nombre = nombre;
		this.precio = precio;
		this.usuario = usuario;
	}

	public String getCodBarra() {
		return codBarra;
	}

	public void setCodBarra(String codBarra) {
		this.codBarra = codBarra;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}
	
	
	
	
	

	
	
	
}
