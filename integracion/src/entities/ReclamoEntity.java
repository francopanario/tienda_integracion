package entities;

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
