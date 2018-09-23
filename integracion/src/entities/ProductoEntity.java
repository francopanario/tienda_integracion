package entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import negocio.Usuario;

@Entity
@Table(name="productos")
public class ProductoEntity {
	
	
	@Id
	@Column (name="codBarra")
	private String codBarra;
	private String nombre;
	private float precio;	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="usuario_id")
	private UsuarioEntity usuario;
	
	
	public ProductoEntity() {}	
	
	public ProductoEntity(String codBarra, String nombre, float precio) {
		super();
		this.codBarra = codBarra;
		this.nombre = nombre;
		this.precio = precio;		
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
	
	public UsuarioEntity getUsuario() {
		return usuario;
	}
	
	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}
	
}
