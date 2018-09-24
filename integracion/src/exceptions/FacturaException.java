package exceptions;

public class FacturaException extends Exception{

	private static final long serialVersionUID = -4629783524891278708L;

	public FacturaException(String mensaje) {
		super(mensaje);
	}
}
