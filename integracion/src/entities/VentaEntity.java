package entities;

import javax.persistence.*;

<<<<<<< HEAD
=======

>>>>>>> branch 'master' of https://github.com/francopanario/tienda_integracion.git
@Entity
@Table(name="ventas")
public class VentaEntity {
	
	@Id
	@Column (name="venta_id")
	private String venta_id;
	private boolean activo;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="usuario_id")
	private UsuarioEntity comprador;	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="usuario_id")
	private UsuarioEntity vendedor;	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="reclamo_id")
	private ReclamoEntity reclamo;	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="producto_id")
	private ProductoEntity producto;
	
	
	public VentaEntity() {}	
	
	public VentaEntity(String venta_id, boolean activo, UsuarioEntity comprador, UsuarioEntity vendedor,
			ReclamoEntity reclamo, ProductoEntity producto) {
		super();
		this.venta_id = venta_id;
		this.activo = activo;
		this.comprador = comprador;
		this.vendedor = vendedor;
		this.reclamo = reclamo;
		this.producto = producto;
	}
	public String getVenta_id() {
		return venta_id;
	}
	public void setVenta_id(String venta_id) {
		this.venta_id = venta_id;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public UsuarioEntity getComprador() {
		return comprador;
	}
	public void setComprador(UsuarioEntity comprador) {
		this.comprador = comprador;
	}
	public UsuarioEntity getVendedor() {
		return vendedor;
	}
	public void setVendedor(UsuarioEntity vendedor) {
		this.vendedor = vendedor;
	}
	public ReclamoEntity getReclamo() {
		return reclamo;
	}
	public void setReclamo(ReclamoEntity reclamo) {
		this.reclamo = reclamo;
	}
	public ProductoEntity getProducto() {
		return producto;
	}
	public void setProducto(ProductoEntity producto) {
		this.producto = producto;
	}
}
