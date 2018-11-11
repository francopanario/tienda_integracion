package integracion;

public class ClientePojo {
	
	String nombre;
	String apellido;
	String mail;
	String direccion;
	
	public ClientePojo(String nombre, String apellido, String mail, String direccion) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
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
	
	
	
	
	
}
