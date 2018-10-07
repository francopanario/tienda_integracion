package negocio;

import dao.ReclamoDAO;
import dao.UsuarioDAO;
import entities.ReclamoEntity;
import entities.UsuarioEntity;

public class Reclamo {
	
	private String reclamo_id;
	private String detalles;
	boolean activo;
	
	
	public Reclamo(ReclamoEntity Reclamo) {

		this.reclamo_id  = Reclamo.getReclamo_id();
		this.detalles    = Reclamo.getDetalles();
		this.activo      = Reclamo.isActivo();
	}	
	
	public Reclamo(String reclamo_id, String reclamo, boolean activo) {
		super();
		this.reclamo_id = reclamo_id;
		this.detalles = reclamo;		
		this.activo  = activo;
	}
	
	public void save(){
		ReclamoDAO.getInstancia().grabar(this);
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

	public void setActivo(boolean activo) {
		this.activo = activo;
	}


}
