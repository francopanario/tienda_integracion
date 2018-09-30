package negocio;

import java.util.Date;

import entities.FacturaEntity;

public class Factura {
	
	private String facturaID;
	private Date fecha;
	private Usuario comprador;
	private Usuario vendedor;
	private Producto articulo;
	//private int cant;
	
	
	public Factura(String facturaID, Date fecha, Usuario comprador, Usuario vendedor, Producto articulo , int cant) {
		super();
		this.facturaID = facturaID;
		this.fecha = fecha;
		this.comprador = comprador;
		this.vendedor = vendedor;
		this.articulo = articulo;
		//this.cant = cant;
	}


	public Factura(FacturaEntity fa) {
		this.facturaID=fa.getFactura_id();
		this.fecha=fa.getFecha();
		this.comprador=new Usuario(fa.getComprador());
		this.vendedor=new Usuario(fa.getVendedor());
		this.articulo=new Producto(fa.getArticulo());
	}


	public String getFacturaID() {
		return facturaID;
	}


	public Date getFecha() {
		return fecha;
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


	public void setFecha(Date fecha) {
		this.fecha = fecha;
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
	
	
	
	public float getSubTotal() {
		
		return articulo.getPrecio() /* * cant*/;
	}
	
}
