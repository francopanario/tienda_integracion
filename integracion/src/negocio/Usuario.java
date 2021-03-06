package negocio;

import dao.UsuarioDAO;

import entities.UsuarioEntity;

public class Usuario {

	
	private String usuario_id;
	private String username;
	private String apellido;
	private String password;
	private String telefono;
	private String mail;
	private String direccion;
	private String tipo_usuario;
	private boolean activo;
	
	
	public Usuario(UsuarioEntity Usuario) {

		this.usuario_id=Usuario.getUsuario_id();
		this.username=Usuario.getUsername();
		this.apellido=Usuario.getApellido();
		this.tipo_usuario=Usuario.getTipo_usuario();
		this.telefono=Usuario.getTelefono();
		this.password=Usuario.getPassword();
		this.mail=Usuario.getMail();
		this.direccion=Usuario.getDireccion();
		this.activo=Usuario.isActivo();
	}	
	
	public Usuario(String usuario_id, String username, String password, String telefono, String mail, String direccion,
			String tipo_usuario,String apellido, boolean activo) {
		super();
		this.usuario_id = usuario_id;
		this.username = username;
		this.password = password;
		this.telefono = telefono;
		this.mail = mail;
		this.direccion = direccion;
		this.tipo_usuario = tipo_usuario;
		this.activo=activo;
		this.apellido=apellido;
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

	public void save(){
		UsuarioDAO.getInstancia().grabar(this);
	}
	
	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	

}
