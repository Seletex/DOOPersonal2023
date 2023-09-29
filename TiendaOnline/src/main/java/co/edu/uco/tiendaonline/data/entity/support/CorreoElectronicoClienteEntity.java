package co.edu.uco.tiendaonline.data.entity.support;

public final class CorreoElectronicoClienteEntity {
	private String correoElectronico;
	private boolean confirmacionCorreoElectronico;

	private CorreoElectronicoClienteEntity(final String correoElectronico,final boolean confirmacionCorreoElectronico) {
	setCorreoElectronico(correoElectronico);
	setConfirmacionCorreoElectronico(confirmacionCorreoElectronico);
	}
	
	public static final CorreoElectronicoClienteEntity crear(final String correoElectronico,final boolean confirmacionCorreoElectronico) {
		return new CorreoElectronicoClienteEntity(correoElectronico, confirmacionCorreoElectronico);
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