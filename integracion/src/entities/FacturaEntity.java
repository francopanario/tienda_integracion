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

import negocio.Factura;

@Entity
@Table(name = "facturas")
public class FacturaEntity {

	
	public FacturaEntity() {
		super();
	}
	
	@Id
	@Column(name = "factura_id")
	private String factura_id;

	private String medio;
	private int cantidad;
	
	@OneToOne
	@JoinColumn(name = "comprador_id")
	private UsuarioEntity comprador;
	
	@OneToOne
	@JoinColumn(name = "vendedor")
	private UsuarioEntity vendedor;
	
	
	@OneToOne
	@JoinColumn(name = "producto_id")
	private ProductoEntity articulo;


	public FacturaEntity(String factura_id, String medio, int cantidad) {
		super();
		this.factura_id = factura_id;
		this.medio = medio;
		this.cantidad = cantidad;
	}
	

	public String getFactura_id() {
		return factura_id;
	}


	public void setFactura_id(String factura_id) {
		this.factura_id = factura_id;
	}


	public UsuarioEntity getVendedor() {
		return vendedor;
	}


	public void setVendedor(UsuarioEntity vendedor) {
		this.vendedor = vendedor;
	}


	public String getfactura_id() {
		return factura_id;
	}




	public UsuarioEntity getComprador() {
		return comprador;
	}


	

	public ProductoEntity getArticulo() {
		return articulo;
	}


	public void setfactura_id(String factura_id) {
		this.factura_id = factura_id;
	}


	

	public void setComprador(UsuarioEntity comprador) {
		this.comprador = comprador;
	}


	

	public void setArticulo(ProductoEntity articulo) {
		this.articulo = articulo;
	}


	public Factura toNegocio(FacturaEntity facturaEntity) {
		return new Factura(facturaEntity);
	}


	public String getMedio() {		
		return medio;
	}


	public void setMedio(String medio) {
		this.medio = medio;
	}


	public int getCant() {
		return cantidad;
	}
	
	public void setCant(int cant) {
		this.cantidad = cant;
	}
	
	
}
