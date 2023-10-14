package co.edu.uco.tiendaonline.service.dto.support;

public class NumeroCelularClienteDTO {
	private String numeroCelular;
	private boolean numeroCelularConfirmado;

	private NumeroCelularClienteDTO() {
		
	}
	
	private NumeroCelularClienteDTO(String numeroCelular, boolean numeroCelularConfirmado) {
		setNumeroCelular(numeroCelular);
		setNumeroCelularConfirmado(numeroCelularConfirmado);
	}
	
	public static final NumeroCelularClienteDTO crear(String numeroCelular, boolean numeroCelularConfirmado) {
		return new NumeroCelularClienteDTO(numeroCelular, numeroCelularConfirmado);
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