package enums;

import java.io.Serializable;

public enum MediosDePago implements Serializable{
	TARJETADECREDITO, TARJETADEDEBITO, EFECTIVO, CUENTACORRIENTE;
	
	public String getValue() {
		return this.toString();
	}
}
