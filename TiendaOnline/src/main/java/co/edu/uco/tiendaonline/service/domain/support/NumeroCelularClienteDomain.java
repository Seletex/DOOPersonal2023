package co.edu.uco.tiendaonline.service.domain.support;

public class NumeroCelularClienteDomain {
	private String numeroCelular;
	private boolean numeroCelularConfirmado;

	public NumeroCelularClienteDomain() {
		
	}
	
	private NumeroCelularClienteDomain(String numeroCelular, boolean numeroCelularConfirmado) {
		setNumeroCelular(numeroCelular);
		setNumeroCelularConfirmado(numeroCelularConfirmado);
	}
	
	public static final NumeroCelularClienteDomain crear(String numeroCelular, boolean numeroCelularConfirmado) {
		return new NumeroCelularClienteDomain(numeroCelular, numeroCelularConfirmado);
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