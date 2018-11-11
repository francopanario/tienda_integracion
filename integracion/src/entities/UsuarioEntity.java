package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import negocio.Producto;
import negocio.Usuario;

@Entity
@Table(name="usuarios")
public class UsuarioEntity {
	
	
	@Id
	@Column(name="usuario_id")
	private String usuario_id;
	private String username;
	private String apellido;
	private String password;
	private String telefono;
	private String mail;
	private String direccion;
	private String tipo_usuario;
	private boolean activo;
	
	
	public UsuarioEntity() {}	
	
	public UsuarioEntity(String usuario_id, String username, String password, String telefono, String mail,
			String direccion,String apellido, String tipo_usuario,boolean activo) {
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

	public void dummyMetodo()
	{
		System.out.println("Soy un objeto de negocio por que tengo comportamiento");
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public Usuario toNegocio(UsuarioEntity usuarioEntity) {
		return new Usuario(usuarioEntity);
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	
	
}
