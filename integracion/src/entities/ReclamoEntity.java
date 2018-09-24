package entities;

<<<<<<< HEAD
import javax.persistence.*;
=======
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Entity;
>>>>>>> branch 'master' of https://github.com/francopanario/tienda_integracion.git

@Entity
@Table(name="reclamos")
public class ReclamoEntity {
	
	@Id
	@Column(name="reclamo_id")
	private String reclamo_id;
	private String detalles;
	
	
	public void ReclamoEntity() {}

	public ReclamoEntity(String reclamo_id, String detalles) {
		super();
		this.reclamo_id = reclamo_id;
		this.detalles = detalles;
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
}
