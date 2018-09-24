package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "facturas")
public class FacturaEntity {

	
	public FacturaEntity() {
		super();
	}
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int facturaID;

	private Date fecha;
	
	
	@ManyToOne
	@JoinColumn(name = "id_comprador")
	private UsuarioEntity comprador;
	
	@ManyToOne
	@JoinColumn(name = "id_vendedor")
	private UsuarioEntity vendedor;
	
	
	@OneToOne
	private ProductoEntity articulo;


	public FacturaEntity(int facturaID, Date fecha, UsuarioEntity comprador, UsuarioEntity vendedor,
			ProductoEntity articulo) {
		super();
		this.facturaID = facturaID;
		this.fecha = fecha;
		this.comprador = comprador;
		this.vendedor = vendedor;
		this.articulo = articulo;
	}


	public int getFacturaID() {
		return facturaID;
	}


	public Date getFecha() {
		return fecha;
	}


	public UsuarioEntity getComprador() {
		return comprador;
	}


	public UsuarioEntity getVendedor() {
		return vendedor;
	}


	public ProductoEntity getArticulo() {
		return articulo;
	}


	public void setFacturaID(int facturaID) {
		this.facturaID = facturaID;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public void setComprador(UsuarioEntity comprador) {
		this.comprador = comprador;
	}


	public void setVendedor(UsuarioEntity vendedor) {
		this.vendedor = vendedor;
	}


	public void setArticulo(ProductoEntity articulo) {
		this.articulo = articulo;
	}
	
	
	
}
