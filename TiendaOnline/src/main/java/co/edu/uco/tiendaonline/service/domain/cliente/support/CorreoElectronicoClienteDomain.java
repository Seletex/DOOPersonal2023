package co.edu.uco.tiendaonline.service.domain.cliente.support;

import co.edu.uco.tiendaonline.crosscutting.util.UtilTexto;

public final class CorreoElectronicoClienteDomain {
	private String correoElectronico;
	private boolean confirmacionCorreoElectronico;

	
	public CorreoElectronicoClienteDomain() {
		setCorreoElectronico(UtilTexto.VACIO);
		setConfirmacionCorreoElectronico(false);
	}

	private CorreoElectronicoClienteDomain(final String correoElectronico,final boolean confirmacionCorreoElectronico) {
	setCorreoElectronico(correoElectronico);
	setConfirmacionCorreoElectronico(confirmacionCorreoElectronico);
	}
	
	public static final CorreoElectronicoClienteDomain crear(final String correoElectronico,final boolean confirmacionCorreoElectronico) {
		return new CorreoElectronicoClienteDomain(correoElectronico, confirmacionCorreoElectronico);
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