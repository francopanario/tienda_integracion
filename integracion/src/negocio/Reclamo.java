package negocio;

import dao.FacturaDAO;
import dao.ReclamoDAO;
import dao.UsuarioDAO;
import entities.ReclamoEntity;
import entities.UsuarioEntity;
import exceptions.FacturaException;

public class Reclamo {
	
	private String reclamo_id;
	private String detalles;
	private String estado;
	boolean activo;
	private Factura factura;
	
	
	public Reclamo(ReclamoEntity Reclamo) {
		this.reclamo_id  = Reclamo.getReclamo_id();
		this.detalles    = Reclamo.getDetalles();
		this.activo      = Reclamo.isActivo();
		this.estado      = Reclamo.getEstado();
		this.factura     = new Factura(Reclamo.getFactura());
	}	
	
	public Reclamo(String reclamo_id, String reclamo, boolean activo, String estado, Factura factura) {
		super();
		this.reclamo_id = reclamo_id;
		this.detalles   = reclamo;		
		this.activo     = activo;
		this.estado     = estado;
		this.factura    = factura;
	}	
	
	public String getReclamo_id() {
		return reclamo_id;
	}

	public void setReclamo_id(String reclamo_id) {
		this.reclamo_id = reclamo_id;
	}

	public String getDetalles() {
		return detalles;
	}

	public void setDetalles(String reclamo) {
		this.detalles = reclamo;
	}

	public boolean isActivo() {
		return activo;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public void save() throws FacturaException{
		ReclamoDAO.getInstancia().grabar(this);
	}
}
