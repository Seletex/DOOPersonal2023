package co.edu.uco.tiendaonline.service.domain.cliente.rules.support.numerocelular;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.service.domain.ValidationRule;


public class ConfirmarNumeroCelularValidationRule implements ValidationRule<Boolean> 
{
	private static final ValidationRule<Boolean> instancia = new ConfirmarNumeroCelularValidationRule();
	public static final void ejecutarValidacion(final Boolean dato) {
		instancia.validator(dato);
	}
	
	@Override
	public final void validator(final Boolean dato) {
		
		validarObligatoriedad(dato);
		

	}

	

	private final void validarObligatoriedad(final Boolean dato) {
		if(dato.equals(false)) {
			throw ServiceTiendaOnlineException.crear("El validar el correo electronico es obligatorio...");
			
		}
	}
}
