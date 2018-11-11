package integracion;

public class PojoEnvioCompra {
	
	String nro_orden;
	ClientePojo cliente;
	ProductoPojo producto;
	
	public PojoEnvioCompra(String nro_orden, ClientePojo cliente, ProductoPojo producto) {
		super();
		this.nro_orden = nro_orden;
		this.cliente = cliente;
		this.producto = producto;
	}

	public String getNro_orden() {
		return nro_orden;
	}

	public void setNro_orden(String nro_orden) {
		this.nro_orden = nro_orden;
	}

	public ClientePojo getCliente() {
		return cliente;
	}

	public void setCliente(ClientePojo cliente) {
		this.cliente = cliente;
	}

	public ProductoPojo getProducto() {
		return producto;
	}

	public void setProducto(ProductoPojo producto) {
		this.producto = producto;
	}
	
	
	
	
}
