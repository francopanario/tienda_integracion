package negocio;

import entities.ProductoEntity;
import entities.UsuarioEntity;

public class Producto {
	
	private String codBarra;
	private String nombre;
	private float precio;
	private Usuario usuario;
	
	public Producto(ProductoEntity Producto) {
		this.codBarra = Producto.getCodBarra();
		this.nombre   = Producto.getNombre();
		this.precio   = Producto.getPrecio();
		this.usuario  = new Usuario(Producto.getUsuario());
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
