package co.edu.uco.tiendaonline.service.domain.cliente.rules;

import java.sql.Date;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.util.UtilFecha;

import co.edu.uco.tiendaonline.service.domain.ValidationRule;

public class FechaNacimientoValidationRule implements ValidationRule<Date> {

	private static final ValidationRule<Date> instancia = new FechaNacimientoValidationRule();
	public static final void ejecutarValidacion(final Date dato) {
		instancia.validator(dato);
	}
	
	@Override
	public final void validator(final Date dato) {

		validarObligatoriedad(dato);
		validarFormato(dato);

	}

	

	private final void validarObligatoriedad(final Date dato) {
		if(UtilFecha.estaNulo(dato)) {
			throw ServiceTiendaOnlineException.crear("El nombre del tipo de identificación es un dato obligatorio...");
			
		}
	}

	private final void validarFormato(final Date dato) {
		if(dato.equals(UtilFecha.FECHA_POR_DEFECTO_TEXTO)) {
			throw ServiceTiendaOnlineException.crear("El nombre del tipo de identificación solo puede contener letras...");
			
		}
	}
}
