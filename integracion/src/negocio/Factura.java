package negocio;

import java.util.Date;

public class Factura {
	
	private int facturaID;
	private Date fecha;
	private Usuario comprador;
	private Usuario vendedor;
	private Producto articulo;
	//private int cant;
	
	
	public Factura(int facturaID, Date fecha, Usuario comprador, Usuario vendedor, Producto articulo , int cant) {
		super();
		this.facturaID = facturaID;
		this.fecha = fecha;
		this.comprador = comprador;
		this.vendedor = vendedor;
		this.articulo = articulo;
		//this.cant = cant;
	}


	public int getFacturaID() {
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

	
	/*public int getCant() {
		return cant;
	}*/

	public void setFacturaID(int facturaID) {
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
	
	
	/*public void setCant (int cant) {
		this.cant= cant;
	}*/
	
	
	public float getSubTotal() {
		
		return articulo.getPrecio() /* * cant*/;
	}
	
}
