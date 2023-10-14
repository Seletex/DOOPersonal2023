package co.edu.uco.tiendaonline.service.dto.support;

public final class CorreoElectronicoClienteDTO {
	private String correoElectronico;
	private boolean confirmacionCorreoElectronico;

	
	public CorreoElectronicoClienteDTO() {
		super();
	}

	private CorreoElectronicoClienteDTO(final String correoElectronico,final boolean confirmacionCorreoElectronico) {
	setCorreoElectronico(correoElectronico);
	setConfirmacionCorreoElectronico(confirmacionCorreoElectronico);
	}
	
	public static final CorreoElectronicoClienteDTO crear(final String correoElectronico,final boolean confirmacionCorreoElectronico) {
		return new CorreoElectronicoClienteDTO(correoElectronico, confirmacionCorreoElectronico);
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	private void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public boolean isConfirmacionCorreoElectronico() {
		return confirmacionCorreoElectronico;
	}

	private void setConfirmacionCorreoElectronico(boolean confirmacionCorreoElectronico) {
		this.confirmacionCorreoElectronico = confirmacionCorreoElectronico;
	}
}