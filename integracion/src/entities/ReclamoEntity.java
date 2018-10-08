package entities;


import javax.persistence.*;
@Entity
@Table(name="reclamos")
public class ReclamoEntity {
	
	@Id
	@Column(name="reclamo_id")
	private String reclamo_id;
	private String detalles;
	private String estado;
	private boolean activo;
	
	@OneToOne
	@JoinColumn(name = "factura_id")
	private FacturaEntity factura;

	public void ReclamoEntity() {}
	

	public ReclamoEntity(String reclamo_id, String detalles, boolean b, String estado) {
		super();
		this.reclamo_id = reclamo_id;
		this.detalles = detalles;
		this.activo=b;
		this.estado=estado;
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

	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}

	public boolean isActivo() {
		return activo;
	}
	
	public FacturaEntity getFactura() {
		return factura;
	}

	public void setFactura(FacturaEntity factura) {
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
}
