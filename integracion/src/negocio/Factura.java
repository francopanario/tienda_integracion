package negocio;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import dao.FacturaDAO;
import entities.FacturaEntity;

public class Factura {
	
	private String facturaID;
	 @JsonUnwrapped
	private Usuario comprador;
	 @JsonUnwrapped
	private Usuario vendedor;
	 @JsonUnwrapped
	private Producto articulo;
	private String medio;
	private int cantidad;
	private float total;
	
	
	public Factura(String facturaID, Usuario comprador, Usuario vendedor, Producto articulo , int cantidad, String medio, float total) {
		super();
		this.facturaID = facturaID;
		this.comprador = comprador;
		this.vendedor  = vendedor;
		this.articulo  = articulo;
		this.cantidad  = cantidad;
		this.medio     = medio;		
		this.total     = total;
	}

	public Factura(FacturaEntity fa) {
		this.facturaID = fa.getFactura_id();
		this.comprador = new Usuario(fa.getComprador());
		this.vendedor  = new Usuario(fa.getVendedor());
		this.articulo  = new Producto(fa.getArticulo());
		this.medio     = fa.getMedio();
		this.cantidad  = fa.getCant();
		this.total     = fa.getTotal();
		
	}

	public String getMedio() {
		return medio;
	}


	public void setMedio(String medio) {
		this.medio = medio;
	}


	public String getFacturaID() {
		return facturaID;
	}

	public Usuario getComprador() {
		return comprador;
	}

	public Usuario getVendedor() {
		return vendedor;
	}

	public Producto getArticulo() {
		return articulo;
	}

	public void setFacturaID(String facturaID) {
		this.facturaID = facturaID;
	}

	public void setComprador(Usuario comprador) {
		this.comprador = comprador;
	}

	public void setVendedor(Usuario vendedor) {
		this.vendedor = vendedor;
	}

	public void setArticulo(Producto articulo) {
		this.articulo = articulo;
	}	
	
	public int getCant() {
		return cantidad;
	}


	public void setCant(int cant) {
		this.cantidad = cant;
	}
	
	
	

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public void save() {
		FacturaDAO.getInstancia().grabar(this);		
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
}
