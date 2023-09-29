package co.edu.uco.tiendaonline.data.entity.support;

public class NumeroCelularClienteEntity {
	private String numeroCelular;
	private boolean numeroCelularConfirmado;

	private NumeroCelularClienteEntity(String numeroCelular, boolean numeroCelularConfirmado) {
		setNumeroCelular(numeroCelular);
		setNumeroCelularConfirmado(numeroCelularConfirmado);
	}
	
	public static final NumeroCelularClienteEntity crear(String numeroCelular, boolean numeroCelularConfirmado) {
		return new NumeroCelularClienteEntity(numeroCelular, numeroCelularConfirmado);
	}

	public String getNumeroCelular() {
		return numeroCelular;
	}

	public void setNumeroCelular(String numeroCelular) {
		this.numeroCelular = numeroCelular;
	}

	public boolean getNumeroCelularConfirmado() {
		return numeroCelularConfirmado;
	}

	public void setNumeroCelularConfirmado(boolean numeroCelularConfirmado) {
		this.numeroCelularConfirmado = numeroCelularConfirmado;
	}
}