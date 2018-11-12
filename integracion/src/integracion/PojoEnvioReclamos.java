package integracion;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

public class PojoEnvioReclamos {
	
	String descripcionProd;
	String dni;
	int nro_orden;
	String id_prod;
	String mail;
	float monto;
	String nombrecli;
	
	
	
	public PojoEnvioReclamos(String descripcionProd, String dni, int nro_orden, String id_prod, String mail,
			float monto, String nombrecli) {
		super();
		this.descripcionProd = descripcionProd;
		this.dni = dni;
		this.nro_orden = nro_orden;
		this.id_prod = id_prod;
		this.mail = mail;
		this.monto = monto;
		this.nombrecli = nombrecli;
	}
	public String getDescripcionProd() {
		return descripcionProd;
	}
	public void setDescripcionProd(String descripcionProd) {
		this.descripcionProd = descripcionProd;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public int getNro_orden() {
		return nro_orden;
	}
	public void setNro_orden(int nro_orden) {
		this.nro_orden = nro_orden;
	}
	public String getId_prod() {
		return id_prod;
	}
	public void setId_prod(String id_prod) {
		this.id_prod = id_prod;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public float getMonto() {
		return monto;
	}
	public void setMonto(float monto) {
		this.monto = monto;
	}
	public String getNombrecli() {
		return nombrecli;
	}
	public void setNombrecli(String nombrecli) {
		this.nombrecli = nombrecli;
	}
	
	
	
	
}
