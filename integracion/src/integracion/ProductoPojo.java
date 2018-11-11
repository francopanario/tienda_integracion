package integracion;

public class ProductoPojo {
	
	String codBarra;
	int cantidad;
	
	public ProductoPojo(String codBarra, int cantidad) {
		super();
		this.codBarra = codBarra;
		this.cantidad = cantidad;
	}

	public String getCodBarra() {
		return codBarra;
	}

	public void setCodBarra(String codBarra) {
		this.codBarra = codBarra;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
	

}
