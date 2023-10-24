package co.edu.uco.tiendaonline.service.domain.cliente.rules.support.correo;

import java.sql.Date;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.util.UtilFecha;
import co.edu.uco.tiendaonline.service.domain.ValidationRule;

public class ConfirmacionCorreoElectronicoValidationRule implements ValidationRule<Boolean>//implements ValidationRule<boolean> {
{
	private static final ValidationRule<Boolean> instancia = new ConfirmacionCorreoElectronicoValidationRule();
	public static final void ejecutarValidacion(final Boolean dato) {
		instancia.validator(dato);
	}
	
	@Override
	public final void validator(final Boolean dato) {
		
		validarObligatoriedad(dato);
		

	}

	

	private final void validarObligatoriedad(final Boolean dato) {
		
		if(dato.equals( extracted())) {
			throw ServiceTiendaOnlineException.crear("El validar el correo electronico es obligatorio...");
			
		}
	}

	private Date extracted() {
		return UtilFecha.asignarPorDefecto();
	}

}
