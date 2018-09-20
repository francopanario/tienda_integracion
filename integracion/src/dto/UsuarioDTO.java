package dto;

import java.io.Serializable;

public class UsuarioDTO implements Serializable{

	/**
	 * Yo soy un DTO, asi que tengo solo estado, no tengo comportamiento de ningun tipo, solo acciones asociadas a la presentacion y/o trasferencia de datos
	 * */
	private static final long serialVersionUID = 9142896418624834351L;
	private String usuario_id;
	private String username;
	private String password;
	private String telefono;
	private String mail;
	private String direccion;
	private String tipo_usuario;
	
	public UsuarioDTO() {}

	public UsuarioDTO(String usuario_id, String username, String password, String telefono, String mail,
			String direccion, String tipo_usuario) {
		super();
		this.usuario_id = usuario_id;
		this.username = username;
		this.password = password;
		this.telefono = telefono;
		this.mail = mail;
		this.direccion = direccion;
		this.tipo_usuario = tipo_usuario;
	}

	public String getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(String usuario_id) {
		this.usuario_id = usuario_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTipo_usuario() {
		return tipo_usuario;
	}

	public void setTipo_usuario(String tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}
	
	
	
	
}
